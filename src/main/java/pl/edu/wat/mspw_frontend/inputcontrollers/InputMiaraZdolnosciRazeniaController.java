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
import pl.edu.wat.mspw_backend.service.MiaraZdolnosciRazeniaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.MiaraZdolnosciRazeniaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableMiaraZdolnosciRazeniaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputMiaraZdolnosciRazeniaController {
    private MiaraZdolnosciRazeniaService miaraZdolnosciRazeniaService = new MiaraZdolnosciRazeniaService();
    private TableMiaraZdolnosciRazeniaController tableController;

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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie nowej miary zdolności rażenia");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_MIARA_ZDOLNOSCI_RAZENIA.getValue());
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
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_PANC_OPANC_ZASIEG_BLISKI", "ZDOLN_RAZ_PANC_OPANC_ZASIEG_BLISKI", dynamicControls, 0, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_SRODK_OGN_ZASIEG_BLISKI", "ZDOLN_RAZ_SRODK_OGN_ZASIEG_BLISKI", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_BLISKI", "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_BLISKI", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_PANC_OPANC_ZASIEG_SREDNI", "ZDOLN_RAZ_PANC_OPANC_ZASIEG_SREDNI", dynamicControls, 3, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_SRODK_OGN_ZASIEG_SREDNI", "ZDOLN_RAZ_SRODK_OGN_ZASIEG_SREDNI", dynamicControls, 4, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_SREDNI", "ZDOLN_RAZ_SILY_ZYWEJ_ZASIEG_SREDNI", dynamicControls, 5, TextField.class, null, controller, inputGridPane);
    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Double zdolnRazPancOpancZasiegBliski = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ODLEG_STRZELTextField", controller);
        Double zdolnRazSrodkOgnZasiegBliski = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ODKRTextField", controller);
        Double zdolnRazSilyZywejZasiegBliski = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_DORAZNATextField", controller);
        Double zdolnRazPancOpancZasiegSredni = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_PRZYGOTTextField", controller);
        Double zdolnRazSrodkOgnZasiegSredni = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_PRZYGOTTextField", controller);
        Double zdolnRazSilyZywejZasiegSredni = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "POW_RAZ_ROZB_PRZYGOTTextField", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                miaraZdolnosciRazeniaService.create(
                        MiaraZdolnosciRazeniaDto.builder()
                                .zdolnRazPancOpancZasiegBliski(zdolnRazPancOpancZasiegBliski)
                                .zdolnRazSrodkOgnZasiegBliski(zdolnRazSrodkOgnZasiegBliski)
                                .zdolnRazSilyZywejZasiegBliski(zdolnRazSilyZywejZasiegBliski)
                                .zdolnRazPancOpancZasiegSredni(zdolnRazPancOpancZasiegSredni)
                                .zdolnRazSrodkOgnZasiegSredni(zdolnRazSrodkOgnZasiegSredni)
                                .zdolnRazSilyZywejZasiegSredni(zdolnRazSilyZywejZasiegSredni)
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
        MiaraZdolnosciRazeniaDto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                miaraZdolnosciRazeniaService.delete(Long.valueOf(selectedFireSys.getId()));
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
