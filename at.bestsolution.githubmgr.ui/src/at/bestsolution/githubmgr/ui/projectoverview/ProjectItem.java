package at.bestsolution.githubmgr.ui.projectoverview;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.LabelBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import at.bestsolution.githubmgr.model.githubmgr.Project;

class ProjectItem {
	
	private final Project project;
	
	private BooleanProperty active = new SimpleBooleanProperty(this,"active",false);

	private BorderPane container;
	
	private Callback<Project, Void> openProjectCallback;
	
	@Inject
	public ProjectItem(Project project) {
		this.project = project;
	}
	
	@PostConstruct
	public void init(VBox parent) {
		container = new BorderPane();
		container.setFocusTraversable(true);
		container.getStyleClass().add("projecItem");
		container.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				active.set(true);
				event.consume();
			}
		});
		
		{
			ImageView view = new ImageView(new Image(getClass().getClassLoader().getResource("/icons/generic_project.png").toExternalForm()));
			container.setLeft(view);
		}
		
		{
			VBox box = new VBox();
			box.getStyleClass().add("projectInfoArea");
			box.getChildren().add(LabelBuilder.create().styleClass("projectTitle").text(project.getName()).build());
			box.getChildren().add(LabelBuilder.create().styleClass("projectDescription").text("No Description").build());
			container.setCenter(box);		
		}
		
		{
			ImageView view = new ImageView(new Image(getClass().getClassLoader().getResource("/icons/arrow-right.png").toExternalForm()));
			BorderPane.setAlignment(view, Pos.CENTER_RIGHT);
			container.setRight(view);
			view.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					if( openProjectCallback != null ) {
						openProjectCallback.call(project);
					}
				}
			});
		}
		
		parent.getChildren().add(container);
		active.addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				if( newValue ) {
					container.getStyleClass().add("activeItem");
					container.requestFocus();
				} else {
					container.getStyleClass().remove("activeItem");
				}
			}
		});
	}
	
	public BooleanProperty activeProperty() {
		return active;
	}

	public Project getProject() {
		return project;
	}

	public Node node() {
		return container;
	}
	
	public void setOpenProjectCallback(
			Callback<Project, Void> openProjectCallback) {
		this.openProjectCallback = openProjectCallback;
	}
}
