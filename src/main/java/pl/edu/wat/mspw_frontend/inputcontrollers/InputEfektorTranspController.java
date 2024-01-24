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
import pl.edu.wat.mspw_backend.service.EfektorPlywaniaService;
import pl.edu.wat.mspw_backend.service.EfektorTranspService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;
import pl.edu.wat.mspw_frontend.model.EfektorTranspDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorPlywaniaController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorTranspController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorTranspController {
    private EfektorTranspService efektorTranspService = new EfektorTranspService();
    private TableEfektorTranspController tableEfektorTranspController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora transportowego");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_TRANSP.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorTranspController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorTranspController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("DESANT", "DESANT", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LADOW_MASA", "LADOW_MASA", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LADOW_WYM_X", "LADOW_WYM_X", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LADOW_WYM_Y", "LADOW_WYM_Y", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LADOW_WYM_Z", "LADOW_WYM_Z", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POJEM", "POJEM", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        controller.generateCheckBox(inputGridPane,"TRANSPORT_WODY","TRANSPORT_WODY",6);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer desant = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"DESANTTextField",controller);
        Double ladow_masa = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"LADOW_MASATextField",controller);
        Double ladow_wym_x = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"LADOW_WYM_XTextField",controller);
        Double ladow_wym_y = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"LADOW_WYM_YTextField",controller);
        Double ladow_wym_z = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"LADOW_WYM_ZTextField",controller);
        Double pojem = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"POJEMTextField",controller);
        Boolean transport_wody = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"TRANSPORT_WODYCheckBox",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorTranspService.create(
                        EfektorTranspDto.builder()
                                .desant(desant)
                                .ladowMasa(ladow_masa)
                                .ladowWymX(ladow_wym_x)
                                .ladowWymY(ladow_wym_y)
                                .ladowWymZ(ladow_wym_z)
                                .pojem(pojem)
                                .transportWody(transport_wody)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorTranspController != null) {
            tableEfektorTranspController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorTranspDto selectedEfektorTransp = tableEfektorTranspController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorTransp != null) {
            try{
                efektorTranspService.delete(Long.valueOf(selectedEfektorTransp.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorTranspController != null) {
            tableEfektorTranspController.populateTable();
        }

    }
}
