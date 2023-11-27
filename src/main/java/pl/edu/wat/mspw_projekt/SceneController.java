package pl.edu.wat.mspw_projekt;

import pl.edu.wat.mspw_projekt.enums.Views;
import pl.edu.wat.mspw_projekt.interfaces.AbstractNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    @FXML
    private ChoiceBox<String> choiceBox;


    @FXML
    public void initialize() {
        if (choiceBox != null) {
            choiceBox.getItems().addAll("Scena 1", "Scena 2", "Home");
            choiceBox.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleChangeScene(ActionEvent event) throws IOException {
        if (choiceBox != null) {
//            System.out.println("Wybrana wartość ChoiceBox: " + choiceBox.getValue());
            String selectedScene = choiceBox.getValue();
            if (selectedScene != null) {
                switchToScene(selectedScene, event);
            } else {
                // Obsługa sytuacji, gdy selectedScene jest null
                System.out.println("Nie wybrano sceny!");
            }
        }
    }

    @FXML
    public void switchBackScene(ActionEvent event) {
        switchToScene("Home", event);
    }

    @FXML
    private void switchToScene(String sceneName, ActionEvent event) {
        try {
            String fxmlFile;

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader();
            fxmlFile = getFxmlNameByScene(sceneName);

            loader.setLocation(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());

            if(!fxmlFile.equals(Views.HOMEVIEW.getValue())){
                setNavigationInstanceForView(loader);
            }

            setStage(stage,scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setNavigationInstanceForView (FXMLLoader loader) {

                AbstractNavigationController controller;
                controller = loader.getController();

                controller.setSceneManagerController(this);
    }

    private String getFxmlNameByScene (String sceneName) {
        switch(sceneName) {
            case "Scena 1":
                return Views.AMMOFORMVIEW.getValue();
            case "Scena 2":
                return  Views.FIRESYSFORMVIEW.getValue();
            default:
                return  Views.HOMEVIEW.getValue();

        }
    }

    private void setStage (Stage stage, Scene scene) {
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

}
