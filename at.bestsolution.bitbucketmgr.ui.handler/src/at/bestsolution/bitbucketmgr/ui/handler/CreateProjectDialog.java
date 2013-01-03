package at.bestsolution.bitbucketmgr.ui.handler;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.Window;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Execute;

import at.bestsolution.efxclipse.runtime.dialogs.TitleAreaDialog;

@SuppressWarnings("restriction")
public class CreateProjectDialog {
	
	@Execute
	public void openProjectDialog(Stage window, ECommandService commandService, EHandlerService handlerService) {
		ProjectDialog d = new ProjectDialog(window);
		if( d.open() == ProjectDialog.OK_BUTTON ) {
			Map<String, Object> map = new HashMap<>();
			map.put("projectName", d.getName());
			ParameterizedCommand pcmd = commandService.createCommand("at.bestsolution.bitbucketmgr.app.command.project.create", map);
			handlerService.executeHandler(pcmd);
		}
	}
	
	static class ProjectDialog extends TitleAreaDialog {

		private TextField f;

		public ProjectDialog(Window parent) {
			super(parent, "New Project", "New Project", "Enter the name for the new project", ProjectDialog.class.getClassLoader().getResource("icons/new_project_banner.png"));
		}

		public String getName() {
			return f.getText();
		}
		
		@Override
		protected Node createDialogContent() {
			HBox p = new HBox();
			p.getStyleClass().add("projectDialogArea");
			p.getChildren().add(new Label("Project name"));
			f = new TextField();
			HBox.setHgrow(f, Priority.ALWAYS);
			p.getChildren().add(f);
			
			return p;
		}
		
	}
}
