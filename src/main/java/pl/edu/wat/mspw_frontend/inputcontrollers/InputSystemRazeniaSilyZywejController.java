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
import pl.edu.wat.mspw_backend.service.StrefaRazeniaSilyZywejService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSilyZywejDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableStrefaRazeniaSilyZywejController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.amoList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputSystemRazeniaSilyZywejController {
    private StrefaRazeniaSilyZywejService strefaRazeniaSilyZywejService = new StrefaRazeniaSilyZywejService();
    private TableStrefaRazeniaSilyZywejController tableController;

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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie nowej strefy rażenia siły żywej");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_STREFA_RAZENIA_SILY_ZYWEJ.getValue());
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
        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 0, ChoiceBox.class, amoList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "AMO_FK", "#", Views.INPUTAMOVIEW.getValue(), 2, 0);

        InputControllerStatic.generateDynamicControl("ODLEG_STRZEL", "ODLEG_STRZEL", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POW_RAZ_ODKR", "POW_RAZ_ODKR", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POW_RAZ_ROZB_DORAZNA", "POW_RAZ_ROZB_DORAZNA", dynamicControls, 3, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POW_RAZ_ROZB_PRZYGOT", "POW_RAZ_ROZB_PRZYGOT", dynamicControls, 4, TextField.class, null, controller, inputGridPane);
    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer amoFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "AMO_FKChoiceBox", controller);
        Double odlegStrzel = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ODLEG_STRZELTextField", controller);
        Double powRazOdkr = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ODKRTextField", controller);
        Double powRazRozbDorazna = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_DORAZNATextField", controller);
        Double powRazRozbPrzygot = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_PRZYGOTTextField", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                strefaRazeniaSilyZywejService.create(
                        StrefaRazeniaSilyZywejDto.builder()
                                .amoFk(amoFk)
                                .odlegStrzel(odlegStrzel)
                                .powRazOdkr(powRazOdkr)
                                .powRazRozbDorazna(powRazRozbDorazna)
                                .powRazRozbPrzygot(powRazRozbPrzygot)
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
        StrefaRazeniaSilyZywejDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                strefaRazeniaSilyZywejService.delete(Long.valueOf(selectedFireSys.getId()));
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
