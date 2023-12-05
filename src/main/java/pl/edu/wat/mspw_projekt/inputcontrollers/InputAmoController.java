package pl.edu.wat.mspw_projekt.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.List;

public class InputAmoController {

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;

    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju amunicji");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        generateTextField("NAZWA", 0);
        generateTextField("SKRÓT", 1);
        generateTextField("KOD", 2);
        generateTextField("KOD NATO", 3);
        generateTextField("KALIBER", 4);
        generateTextField("SZTUK W PACZCE", 5);
        generateTextField("MASA SZTUKI", 6);
        generateTextField("WYM PACZKI X", 7);
        generateTextField("WYM PACZKI Y", 8);
        generateTextField("WYM PACZKI Z", 9);
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
        generateChoiceBox("KATEGORIA", 10, options1);
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
        generateChoiceBox("R GŁOWYCY BOJ", 11, options2);
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
        generateChoiceBox("R GŁOWICY NAPR", 12, options3);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options4 = Arrays.asList(
                "BRAK",
                "RADIOWE",
                "PRZEWODOWE",
                "SAMONAPROWADZANIE PASYWNE",
                "SAMONAPROWADZANIE POLAKTYWNE",
                "SAMONAPROWADZANIE AKTYWNE"
        );
        generateChoiceBox("R NAPR", 13, options4);
    }

    private void generateTextField(String name, int row) {
        Label label = new Label(name);
        TextField textField = new TextField();

        // Nadanie identyfikatorów
        label.setId("label" + row);
        textField.setId("textField" + row);

        // Dodajemy kontrolki do GridPane
        inputGridPane.add(label, 0, row); // Kolumna 0, wiersz row
        inputGridPane.add(textField, 1, row); // Kolumna 1, wiersz row
    }


    private void generateChoiceBox(String name, int row, List<String> choices) {
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
