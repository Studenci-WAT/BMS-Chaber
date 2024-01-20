package pl.edu.wat.mspw_frontend.interfaces;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ControlGenerator {

    public void generateCheckBox(GridPane gridPane, String namePrefix, String labelText, int row) {
        Label label = new Label(labelText);
        CheckBox checkBox = new CheckBox();

        // Nadanie identyfikatorów
        label.setId(namePrefix+ "Label");
        checkBox.setId(namePrefix+ "CheckBox");

        // Dodajemy kontrolki do GridPane
        gridPane.add(label, 0, row); // Kolumna 0, wiersz row
        gridPane.add(checkBox, 1, row); // Kolumna 1, wiersz row
    }

    public TextField generateTextField(GridPane gridPane, String namePrefix, String labelText, int row) {
        Label label = new Label(labelText);
        TextField textField = new TextField();

        // Nadanie identyfikatorów
        label.setId(namePrefix + "Label");
        textField.setId(namePrefix + "TextField");

        // Dodajemy kontrolki do GridPane
        gridPane.add(label, 0, row); // Kolumna 0, wiersz row
        gridPane.add(textField, 1, row); // Kolumna 1, wiersz row

        return textField;
    }

    public ChoiceBox<String> generateChoiceBox(GridPane gridPane, String namePrefix, String labelText, int row, List<String> choices) {
        Label label = new Label(labelText);
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Nadanie identyfikatorów
        label.setId(namePrefix+ "Label");
        choiceBox.setId(namePrefix+ "ChoiceBox");

        // Ustawienie opcji wyboru w ChoiceBox
        choiceBox.setItems(FXCollections.observableArrayList(choices));

        // Dodajemy kontrolki do GridPane
        gridPane.add(label, 0, row); // Kolumna 0, wiersz row
        gridPane.add(choiceBox, 1, row); // Kolumna 1, wiersz row

        return choiceBox;
    }

    public void generateButton(GridPane gridPane, String buttonId, String buttonText, String fxmlPath, int colIndex, int rowIndex) {
        Button button = new Button(buttonText);

        // Ustawienie identyfikatora (id) przycisku
        button.setId(buttonId);

        // Ustawienie akcji przycisku
        button.setOnAction(event -> openNewWindow(fxmlPath));

        // Dodanie przycisku do GridPane
        gridPane.add(button, colIndex, rowIndex);
    }

    public void openNewWindow(String fxmlPath) {
        try {
            // Ładowanie widoku z pliku FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            if (fxmlLoader.getLocation() == null) {
                throw new IllegalArgumentException("Nie znaleziono pliku FXML: " + fxmlPath);
            }

            // Tworzenie nowego okna (Stage)
            Parent view = fxmlLoader.load();
            Stage newWindow = new Stage();
            newWindow.setScene(new Scene(view));
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace(); // Logowanie błędów
        }
    }

    public Node findControlById(GridPane gridPane, String controlId) {
        for (Node node : gridPane.getChildren()) {
            if (controlId.equals(node.getId())) {
                return node;
            }
        }
        return null;
    }
}
