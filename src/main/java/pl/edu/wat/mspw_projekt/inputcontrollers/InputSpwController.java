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

public class InputSpwController {

    @FXML
    private GridPane inputGridPane;
    @FXML
    private GridPane inputGridPane2;
    @FXML
    private GridPane inputGridPane3;
    @FXML
    private Label labelTitle;

    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego SPW");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        generateTextField(inputGridPane,"NAZWA", 0);
        generateTextField(inputGridPane,"SKRÓT", 1);
        generateTextField(inputGridPane,"KOD", 2);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "NIEOKREŚLONA",
                "CZOŁG",
                "BWP",
                "TO",
                "SAMOB_NIEOPANC_SR_OG_PPANC",
                "PRZENOS_SROD_OGN_PPANC",
                "SMIGLOWIEC_BOJOWY",
                "SAMOBIEZ_NIEOPANC_WRIA",
                "HOL_WRIA",
                "PRZEN_WRIA",
                "SAMOBIEZ_OPANC_WRIA",
                "PRZENOS_SROD_OGN_OPL",
                "SAMOBIEZ_NIEOPANC_SROD_OGN_OPL",
                "SAMOBIEZ_OPANC_SROD_OGN_OPL",
                "LOTNICTWO_TAKTYCZNE",
                "BEZPILOT_STATKI_LAT",
                "KARABINY",
                "SAMOBIEZ_ZESTAW_MOSTOWY",
                "SAMOCHOD_CIEZAROWY",
                "PRZYCZEPA",
                "NACZEPA"
        );
        generateChoiceBox(inputGridPane,"KLASA", 3, options1);

        generateTextField(inputGridPane,"OBSŁUGA", 4);
        generateTextField(inputGridPane,"KOSZT JEDN CYKLU ŻYCIA", 5);
        generateTextField(inputGridPane,"KOSZT JEDN NABYCIA", 6);
        generateTextField(inputGridPane,"KOSZT JEDN UTRZYM WYSZK PERSO", 7);
        generateTextField(inputGridPane,"MASA", 8);
        generateTextField(inputGridPane,"DŁUGOOŚĆ", 9);
        generateTextField(inputGridPane,"SZEROKOŚĆ", 10);
        generateTextField(inputGridPane,"WYSOKOŚĆ", 11);
        generateTextField(inputGridPane,"POTENCJAŁ BOJ", 12);
        generateTextField(inputGridPane,"VALUE", 13);
        generateTextField(inputGridPane2,"POJEM ZBIOR PALIWA", 0);
        generateTextField(inputGridPane2,"POJEM ZBIOR PALIWA +", 1);
        generateTextField(inputGridPane2,"POJEM AKUMULATORÓW", 2);
        generateCheckBox(inputGridPane2,"JEŻDŻĄCY",3);
        generateCheckBox(inputGridPane2,"LATAJĄCY",4);
        generateCheckBox(inputGridPane2,"PŁYWAJĄCY",5);
        generateCheckBox(inputGridPane2,"PRZENOŚNY",6);
        generateCheckBox(inputGridPane2,"CIĄGNIKOWY",7);
        generateCheckBox(inputGridPane2,"OPANCERZONY",8);
        generateTextField(inputGridPane2,"EFEKTOR ŁĄCZN FK", 9);
        generateTextField(inputGridPane2,"RODZAJ ŚRODOW FK", 10);
        generateTextField(inputGridPane2,"EFEKTOR JEZDNY FK", 11);
        generateTextField(inputGridPane2,"EFEKTOR PŁYWANIA FK", 12);
        generateTextField(inputGridPane2,"EFEKTOR INŻ FK", 13);
        generateTextField(inputGridPane3,"EFEKTOR WE FK", 0);
        generateTextField(inputGridPane3,"PARAM KADŁUBA FK", 1);
        generateTextField(inputGridPane3,"EFEKTOR TRANSP FK", 2);
        generateTextField(inputGridPane3,"KATEGORIA FK", 3);
        generateTextField(inputGridPane3,"EFEKTOR LATANIA FK", 4);
        generateTextField(inputGridPane3,"EFEKTOR ROZPOZ FK", 5);
        generateTextField(inputGridPane3,"MOC [HP]", 6);
        generateTextField(inputGridPane3,"KLASA PRZYRZ OC", 7);
        generateTextField(inputGridPane3,"ZUZ PALIWA PRACA", 8);



    }

    private void generateTextField(GridPane inputGridPane, String name, int row) {
        Label label = new Label(name);
        TextField textField = new TextField();

        // Nadanie identyfikatorów
        label.setId("label" + row);
        textField.setId("textField" + row);

        // Dodajemy kontrolki do GridPane
        inputGridPane.add(label, 0, row); // Kolumna 0, wiersz row
        inputGridPane.add(textField, 1, row); // Kolumna 1, wiersz row
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


    private void generateChoiceBox(GridPane inputGridPane, String name, int row, List<String> choices) {
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
