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
import pl.edu.wat.mspw_backend.service.*;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.ParamStrzelOgBezpDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableParamStrzelOgBezpController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputParamStrzelOgBezpController {

    private ParamStrzelOgBezpService paramStrzelOgBezpService = new ParamStrzelOgBezpService();

    private TableParamStrzelOgBezpController tableParamStrzelOgBezpController;

    private AmoService amoService = new AmoService();
    private SystemOgnService systemOgnService = new SystemOgnService();



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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego parametru ostrzału ogniem bezp.");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_PARAM_STRZEL_OGN_BEZP.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableParamStrzelOgBezpController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableParamStrzelOgBezpController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SYSTEM_OGN_FK", "SYSTEM_OGN_FK", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG", "ODLEG", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_POCISKU", "PREDK_POCISKU", dynamicControls, 3, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("UCHYL_SZER", "UCHYL_SZER", dynamicControls, 4, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("UCHYL_WYS", "UCHYL_WYS", dynamicControls, 5, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYSOK", "WYSOK", dynamicControls, 6, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer amo_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"AMO_FKTextField",controller);
        Integer system_ogn_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SYSTEM_OGN_FKTextField",controller);
        Double odleg = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ODLEGTextField",controller);
        Double pred_pocisku = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_POCISKUTextField",controller);
        Double uchyl_szer = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"UCHYL_SZERTextField",controller);
        Double uchyl_wys = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"UCHYL_WYSTextField",controller);
        Double wysok = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYSOKTextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                paramStrzelOgBezpService.create(
                        ParamStrzelOgBezpDto.builder()
                                .amoFk(amo_fk)
                                .systemOgnFk(system_ogn_fk)
                                .odleg(odleg)
                                .predkPocisku(pred_pocisku)
                                .uchylSzer(uchyl_szer)
                                .uchylWys(uchyl_wys)
                                .wysok(wysok)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableParamStrzelOgBezpController != null) {
            tableParamStrzelOgBezpController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        ParamStrzelOgBezpDto selectedParamStrzelOgBezp= tableParamStrzelOgBezpController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedParamStrzelOgBezp != null) {
            try{
                paramStrzelOgBezpService.delete(Long.valueOf(selectedParamStrzelOgBezp.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableParamStrzelOgBezpController != null) {
            tableParamStrzelOgBezpController.populateTable();
        }

    }
}
