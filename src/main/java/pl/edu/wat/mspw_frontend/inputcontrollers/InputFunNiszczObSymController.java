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
import pl.edu.wat.mspw_backend.service.FunNiszczObSymService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunNiszczObSymDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunNiszczObSymController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.amoList;
import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.poziomOddzialOgnPkaList;
import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.sysOgnList;
import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.typKlimatuList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunNiszczObSymController {
    private FunNiszczObSymService funNiszczObSymService = new FunNiszczObSymService();
    private TableFunNiszczObSymController tableController;

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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie danych do funkcji");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_FUN_NISZCZ_OB_SYM.getValue());
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
        InputControllerStatic.generateDynamicControl("SYS_OGN_FK", "SYS_OGN_FK", dynamicControls, 0, ChoiceBox.class, sysOgnList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "SYS_OGN_FK", "#", Views.INPUTSYSOGNVIEW.getValue(), 2, 0);

        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 1, ChoiceBox.class, amoList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "AMO_FK", "#", Views.INPUTAMOVIEW.getValue(), 2, 1);

        InputControllerStatic.generateDynamicControl("MOBIL_STRZEL", "MOBIL_STRZEL", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("MOBIL_CELU", "MOBIL_CELU", dynamicControls, 3, TextField.class, null, controller, inputGridPane);

        InputControllerStatic.generateDynamicControl("TYP_KLIMATU_FK", "TYP_KLIMATU_FK", dynamicControls, 4, ChoiceBox.class, typKlimatuList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "TYP_KLIMATU_FK", "#", Views.INPUTTYPKLIMATU.getValue(), 2, 4);

        InputControllerStatic.generateDynamicControl("POZIOM_ODDZIAL_OGN_PKA_FK", "POZIOM_ODDZIAL_OGN_PKA_FK", dynamicControls, 5, ChoiceBox.class, poziomOddzialOgnPkaList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "POZIOM_ODDZIAL_OGN_PKA_FK", "#", Views.INPUTPOZIOMODDZIALOGN.getValue(), 2, 5);

        InputControllerStatic.generateDynamicControl("POZIOM_FORT_CELU", "POZIOM_FORT_CELU", dynamicControls, 6, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK_STRZEL", "POZIOM_WYSZK_STRZEL", dynamicControls, 7, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG", "ODLEG PRZYRZ OC", dynamicControls, 8, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("INTENS_NISZCZ", "INTENS_NISZCZ", dynamicControls, 9, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("PSTWO_ZNISZCZ", "PSTWO_ZNISZCZ", dynamicControls, 10, TextField.class, null, controller, inputGridPane);
    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer sysOgnFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "SYS_OGN_FKChoiceBox", controller);
        Integer amoFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "AMO_FKChoiceBox", controller);
        Integer mobilStrzel = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "MOBIL_STRZELTextField", controller);
        Integer mobilCelu = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "MOBIL_CELUTextField", controller);
        Integer typKlimatuFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "TYP_KLIMATU_FKChoiceBox", controller);
        Integer poziomOddzialOgnPkaFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_ODDZIAL_OGN_PKA_FKChoiceBox", controller);
        Integer poziomFortCelu = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_FORT_CELUTextField", controller);
        Integer poziomWyszkStrzel = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_WYSZK_STRZELTextField", controller);
        Double odleg = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ODLEGTextField", controller);
        Double intensNiszcz = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "INTENS_NISZCZTextField", controller);
        Double pstwoZniszcz = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "PSTWO_ZNISZCZTextField", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funNiszczObSymService.create(
                        FunNiszczObSymDto.builder()
                                .sysOgnFk(sysOgnFk)
                                .amoFk(amoFk)
                                .mobilStrzel(mobilStrzel)
                                .mobilCelu(mobilCelu)
                                .typKlimatuFk(typKlimatuFk)
                                .poziomOddzialOgnPkaFk(poziomOddzialOgnPkaFk)
                                .poziomFortCelu(poziomFortCelu)
                                .poziomWyszkStrzel(poziomWyszkStrzel)
                                .odleg(odleg)
                                .intensNiszcz(intensNiszcz)
                                .pstwoZniszcz(pstwoZniszcz)
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
        FunNiszczObSymDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                funNiszczObSymService.delete(Long.valueOf(selectedFireSys.getId()));
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
