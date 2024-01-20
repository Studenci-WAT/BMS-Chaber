package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.KategoriaSpwService;
import pl.edu.wat.mspw_backend.service.SprzetWojService;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.model.SprzetWojDto;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.util.List;
import java.util.stream.Collectors;

public class InputSpwController {

    public Button button;
    @FXML
    private GridPane inputGridPane;
    @FXML
    private GridPane inputGridPane2;
    @FXML
    private GridPane inputGridPane3;
    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    private final SprzetWojService spwService = new SprzetWojService();
    private final KategoriaSpwService kategoriaSpwService = new KategoriaSpwService();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego SPW");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        List<Item> kategoryList = kategoriaSpwService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

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
        controller.generateButton(inputGridPane2, "EFEKTOR_LACZN_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 9);
        controller.generateTextField(inputGridPane2,"RODZAJ_SRODOW_FK","RODZAJ_SRODOW_FK",  10);
        controller.generateButton(inputGridPane2, "RODZAJ_SRODOW_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 10);
        controller.generateTextField(inputGridPane2,"EFEKTOR_JEZDNY_FK", "EFEKTOR_JEZDNY_FK", 11);
        controller.generateButton(inputGridPane2, "EFEKTOR_JEZDNY_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 11);
        controller.generateTextField(inputGridPane2,"EFEKTOR_PLYWANIA_FK", "EFEKTOR_PLYWANIA_FK", 12);
        controller.generateButton(inputGridPane2, "EFEKTOR_PLYWANIA_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 12);
        controller.generateTextField(inputGridPane2,"EFEKTOR_INZ_FK", "EFEKTOR_INZ_FK", 13);
        controller.generateButton(inputGridPane2, "EFEKTOR_INZ_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 13);
        controller.generateTextField(inputGridPane3,"EFEKTOR_WE_FK", "EFEKTOR_WE_FK", 0);
        controller.generateButton(inputGridPane3, "EFEKTOR_WE_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 0);
        controller.generateTextField(inputGridPane3,"PARAM_KADLUBA_FK","PARAM_KADLUBA_FK", 1);
        controller.generateButton(inputGridPane3, "PARAM_KADLUBA_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 1);
        controller.generateTextField(inputGridPane3,"EFEKTOR_TRANSP_FK","EFEKTOR_TRANSP_FK", 2);
        controller.generateButton(inputGridPane3, "EFEKTOR_TRANSP_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 2);
        controller.generateChoiceBox(inputGridPane3,"KATEG_FK","KATEG_FK",  3, kategoryList);
        controller.generateButton(inputGridPane3, "KATEG_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 3);
        controller.generateTextField(inputGridPane3,"EFEKTOR_LATANIA_FK","EFEKTOR_LATANIA_FK", 4);
        controller.generateButton(inputGridPane3, "EFEKTOR_LATANIA_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 4);
        controller.generateTextField(inputGridPane3,"EFEKTOR_ROZPOZ_FK","EFEKTOR_ROZPOZ_FK",  5);
        controller.generateButton(inputGridPane3, "EFEKTOR_ROZPOZ_FK", "#", Views.INPUTBLANKVIEW.getValue(), 2, 5);
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
        SprzetWojDto item = getValueFromControls();
        Stage stage = (Stage) button.getScene().getWindow();

        try {
            spwService.create(
                    SprzetWojDto.builder()
                            .nazwa(item.getNazwa())
                            .skrot(item.getSkrot())
                            .kod(item.getKod())
                            .kategoriaFk(item.getKategoriaFk())
                            .build());

            //clear();
            Toast.showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            Toast.showToast(stage, "Wystąpił błąd - spróbuj ponownie!", Toast.ToastType.ERROR);
        }

    }

    private SprzetWojDto getValueFromControls(){
        TextField nazwaTextField                        = (TextField) controller.findControlById(inputGridPane,"NAZWATextField");
        TextField skrotTextField                        = (TextField) controller.findControlById(inputGridPane,"SKROTTextField");
        TextField kodTextField                          = (TextField) controller.findControlById(inputGridPane,"KODTextField");
        TextField klasaTextField                        = (TextField) controller.findControlById(inputGridPane,"KLASATextField");
        TextField obslugaTextField                      = (TextField) controller.findControlById(inputGridPane,"OBSLUGATextField");
        TextField kosztJednCykluZyciaTextField          = (TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_CYKLU_ZYCIATextField");
        TextField kosztJednNabyciaTextField             = (TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_NABYCIATextField");
        TextField kosztJednUtrzymWyszkPersonTextField   = (TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_UTRZYM_WYSZK_PERSONTextField");
        TextField masaTextField                         = (TextField) controller.findControlById(inputGridPane,"MASATextField");
        TextField dlugTextField                         = (TextField) controller.findControlById(inputGridPane,"DLUGTextField");
        TextField szerokTextField                       = (TextField) controller.findControlById(inputGridPane,"SZEROKTextField");
        TextField wysokTextField                        = (TextField) controller.findControlById(inputGridPane,"WYSOKTextField");
        TextField potencjalBojTextField                 = (TextField) controller.findControlById(inputGridPane,"POTENCJAL_BOJTextField");
        TextField valueTextField                        = (TextField) controller.findControlById(inputGridPane,"VALUETextField");
        TextField pojemZbiorPaliwaTextField             = (TextField) controller.findControlById(inputGridPane2,"POJEM_ZBIOR_PALIWATextField");
        TextField pojemZbiorPaliwaDodatTextField        = (TextField) controller.findControlById(inputGridPane2,"POJEM_ZBIOR_PALIWA_DODATTextField");
        TextField pojemAkumulatorowTextField            = (TextField) controller.findControlById(inputGridPane2,"POJEM_AKUMULATOROWTextField");
        CheckBox  jezdzacyCheckBox                      = (CheckBox) controller.findControlById(inputGridPane2,"JEZDZACYCheckBox");
        CheckBox  latajacyCheckBox                      = (CheckBox) controller.findControlById(inputGridPane2,"LATAJACYCheckBox");
        CheckBox  plywajacyCheckBox                     = (CheckBox) controller.findControlById(inputGridPane2,"PLYWAJACYCheckBox");
        CheckBox  przenosnyCheckBox                     = (CheckBox) controller.findControlById(inputGridPane2,"PRZENOSNYCheckBox");
        CheckBox  ciagnionyCheckBox                     = (CheckBox) controller.findControlById(inputGridPane2,"CIAGNIONYCheckBox");
        CheckBox  opancerzonyCheckBox                   = (CheckBox) controller.findControlById(inputGridPane2,"OPANCERZONYCheckBox");
        ChoiceBox efektorLacznFkChoiceBox               = (ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_LACZN_FKChoiceBox");
        ChoiceBox rodzajSrodowFkChoiceBox               = (ChoiceBox) controller.findControlById(inputGridPane2,"RODZAJ_SRODOW_FKChoiceBox");
        ChoiceBox efektorJezdnyFkChoiceBox              = (ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_JEZDNY_FKChoiceBox");
        ChoiceBox efektorPlywaniaFkChoiceBox            = (ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_PLYWANIA_FKChoiceBox");
        ChoiceBox efektorInzFkChoiceBox                 = (ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_INZ_FKChoiceBox");
        ChoiceBox efektorWeFkChoiceBox                  = (ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_WE_FKChoiceBox");
        ChoiceBox paramKadlubaFkChoiceBox               = (ChoiceBox) controller.findControlById(inputGridPane3,"PARAM_KADLUBA_FKChoiceBox");
        ChoiceBox efektorTranspFkChoiceBox              = (ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_TRANSP_FKChoiceBox");
        ChoiceBox kategFkChoiceBox                      = (ChoiceBox) controller.findControlById(inputGridPane3,"KATEG_FKChoiceBox");
        ChoiceBox efektorLataniaFkChoiceBox             = (ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_LATANIA_FKChoiceBox");
        ChoiceBox efektorRozpozFkChoiceBox              = (ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_ROZPOZ_FKChoiceBox");
        TextField mocTextField                          = (TextField) controller.findControlById(inputGridPane3,"MOCTextField");
        TextField klasaPrzyrzOcTextField                = (TextField) controller.findControlById(inputGridPane3,"KLASA_PRZYRZ_OCTextField");
        TextField zuzPaliwaPracaTextField               = (TextField) controller.findControlById(inputGridPane3,"ZUZ_PALIWA_PRACATextField");

        SprzetWojDto result = new SprzetWojDto();
        result.setNazwa(nazwaTextField.getText());
        result.setSkrot(skrotTextField.getText());
        result.setKod(kodTextField.getText());
        result.setKategoriaFk(((Item) kategFkChoiceBox.getValue()).getId());

        return result;
    }

    private void clear(){
        ((TextField) controller.findControlById(inputGridPane,"NAZWATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"SKROTTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"KODTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"KLASATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"OBSLUGATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_CYKLU_ZYCIATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_NABYCIATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"KOSZT_JEDN_UTRZYM_WYSZK_PERSONTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"MASATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"DLUGTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"SZEROKTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"WYSOKTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"POTENCJAL_BOJTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane,"VALUETextField")).clear();
        ((TextField) controller.findControlById(inputGridPane2,"POJEM_ZBIOR_PALIWATextField")).clear();
        ((TextField) controller.findControlById(inputGridPane2,"POJEM_ZBIOR_PALIWA_DODATTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane2,"POJEM_AKUMULATOROWTextField")).clear();
        ((CheckBox) controller.findControlById(inputGridPane2,"JEZDZACYCheckBox")).setSelected(false);
        ((CheckBox) controller.findControlById(inputGridPane2,"LATAJACYCheckBox")).setSelected(false);
        ((CheckBox) controller.findControlById(inputGridPane2,"PLYWAJACYCheckBox")).setSelected(false);
        ((CheckBox) controller.findControlById(inputGridPane2,"PRZENOSNYCheckBox")).setSelected(false);
        ((CheckBox) controller.findControlById(inputGridPane2,"CIAGNIONYCheckBox")).setSelected(false);
        ((CheckBox) controller.findControlById(inputGridPane2,"OPANCERZONYCheckBox")).setSelected(false);
        ((ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_LACZN_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane2,"RODZAJ_SRODOW_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_JEZDNY_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_PLYWANIA_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane2,"EFEKTOR_INZ_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_WE_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"PARAM_KADLUBA_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_TRANSP_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"KATEG_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_LATANIA_FKChoiceBox")).setValue(null);
        ((ChoiceBox) controller.findControlById(inputGridPane3,"EFEKTOR_ROZPOZ_FKChoiceBox")).setValue(null);
        ((TextField) controller.findControlById(inputGridPane3,"MOCTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane3,"KLASA_PRZYRZ_OCTextField")).clear();
        ((TextField) controller.findControlById(inputGridPane3,"ZUZ_PALIWA_PRACATextField")).clear();
    }
}
