package pl.edu.wat.mspw_projekt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    private void switchBackScene(ActionEvent event) {
        switchToScene("Home", event);
    }

    @FXML
    private void switchToScene(String sceneName, ActionEvent event) {
        try {
            // Pobranie obiektu Stage z eventu
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            String fxmlFile;
            switch(sceneName) {
                case "Scena 1":
                    fxmlFile = "input-amo-view.fxml";
                    break;
                case "Scena 2":
                    fxmlFile = "input-sys-ogn-view.fxml";
                    break;
                case "Home":
                    fxmlFile = "home-view.fxml";
                    break;
                default:
                    fxmlFile = "home-view.fxml";

            }
            System.out.println("Wybrana wartość fxmlFile: " +fxmlFile);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            root = loader.load();
            scene = new Scene(root);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
