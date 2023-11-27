package com.example.mspw_projekt;

import com.example.mspw_projekt.interfaces.AbstractNavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NavigationBackController {
    @FXML
    protected SceneController sceneController;

    public void setSceneManagerController(SceneController sceneManagerController) {
        this.sceneController = sceneManagerController;
    }

    public void goBackToMainScene(ActionEvent event) {
        this.sceneController.switchBackScene(event);
    }
}
