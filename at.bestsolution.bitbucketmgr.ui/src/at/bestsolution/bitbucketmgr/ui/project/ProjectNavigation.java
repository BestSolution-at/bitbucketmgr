package at.bestsolution.bitbucketmgr.ui.project;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;

public class ProjectNavigation {
	@PostConstruct
	void init(BorderPane pane) {
		pane.setTop(new Label("NAVI"));
	}
}
