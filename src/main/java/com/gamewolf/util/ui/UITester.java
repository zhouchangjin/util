package com.gamewolf.util.ui;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UITester extends Application {
	
	public static String TITLE_STR="图形测试";

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		primaryStage.setTitle(TITLE_STR);
		
		Pane main = (Pane)FXMLLoader.load(new File("c:/tes12.fxml").toURL());
		Scene myScene = new Scene(main);
	    primaryStage.setScene(myScene);
	    primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
