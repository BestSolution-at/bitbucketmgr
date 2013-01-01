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
package at.bestsolution.githubmgr.ui.projectoverview;

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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;

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
	void init(BorderPane pane, IEclipseContext context) {
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
		
		for( int i = 0; i < 10; i++ ) {
			final ProjectItem item = new ProjectItem(null);
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
			items.add(item);
		}
		
		scroll.setContent(box);
		pane.setCenter(scroll);
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