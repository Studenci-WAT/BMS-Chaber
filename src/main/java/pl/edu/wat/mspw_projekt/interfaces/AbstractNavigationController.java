package pl.edu.wat.mspw_projekt.interfaces;

import pl.edu.wat.mspw_projekt.SceneController;
import javafx.event.ActionEvent;

public interface AbstractNavigationController {
    void setSceneManagerController(SceneController sceneManagerController);
    void goBackToMainScene(ActionEvent event);
}
