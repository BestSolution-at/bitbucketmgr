package at.bestsolution.githubmgr.ui.project;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class ProjectBreadcrumb {
	@PostConstruct
	void init(BorderPane pane) {
		pane.setTop(new Label("BREADCRUMB"));
	}
}
