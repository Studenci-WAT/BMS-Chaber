package com.example.mspw_projekt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ApplicationController extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home-view.fxml"));
        Scene scene = new Scene(loader.load());
        setStage(stage,scene);
    }


    public static void main(String[] args) {
        launch();
    }


    private void setStage (Stage stage, Scene scene) {
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}