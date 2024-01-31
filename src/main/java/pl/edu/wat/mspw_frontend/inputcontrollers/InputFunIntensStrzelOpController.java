package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.FunIntensStrzelOpService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunIntensStrzelOpDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunIntensStrzelOpController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunIntensStrzelOpController {
    private FunIntensStrzelOpService funIntensStrzelOpService = new FunIntensStrzelOpService();
    private TableFunIntensStrzelOpController tableController;

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
        loadTableView(TableViews.TABLE_FUN_INTENS_STRZEL_OP.getValue());
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
        InputControllerStatic.generateDynamicControl("KLASA_STRZEL", "KLASA_STRZEL", dynamicControls, 0, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("KLASA_CELU", "KLASA_CELU", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK_STRZEL", "POZIOM_WYSZK_STRZEL PRZYRZ OC", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG", "ODLEG", dynamicControls, 3, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("INTENS", "INTENS", dynamicControls, 4, TextField.class, null, controller, inputGridPane);
    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer klasaStrzel = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "KLASA_STRZELTextField", controller);
        Integer klasaCelu = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "KLASA_CELUTextField", controller);
        Integer poziomWyszkStrzel = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_WYSZK_STRZELTextField", controller);
        Double odleg = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ODLEGTextField", controller);
        Double intens = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "INTENSTextField", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funIntensStrzelOpService.create(
                        FunIntensStrzelOpDto.builder()
                                .klasaStrzel(klasaStrzel)
                                .klasaCelu(klasaCelu)
                                .poziomWyszkStrzel(poziomWyszkStrzel)
                                .odleg(odleg)
                                .intens(intens)
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
        FunIntensStrzelOpDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                funIntensStrzelOpService.delete(Long.valueOf(selectedFireSys.getId()));
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
