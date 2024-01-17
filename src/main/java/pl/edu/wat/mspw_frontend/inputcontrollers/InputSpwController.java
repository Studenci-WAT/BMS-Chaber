package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;

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
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego SPW");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA",  0);
        controller.generateTextField(inputGridPane,"SKROT", "SKRÓT",1);
        controller.generateTextField(inputGridPane,"KOD","KOD", 2);
        controller.generateTextField(inputGridPane,"KLASA","KLASA",  3);

        controller.generateTextField(inputGridPane,"OBSLUGA","OBSLUGA", 4);
        controller.generateTextField(inputGridPane,"KOSZT_JEDN_CYKLU_ZYCIA","KOSZT_JEDN_CYKLU_ZYCIA",  5);
        controller.generateTextField(inputGridPane,"KOSZT_JEDN_NABYCIA","KOSZT_JEDN_NABYCIA", 6);
        controller.generateTextField(inputGridPane,"KOSZT_JEDN_UTRZYM_WYSZK_PERSON", "KOSZT_JEDN_UTRZYM_WYSZK_PERSON", 7);
        controller.generateTextField(inputGridPane,"MASA", "MASA", 8);
        controller.generateTextField(inputGridPane,"DLUG","DŁUGOOŚĆ", 9);
        controller.generateTextField(inputGridPane,"SZEROK","SZEROKOŚĆ", 10);
        controller.generateTextField(inputGridPane,"WYSOK","WYSOKOŚĆ", 11);
        controller.generateTextField(inputGridPane,"POTENCJAL_BOJ", "POTENCJAL_BOJ",12);
        controller.generateTextField(inputGridPane,"VALUE", "VALUE",13);
        controller.generateTextField(inputGridPane2,"POJEM_ZBIOR_PALIWA","POJEM_ZBIOR_PALIWA",  0);
        controller.generateTextField(inputGridPane2,"POJEM_ZBIOR_PALIWA_DODAT", "POJEM_ZBIOR_PALIWA_DODAT",1);
        controller.generateTextField(inputGridPane2,"POJEM_AKUMULATOROW", "POJEM_AKUMULATOROW", 2);
        controller.generateCheckBox(inputGridPane2,"JEZDZACY", "JEŻDŻĄCY",3);
        controller.generateCheckBox(inputGridPane2,"LATAJACY","LATAJĄCY",4);
        controller.generateCheckBox(inputGridPane2,"PLYWAJACY","PŁYWAJĄCY",5);
        controller.generateCheckBox(inputGridPane2,"PRZENOSNY","PRZENOŚNY",6);
        controller.generateCheckBox(inputGridPane2,"CIAGNIONY","CIĄGNIONY",7);
        controller.generateCheckBox(inputGridPane2,"OPANCERZONY","OPANCERZONY",8);
        controller.generateTextField(inputGridPane2,"EFEKTOR_LACZN_FK", "EFEKTOR_LACZN_FK", 9);
        controller.generateButton(inputGridPane2, "EFEKTOR_LACZN_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 9);
        controller.generateTextField(inputGridPane2,"RODZAJ_SRODOW_FK","RODZAJ_SRODOW_FK",  10);
        controller.generateButton(inputGridPane2, "RODZAJ_SRODOW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 10);
        controller.generateTextField(inputGridPane2,"EFEKTOR_JEZDNY_FK", "EFEKTOR_JEZDNY_FK", 11);
        controller.generateButton(inputGridPane2, "EFEKTOR_JEZDNY_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);
        controller.generateTextField(inputGridPane2,"EFEKTOR_PLYWANIA_FK", "EFEKTOR_PLYWANIA_FK", 12);
        controller.generateButton(inputGridPane2, "EFEKTOR_PLYWANIA_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);
        controller.generateTextField(inputGridPane2,"EFEKTOR_INZ_FK", "EFEKTOR_INZ_FK", 13);
        controller.generateButton(inputGridPane2, "EFEKTOR_INZ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
        controller.generateTextField(inputGridPane3,"EFEKTOR_WE_FK", "EFEKTOR_WE_FK", 0);
        controller.generateButton(inputGridPane3, "EFEKTOR_WE_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 0);
        controller.generateTextField(inputGridPane3,"PARAM_KADLUBA_FK","PARAM_KADLUBA_FK", 1);
        controller.generateButton(inputGridPane3, "PARAM_KADLUBA_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 1);
        controller.generateTextField(inputGridPane3,"EFEKTOR_TRANSP_FK","EFEKTOR_TRANSP_FK", 2);
        controller.generateButton(inputGridPane3, "EFEKTOR_TRANSP_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 2);


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
        controller.generateChoiceBox(inputGridPane3,"KATEG_FK","KATEG_FK",  3, options1);
        controller.generateButton(inputGridPane3, "KATEG_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 3);
        controller.generateTextField(inputGridPane3,"EFEKTOR_LATANIA_FK","EFEKTOR_LATANIA_FK", 4);
        controller.generateButton(inputGridPane3, "EFEKTOR_LATANIA_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 4);
        controller.generateTextField(inputGridPane3,"EFEKTOR_ROZPOZ_FK","EFEKTOR_ROZPOZ_FK",  5);
        controller.generateButton(inputGridPane3, "EFEKTOR_ROZPOZ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 5);
        controller.generateTextField(inputGridPane3,"MOC","MOC [HP]", 6);
        controller.generateTextField(inputGridPane3,"KLASA_PRZYRZ_OC", "KLASA_PRZYRZ_OC",7);
        controller.generateTextField(inputGridPane3,"ZUZ_PALIWA_PRACA", "ZUZ_PALIWA_PRACA",8);



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
