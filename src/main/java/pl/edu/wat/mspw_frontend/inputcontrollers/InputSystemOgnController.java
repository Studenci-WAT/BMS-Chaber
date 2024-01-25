package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
import pl.edu.wat.mspw_frontend.model.SystemOgnDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableSystemOgnController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.rodzajSystemuOgniaList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputSystemOgnController {
    private SystemOgnService systemOgnService = new SystemOgnService();
    private TableSystemOgnController tableController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego rodzaju systemu ognia");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_SYSTEM_OGN.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SZYBKOSTRZELNOSC", "SZYBKOSTRZELNOŚĆ", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KALIBER", "KALIBER", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("DLUG_SERII", "DLUG_SERII", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("CZAS_CELOWANIA", "CZAS_CELOWANIA", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LICZBA_KAN_CEL", "LICZBA_KAN_CEL", dynamicControls, 6, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KLASA_PRZYRZ_OC", "KLASA PRZYRZ OC", dynamicControls, 7, TextField.class,null,controller,inputGridPane);

        InputControllerStatic.generateDynamicControl("RODZAJ_SYSTEMU_OGN_FK", "RODZAJ_SYSTEMU_OGN_FK", dynamicControls, 8, ChoiceBox.class, rodzajSystemuOgniaList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_SYSTEMU_OGN_FK", "#", Views.INPUTRODZAJSYSTEMUOGN.getValue(), 2, 8);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        String nazwa = InputControllerStatic.getControlValue(inputGridPane,"NAZWATextField",TextField.class,controller);
        String skrot = InputControllerStatic.getControlValue(inputGridPane,"SKROTTextField",TextField.class,controller);
        Double szybkostrzelnosc = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"SZYBKOSTRZELNOSCTextField",controller);
        Double kaliber = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"KALIBERTextField",controller);
        Integer dlugSerii = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"DLUG_SERIITextField",controller);
        Double czasCelowania = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"CZAS_CELOWANIATextField",controller);
        Integer liczbaKanCel = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"LICZBA_KAN_CELTextField",controller);
        Integer klasaPrzyrzOc = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"KLASA_PRZYRZ_OCTextField",controller);


        Integer rodzajSystemuOgnFk= InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"RODZAJ_SYSTEMU_OGN_FKChoiceBox",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                systemOgnService.create(
                       SystemOgnDto.builder()
                                .nazwa(nazwa)
                                .skrot(skrot)
                                .szybkostrzelnosc(szybkostrzelnosc)
                                .kaliber(kaliber)
                                .dlugSerii(dlugSerii)
                                .czasCelowania(czasCelowania)
                                .liczbaKanCel(liczbaKanCel)
                                .klasaPrzyrzOc(klasaPrzyrzOc)
                                .rodzajSystemuOgnFk(rodzajSystemuOgnFk)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableController != null) {
            tableController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        SystemOgnDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try{
                systemOgnService.delete(Long.valueOf(selectedFireSys.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableController != null) {
            tableController.populateTable();
        }

    }
}



