package pl.edu.wat.mspw_projekt.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_projekt.enums.Views;
import pl.edu.wat.mspw_projekt.interfaces.ControlGenerator;

import java.util.Arrays;
import java.util.List;

public class InputAmoController {

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju amunicji");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA", 0);
        controller.generateTextField(inputGridPane,"SKROT","SKROT", 1);
        controller.generateTextField(inputGridPane,"KOD","KOD", 2);
        controller.generateTextField(inputGridPane,"KOD_NATO", "KOD_NATO", 3);
        controller.generateTextField(inputGridPane,"KALIBER", "KALIBER",4);
        controller.generateTextField(inputGridPane,"SZTUK_W_PACZCE","SZTUK_W_PACZCE", 5);
        controller.generateTextField(inputGridPane,"MASA SZTUKI","MASA SZTUKI",  6);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_X","WYM_PACZKI_X", 7);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Y", "WYM_PACZKI_Y", 8);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Z", "WYM_PACZKI_Z",9);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "NABÓJ",
                "POCISK RAKIETOWY",
                "GRANAT",
                "BOMBA",
                "TORPEDA",
                "MINA LĄDOWA",
                "MINA MORSKA"
        );
        controller.generateChoiceBox(inputGridPane,"KATEG_FK", "KATEGORIA", 10, options1);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 10);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options2 = Arrays.asList(
                "PRZEBIJAJĄCA",
                "KUMULACYJNA",
                "ODŁAMKOWA",
                "ODŁAMKOWO BURZĄCA",
                "BURZĄCA",
                "DYMNA",
                "OŚWIETLAJĄCA",
                "ZAKŁÓCAJĄCA",
                "ZAPALAJĄCA",
                "CHEMICZNA",
                "MINUJĄCA"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_BOJ_FK","RODZAJ_GLOWICY_BOJ_FK", 11, options2);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options3 = Arrays.asList(
                "BRAK",
                "RADAROWE",
                "TERMICZNE",
                "LASEROWE",
                "OPTYCZNE",
                "GPS",
                "INERCYJNE",
                "DUALNA IR UV",
                "GPS INERCYJNE"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK",12, options3);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options4 = Arrays.asList(
                "BRAK",
                "RADIOWE",
                "PRZEWODOWE",
                "SAMONAPROWADZANIE PASYWNE",
                "SAMONAPROWADZANIE POLAKTYWNE",
                "SAMONAPROWADZANIE AKTYWNE"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_NAPROW_FK","RODZAJ_NAPROW_FK", 13, options4);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
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
