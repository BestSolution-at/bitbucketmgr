package at.bestsolution.githubmgr.ui.handler;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.Window;

import org.eclipse.e4.core.di.annotations.Execute;

import at.bestsolution.efxclipse.runtime.dialogs.TitleAreaDialog;

@SuppressWarnings("restriction")
public class CreateProjectDialog {
	
	@Execute
	public void openProjectDialog(Stage window) {
		ProjectDialog d = new ProjectDialog(window);
		if( d.open() == ProjectDialog.OK_BUTTON ) {
			
		}
	}
	
	static class ProjectDialog extends TitleAreaDialog {

		public ProjectDialog(Window parent) {
			super(parent, "New Project", "New Project", "Enter the name for the new project", ProjectDialog.class.getClassLoader().getResource("icons/new_project_banner.png"));
		}

		@Override
		protected Node createDialogContent() {
			HBox p = new HBox();
			p.getStyleClass().add("projectDialogArea");
			p.getChildren().add(new Label("Project name"));
			TextField f = new TextField();
			HBox.setHgrow(f, Priority.ALWAYS);
			p.getChildren().add(f);
			
			return p;
		}
		
	}
}
