package pl.edu.wat.mspw_projekt.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.List;

public class InputTemplateController{

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;

    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Template View");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        generateTextField(inputGridPane,"1", 0);
        generateTextField(inputGridPane,"2", 1);
        generateTextField(inputGridPane,"3", 2);
        generateTextField(inputGridPane,"4", 3);
        generateTextField(inputGridPane,"5", 4);
        generateTextField(inputGridPane,"6", 5);
        generateTextField(inputGridPane,"7", 6);
        generateTextField(inputGridPane,"8", 7);
        generateTextField(inputGridPane,"9", 8);
        generateTextField(inputGridPane,"10", 9);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7"
        );
        generateChoiceBox(inputGridPane,"11", 10, options1);

        generateCheckBox(inputGridPane,"12",11);

    }
    private void generateCheckBox(GridPane inputGridPane, String name, int row) {
        Label label = new Label(name);
        CheckBox checkBox = new CheckBox();

        // Nadanie identyfikatorów
        label.setId("labelCheckBox" + row);
        checkBox.setId("checkBox" + row);

        // Dodajemy kontrolki do GridPane
        inputGridPane.add(label, 0, row); // Kolumna 0, wiersz row
        inputGridPane.add(checkBox, 1, row); // Kolumna 1, wiersz row
    }
    private void generateTextField(GridPane inputGridPane,String name, int row) {
        Label label = new Label(name);
        TextField textField = new TextField();

        // Nadanie identyfikatorów
        label.setId("label" + row);
        textField.setId("textField" + row);

        // Dodajemy kontrolki do GridPane
        inputGridPane.add(label, 0, row); // Kolumna 0, wiersz row
        inputGridPane.add(textField, 1, row); // Kolumna 1, wiersz row
    }


    private void generateChoiceBox(GridPane inputGridPane,String name, int row, List<String> choices) {
        Label label = new Label(name);
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Nadanie identyfikatorów
        label.setId("labelChoice" + row);
        choiceBox.setId("choiceBox" + row);

        // Ustawienie opcji wyboru w ChoiceBox
        choiceBox.setItems(FXCollections.observableArrayList(choices));

        // Dodajemy kontrolki do GridPane
        inputGridPane.add(label, 0, row); // Kolumna 0, wiersz row
        inputGridPane.add(choiceBox, 1, row); // Kolumna 1, wiersz row
    }
    @FXML
    private void addButton(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        // - itp.

    }
}
