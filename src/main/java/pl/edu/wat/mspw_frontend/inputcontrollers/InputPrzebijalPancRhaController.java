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
import pl.edu.wat.mspw_backend.service.AmoService;
import pl.edu.wat.mspw_backend.service.PrzebijalPancRhaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.PrzebijalPancRhaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TablePrzebijalPancRhaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputPrzebijalPancRhaController {
    private PrzebijalPancRhaService przebijalPancRhaService = new PrzebijalPancRhaService();
    private TablePrzebijalPancRhaController tablePrzebijalPancRhaController;
    private AmoService amoService = new AmoService();


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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie nowej przebij. RHA");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_PRZEBIJAL_PANC_RHA.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton, deleteButton, anyControlEmpty, tablePrzebijalPancRhaController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty, dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }

    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablePrzebijalPancRhaController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 0, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_POCISKU", "PREDK_POCISKU", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("PRZEBIJAL_POCISKU", "PRZEBIJAL_POCISKU", dynamicControls, 2, TextField.class, null, controller, inputGridPane);



    }

    @FXML
    private void addButtonAction() {

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer amo_fk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "AMO_FKTextField", controller);
        Double pred_pocisku = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "PREDK_POCISKUTextField", controller);
        Double przebijal_pocisku = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "PRZEBIJAL_POCISKUTextField", controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                przebijalPancRhaService.create(
                        PrzebijalPancRhaDto.builder()
                                .amoFk(amo_fk)
                                .predkPocisku(pred_pocisku)
                                .przebijalPocisku(przebijal_pocisku)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablePrzebijalPancRhaController != null) {
            tablePrzebijalPancRhaController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }

    @FXML
    private void deleteButtonAction() {
        PrzebijalPancRhaDto selectedPrzebijalPancRhaDto = tablePrzebijalPancRhaController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedPrzebijalPancRhaDto != null) {
            try {
                przebijalPancRhaService.delete(Long.valueOf(selectedPrzebijalPancRhaDto.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            } catch (Exception ex) {
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablePrzebijalPancRhaController != null) {
            tablePrzebijalPancRhaController.populateTable();
        }
    }
}
