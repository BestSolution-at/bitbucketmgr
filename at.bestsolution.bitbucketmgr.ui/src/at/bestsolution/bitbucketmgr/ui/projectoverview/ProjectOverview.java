/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.bitbucketmgr.ui.projectoverview;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;

import at.bestsolution.bitbucketmgr.core.EventConstants;
import at.bestsolution.bitbucketmgr.core.services.WorkspaceModelProvider;
import at.bestsolution.bitbucketmgr.model.bitbucketmgr.Project;
import at.bestsolution.bitbucketmgr.model.bitbucketmgr.Workspace;

import com.sun.javafx.scene.control.skin.ScrollPaneSkin;


@SuppressWarnings("restriction")
public class ProjectOverview {
	private List<ProjectItem> items = new ArrayList<>();
	
	private final ProjectOverviewController controller;

	private VBox box;

	private ScrollPane scroll;
	
	@Inject
	public ProjectOverview(ProjectOverviewController controller) {
		this.controller = controller;
	}
	
	@PostConstruct
	void init(BorderPane pane, IEclipseContext context, WorkspaceModelProvider wsModelProvider) {
		scroll = new ScrollPane();
		scroll.setFitToWidth(true);
		box = new VBox(10);
		EventHandler<KeyEvent> evt = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case ENTER:
					openProject();
					break;
				case UP:
					moveUp();
					break;
				case DOWN:
					moveDown();
					break;
				default:
					break;
				}
			}
		};
		
		box.setOnKeyPressed(evt);
		box.getStyleClass().add("projectItemList");
		box.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				box.requestFocus();
			}
		});
		
		Workspace ws = wsModelProvider.getWorkspace(new NullProgressMonitor());
		
		for( Project p : ws.getProjectList() ) {
			items.add(createProjectItem(p));
		}
		
		scroll.setContent(box);
		pane.setCenter(scroll);
	}
	
	@Inject
	@Optional
	public void handleProjectAdd(@UIEventTopic(EventConstants.PROJECT_TOPIC_NEW) Project newProject) {
		items.add(createProjectItem(newProject));
	}
	
	private ProjectItem createProjectItem(Project p) {
		final ProjectItem item = new ProjectItem(p);
		item.init(box);
		item.activeProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(
					ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				if( newValue ) {
					Bounds bounds = scroll.sceneToLocal(item.node().localToScene(item.node().getLayoutBounds()));
					((ScrollPaneSkin)scroll.getSkin()).onTraverse(item.node(), bounds);
					for( ProjectItem i : items ) {
						if( i != item ) {
							i.activeProperty().set(false);
						}
					}
				}
			}
		});
		item.setOpenProjectCallback(new Callback<Project, Void>() {
			
			@Override
			public Void call(Project param) {
				controller.openProject(param);
				return null;
			}
		});
		return item;
	}
	
	void moveUp() {
		for( ProjectItem i : items ) {
			if( i.activeProperty().get() ) {
				int idx = items.indexOf(i) - 1;
				if( idx >= 0 ) {
					items.get(idx).activeProperty().set(true);
					break;
				}
			}
		}
	}
	
	void moveDown() {
		for( ProjectItem i : items ) {
			if( i.activeProperty().get() ) {
				int idx = items.indexOf(i) + 1;
				if( idx < items.size() ) {
					items.get(idx).activeProperty().set(true);
					break;
				}
			}
		}
	}
	
	void openProject() {
		for( ProjectItem i : items ) {
			if( i.activeProperty().get() ) {
				controller.openProject(i.getProject());
				break;
			}
		}
	}
	
	@Focus
	void setFocus() {
		box.requestFocus();
	}
}