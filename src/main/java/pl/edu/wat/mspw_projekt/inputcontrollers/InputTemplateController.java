package pl.edu.wat.mspw_projekt.inputcontrollers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_projekt.enums.Views;
import pl.edu.wat.mspw_projekt.interfaces.ControlGenerator;

import java.util.Arrays;
import java.util.List;

public class InputTemplateController{

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Template View");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek
        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"databaaseColumnName1","labelText1", 0);
        controller.generateButton(inputGridPane, "openWindowButton", "#", Views.INPUTSPWVIEW.getValue(), 2, 0);
        controller.generateTextField(inputGridPane,"databaaseColumnName2","labelText2", 1);
        controller.generateTextField(inputGridPane,"databaaseColumnName3","labelText3", 2);
        controller.generateTextField(inputGridPane,"databaaseColumnName4","labelText4", 3);
        controller.generateTextField(inputGridPane,"databaaseColumnName5","labelText5", 4);
        controller.generateTextField(inputGridPane,"databaaseColumnName6","labelText6", 5);
        controller.generateTextField(inputGridPane,"databaaseColumnName7","labelText7", 6);
        controller.generateTextField(inputGridPane,"databaaseColumnName8","labelText8", 7);
        controller.generateTextField(inputGridPane,"databaaseColumnName9","labelText9", 8);
        controller.generateTextField(inputGridPane,"databaaseColumnName10","labelText10", 9);
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
        controller.generateChoiceBox(inputGridPane,"databaaseColumnName11","labelText11", 10, options1);

        controller.generateCheckBox(inputGridPane,"databaaseColumnName12","labelText12", 11);

    }

    public void addButton(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        // - itp.

    }

}
