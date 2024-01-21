package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.*;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.model.AmoDto;
import pl.edu.wat.mspw_frontend.model.MpsDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputAmoController {
    private AmoService amoService = new AmoService();
    private KategoriaAmoService kategoriaAmoService = new KategoriaAmoService();
    private RodzajGlowicyBojService rodzajGlowicyBojService = new RodzajGlowicyBojService();
    private RodzajGlowicyNaprowService rodzajGlowicyNaprowService = new RodzajGlowicyNaprowService();
    private RodzajNaprowService rodzajNaprowService = new RodzajNaprowService();
    private TableAmoController  tableAmoController;
    @FXML
    private AnchorPane tableContainer; // Container dla TableMpsView
    @FXML
    private GridPane inputGridPane;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Label labelTitle;
    private Map<String, Control> dynamicControls = new HashMap<>();
    private BooleanProperty anyControlEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego rodzaju amunicji");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_AMO.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableAmoController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableAmoController = loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupDynamicControls() {
        List<Item> kategoryList = kategoriaAmoService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());
        List<Item> rodzajGlowicyList = rodzajGlowicyBojService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        List<Item> rodzajGlowicyNaprowList = rodzajGlowicyNaprowService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        List<Item> rodzajNaprowList = rodzajNaprowService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());


        InputControllerStatic.generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KOD", "KOD", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KALIBER", "KALIBER", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SZTUK_W_PACZCE", "SZTUK_W_PACZCE", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MASA SZTUKI", "MASA SZTUKI", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_X", "WYM_PACZKI_X", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_Y", "WYM_PACZKI_Y", dynamicControls, 7, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_Z", "WYM_PACZKI_Z", dynamicControls, 8, TextField.class,null,controller,inputGridPane);

        InputControllerStatic.generateDynamicControl("KATEG_FK", "KATEGORIA", dynamicControls, 9, ChoiceBox.class, kategoryList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTKATEGORIAAMOVIEW.getValue(), 2, 9);

        InputControllerStatic.generateDynamicControl("RODZAJ_GLOWICY_BOJ_FK", "RODZAJ_GLOWICY_BOJ_FK", dynamicControls, 10, ChoiceBox.class, rodzajGlowicyList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 10);

        InputControllerStatic.generateDynamicControl("RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK", dynamicControls, 11, ChoiceBox.class, rodzajGlowicyNaprowList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);

        InputControllerStatic.generateDynamicControl("RODZAJ_NAPROW_FK", "RODZAJ_NAPROW_FK", dynamicControls, 12, ChoiceBox.class, rodzajNaprowList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        String nazwa = InputControllerStatic.getControlValue(inputGridPane,"NAZWATextField",TextField.class,controller);
        String skrot = InputControllerStatic.getControlValue(inputGridPane,"SKROTTextField",TextField.class,controller);
        String kod = InputControllerStatic.getControlValue(inputGridPane,"KODTextField",TextField.class,controller);
        Double kaliber = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"KALIBERTextField",controller);
        Integer sztuk_w_paczce = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SZTUK_W_PACZCETextField",controller);
        Integer masa_sztuki = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"MASA SZTUKITextField",controller);
        Double wym_paczki_x = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYM_PACZKI_XTextField",controller);
        Double wym_paczki_y = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYM_PACZKI_YTextField",controller);
        Double wym_paczki_z = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYM_PACZKI_ZTextField",controller);

        Integer kateg_fk= InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"KATEG_FKChoiceBox",controller);
        Integer rodzaj_glowicy_boj_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"RODZAJ_GLOWICY_BOJ_FKChoiceBox",controller);
        Integer rodzaj_glowicy_naprow_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"RODZAJ_GLOWICY_NAPROW_FKChoiceBox",controller);
        Integer rodzaj_naprow_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"RODZAJ_NAPROW_FKChoiceBox",controller);



        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                amoService.create(
                        AmoDto.builder()
                                .nazwa(nazwa)
                                .skrot(skrot)
                                .kod(kod)
                                .kaliber(kaliber)
                                .sztukWPaczce(sztuk_w_paczce)
                                .masaSztuki(masa_sztuki)
                                .wymPaczkiX(wym_paczki_x)
                                .wymPaczkiY(wym_paczki_y)
                                .wymPaczkiZ(wym_paczki_z)
                                .kategFk(kateg_fk)
                                .rodzajGlowicyBojFk(rodzaj_glowicy_boj_fk)
                                .rodzajGlowicyNaprowFk(rodzaj_glowicy_naprow_fk)
                                .rodzajNaprowFk(rodzaj_naprow_fk)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableAmoController != null) {
            tableAmoController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        AmoDto selectedAmo = tableAmoController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedAmo != null) {
            try{
                amoService.delete(Long.valueOf(selectedAmo.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableAmoController != null) {
            tableAmoController.populateTable();
        }

    }
}
