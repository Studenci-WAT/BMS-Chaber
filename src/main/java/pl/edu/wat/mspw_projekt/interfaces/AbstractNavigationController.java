package com.example.mspw_projekt.interfaces;

import com.example.mspw_projekt.SceneController;
import javafx.event.ActionEvent;

public interface AbstractNavigationController {
    void setSceneManagerController(SceneController sceneManagerController);
    void goBackToMainScene(ActionEvent event);
}
