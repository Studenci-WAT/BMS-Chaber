package pl.edu.wat.mspw_projekt.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_projekt.interfaces.ControlGenerator;
import pl.edu.wat.mspw_projekt.model.PropellantAndLubricant;
import pl.edu.wat.mspw_projekt.service.MainDao;

import java.util.Arrays;
import java.util.List;

public class InputMpsController {

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju MPS");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA", "NAZWA",0);
        controller.generateTextField(inputGridPane,"SKROT","SKRÓT", 1);
        controller.generateTextField(inputGridPane,"KOD", "KOD",2);
    }

    @FXML
    private void addButton(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        MainDao.getInstance().createRecord(
                PropellantAndLubricant.builder()
                        .name(getControlString(1))
                        .shortcut(getControlString(2))
                        .code(getControlString(3))
                        .build()
        );
        // - itp.
    }

    private String getControlString ( int index) {
        Node node = inputGridPane.getChildren().get(index);

        if(node instanceof  TextField) {
            TextField textField = (TextField) node;
            return textField.getText();
        } else if (node instanceof  Label) {
            Label label = (Label) node;
            return label.getText();
        }
        return "";
    }
}
