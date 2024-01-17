package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;

import java.util.Arrays;
import java.util.List;

public class InputSysOgnController {

    // ODNOŚNIK DO GRIDPANE W PLIKU FXML - STATYCZNIE STWORZONY
    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju systemu ognia");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA", 0);
        controller.generateTextField(inputGridPane,"SKROT","SKROT", 1);
        controller.generateTextField(inputGridPane,"SZYBKOSTRZELNOSC", "SZYBKOSTRZELNOŚĆ 1/MIN",2);
        controller.generateTextField(inputGridPane,"KALIBER", "KALIBER",3);
        controller.generateTextField(inputGridPane,"DLUG_SERII", "DLUG_SERII", 4);
        controller.generateTextField(inputGridPane,"CZAS_CELOWANIA", "CZAS_CELOWANIA", 5);
        controller.generateTextField(inputGridPane,"KLASA_PRZYRZ_OC","KLASA PRZYRZ OC", 6);
        controller.generateTextField(inputGridPane,"LICZBA_KAN_CEL", "LICZBA_KAN_CEL", 7);

        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "ARMATA",
                "ARMATOHAUBICA",
                "HAUBICA",
                "MOŹDZIEŻ",
                "GRANATNIK",
                "DZIAŁKO",
                "KARABIN",
                "WYRZUTNIA PK",
                "WYRZUTNIA PNK",
                "ZASOBNIK BOMB K",
                "ZASOBNIK BOMB NK",
                "WYRZUTNIA TORPED",
                "STAWIACZ MIN"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_SYSTEMU_OGN_FK", "RODZAJ_SYSTEMU_OGN_FK", 8, options1);
        controller.generateButton(inputGridPane, "RODZAJ_SYSTEMU_OGN_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 8);
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
