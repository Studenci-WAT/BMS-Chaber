package pl.edu.wat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.util.MainDao;
import pl.edu.wat.mspw_frontend.MainViewController;

import java.io.IOException;

public class ApplicationController extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mspw_projekt/main-view.fxml"));
        Parent root = loader.load();


        MainViewController controller = loader.getController();

        // Ładowanie Widoku 1 na starcie
//        controller.loadView("home-view.fxml");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        MainDao.getInstance();
    }


    public static void main(String[] args) {
        launch(args);
    }

}