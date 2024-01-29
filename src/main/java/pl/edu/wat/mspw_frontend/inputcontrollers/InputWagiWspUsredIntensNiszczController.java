package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.WagiWspUsredIntensNiszczService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.WagiWspUsredIntensNiszczDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableWagiWspUsredIntensNiszczController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.poziomOddzialOgnPkaList;
import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.typKlimatuList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputWagiWspUsredIntensNiszczController {
    private WagiWspUsredIntensNiszczService wagiWspUsredIntensNiszczService = new WagiWspUsredIntensNiszczService();
    private TableWagiWspUsredIntensNiszczController tableController;

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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie nowej wagi uśrednienia intensywnosci niszczenia");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_WAGI_WSP_USRED_INTENS_NISZCZ.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton, deleteButton, anyControlEmpty, tableController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty, dynamicControls);
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
        InputControllerStatic.generateDynamicControl("TYP_KLIMATU_FK", "TYP_KLIMATU_FK", dynamicControls, 0, ChoiceBox.class, typKlimatuList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "TYP_KLIMATU_FK", "#", Views.INPUTTYPKLIMATU.getValue(), 2, 0);

        InputControllerStatic.generateDynamicControl("DZIEN", "DZIEN", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_OPAD_ISTOTNY", "POZIOM_OPAD_ISTOTNY", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_ZAMGL_ISTOTNY", "POZIOM_ZAMGL_ISTOTNY", dynamicControls, 3, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_FORT_CELU", "POZIOM_FORT_CELU", dynamicControls, 4, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_MASK_CELU_ISTOTNY", "POZIOM_MASK_CELU_ISTOTNY PRZYRZ OC", dynamicControls, 5, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_ZADYM_CELU_ISTOTNY", "POZIOM_ZADYM_CELU_ISTOTNY", dynamicControls, 6, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("MOBIL_STRZEL_ISTOTNA", "MOBIL_STRZEL_ISTOTNA", dynamicControls, 7, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("MOBIL_CELU_ISTOTNA", "MOBIL_CELU_ISTOTNA", dynamicControls, 8, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("WAGA", "WAGA", dynamicControls, 9, TextField.class, null, controller, inputGridPane);

        InputControllerStatic.generateDynamicControl("POZIOM_ODDZIAL_OGN_PKA_FK", "POZIOM_ODDZIAL_OGN_PKA_FK", dynamicControls, 10, ChoiceBox.class, poziomOddzialOgnPkaList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "POZIOM_ODDZIAL_OGN_PKA_FK", "#", Views.INPUTPOZIOMODDZIALOGN.getValue(), 2, 10);
    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer typKlimatuFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "TYP_KLIMATU_FKChoiceBox", controller);
        Boolean dzien = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "DZIENTextField", controller);
        Boolean poziomOpadIstotny = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "POZIOM_OPAD_ISTOTNYTextField", controller);
        Boolean poziomZamglIstotny = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "POZIOM_ZAMGL_ISTOTNYTextField", controller);
        Integer poziomFortCelu = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_FORT_CELUTextField", controller);
        Boolean poziomMaskCeluIstotny = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "POZIOM_MASK_CELU_ISTOTNYTextField", controller);
        Boolean poziomZadymCeluIstotny = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "POZIOM_ZADYM_CELU_ISTOTNYTextField", controller);
        Boolean mobilStrzelIstotna = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "MOBIL_STRZEL_ISTOTNATextField", controller);
        Boolean mobilCeluIstotna = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "MOBIL_CELU_ISTOTNATextField", controller);
        Double waga = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "WAGATextField", controller);

        Integer poziomOddzialOgnPkaFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_ODDZIAL_OGN_PKA_FKChoiceBox", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                wagiWspUsredIntensNiszczService.create(
                        WagiWspUsredIntensNiszczDto.builder()
                                .typKlimatuFk(typKlimatuFk)
                                .dzien(dzien)
                                .poziomOpadIstotny(poziomOpadIstotny)
                                .poziomZamglIstotny(poziomZamglIstotny)
                                .poziomFortCelu(poziomFortCelu)
                                .poziomMaskCeluIstotny(poziomMaskCeluIstotny)
                                .poziomZadymCeluIstotny(poziomZadymCeluIstotny)
                                .mobilStrzelIstotna(mobilStrzelIstotna)
                                .mobilCeluIstotna(mobilCeluIstotna)
                                .poziomOddzialOgnPkaFk(poziomOddzialOgnPkaFk)
                                .waga(waga)
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
        WagiWspUsredIntensNiszczDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                wagiWspUsredIntensNiszczService.delete(Long.valueOf(selectedFireSys.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            } catch (Exception ex) {
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
