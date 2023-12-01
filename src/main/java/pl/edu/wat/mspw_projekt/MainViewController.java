package pl.edu.wat.mspw_projekt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;


import java.io.IOException;

import pl.edu.wat.mspw_projekt.enums.Views;

public class MainViewController {
    @FXML
    private StackPane contentArea;

    public void loadView(String fxmlPath) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
            // Obsługa błędu
        }
    }
    @FXML
    public void navigateAmmoInput(){
        loadView(Views.AMMOFORMVIEW.getValue());
    }

    @FXML
    public void navigateTemplateInput(){
        loadView(Views.INPUTTEMPLATEVIEW.getValue());
    }
}
