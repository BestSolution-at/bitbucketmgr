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
package at.bestsolution.bitbucketmgr.app;

import java.util.concurrent.atomic.AtomicBoolean;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

import at.bestsolution.efxclipse.runtime.dialogs.MessageDialog;
import at.bestsolution.githubmgr.services.AuthentificationService;

@SuppressWarnings("restriction")
public class LifecycleHandler {
	
	private TextField username;
	private PasswordField password;

	@PostContextCreate
	boolean init(final AuthentificationService authService) {
		if( Boolean.getBoolean("githubmgr.debug") ) {
			return true;
		}
		
		final AtomicBoolean rv = new AtomicBoolean(false);
		final Stage stage = new Stage(StageStyle.TRANSPARENT);
		BorderPane pane = new BorderPane();

		{
			ImageView image = new ImageView(new Image(getClass().getClassLoader().getResource("icons/octocat_fluid.png").toExternalForm(),100,100,true,true));
			BorderPane.setAlignment(image, Pos.CENTER_LEFT);
			pane.setLeft(image);
				
		}
		
		{
			GridPane gp = new GridPane();
			
			{
				Label l = new Label("Github Login");
				l.getStyleClass().add("h1");
				gp.add(l, 0, 0, 2, 1);	
				GridPane.setHalignment(l, HPos.CENTER);
			}
			
			{
				Label l = new Label("Username");
				gp.add(l, 0, 1);	
			}
			
			{
				username = new TextField();
				gp.add(username, 1, 1);
				GridPane.setHgrow(username, Priority.ALWAYS);	
			}
			
			{
				Label l = new Label("Password");
				gp.add(l, 0, 2);	
			}
			
			{
				password = new PasswordField();
				gp.add(password, 1, 2);
				GridPane.setHgrow(password, Priority.ALWAYS);	
			}
			
			{
				HBox box = new HBox(5);
				box.setAlignment(Pos.CENTER_RIGHT);
				{
					Button b = new Button("Cancel");
					box.getChildren().add(b);
					b.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							stage.hide();
						}
					});
				}
				
				{
					Button b = new Button("Login");
					box.getChildren().add(b);
					b.setDefaultButton(true);
					b.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							// TODO We should run outside of UI-Thread
							if( authService.authentificate(new NullProgressMonitor(), username.getText(), password.getText()) ) {
								rv.set(true);
								stage.hide();
							} else {
								MessageDialog.openErrorDialog(stage, "Login failed", "Login with given username and password failed");
							}
						}
					
					});
				}
				
				gp.add(box, 1, 3);
				GridPane.setHalignment(box, HPos.RIGHT);
			}
			
			pane.setCenter(gp);
		}
		
		pane.getStyleClass().add("githubWindow");
		pane.layout();
		
		Rectangle r = new Rectangle(400, 200);
		r.setArcHeight(12);
		r.setArcWidth(12);
		r.heightProperty().bind(stage.heightProperty());
		pane.setClip(r);
		
		Scene scene = new Scene(pane);
		scene.setFill( Color.TRANSPARENT );
		scene.getStylesheets().add(getClass().getClassLoader().getResource("/css/default.css").toExternalForm());
		stage.setScene(scene);
		stage.setWidth(400);
		stage.setOpacity(0);
		
		final Timeline timeline = new Timeline();
		final KeyValue kv = new KeyValue(stage.opacityProperty(), 1.0);
		final KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();
		
		stage.showAndWait();
		return rv.get();
	}
}
