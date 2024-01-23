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
import pl.edu.wat.mspw_backend.service.EfektorLacznService;
import pl.edu.wat.mspw_backend.service.EfektorLataniaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorLacznDto;
import pl.edu.wat.mspw_frontend.model.EfektorLataniaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorLacznController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorLataniaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorLataniaController {
    private EfektorLataniaService efektorLataniaService = new EfektorLataniaService();
    private TableEfektorLataniaController tableEfektorLataniaController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora latania");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_LATANIA.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorLataniaController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorLataniaController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("PREDK_MIN", "PREDK_MIN", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_EKO", "PREDK_EKO", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_MAX", "PREDK_MAX", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYSOK_MIN", "WYSOK_MIN", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYSOK_PRZELOT", "WYSOK_PRZELOT", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYSOK_MAX", "WYSOK_MAX", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PREDK_MIN", "ZUZYCIE_PREDK_MIN", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PREDK_PRZELOT", "ZUZYCIE_PREDK_PRZELOT", dynamicControls, 7, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PREDK_MAX", "ZUZYCIE_PREDK_MAX", dynamicControls, 8, TextField.class,null,controller,inputGridPane);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Double predk_min = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MINTextField",controller);
        Double predk_eko = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_EKOTextField",controller);
        Double predk_max = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MAXTextField",controller);
        Double wysok_min = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYSOK_MINTextField",controller);
        Double wysok_przelot = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYSOK_PRZELOTTextField",controller);
        Double wysok_max = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYSOK_MAXTextField",controller);
        Double zuzycie_predk_min = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PREDK_MINTextField",controller);
        Double zuzycie_predk_przelot = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PREDK_PRZELOTTextField",controller);
        Double zuzycie_predk_max = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PREDK_MAXTextField",controller);
        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorLataniaService.create(
                        EfektorLataniaDto.builder()
                                .predkMin(predk_min)
                                .predkEko(predk_eko)
                                .predkMax(predk_max)
                                .wysokMin(wysok_min)
                                .wysokPrzelot(wysok_przelot)
                                .wysokMax(wysok_max)
                                .zuzyciePredkMin(zuzycie_predk_min)
                                .zuzyciePredkPrzelot(zuzycie_predk_przelot)
                                .zuzyciePredkMax(zuzycie_predk_max)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorLataniaController != null) {
            tableEfektorLataniaController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorLataniaDto selectedEfektorLatania = tableEfektorLataniaController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorLatania != null) {
            try{
                efektorLataniaService.delete(Long.valueOf(selectedEfektorLatania.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorLataniaController != null) {
            tableEfektorLataniaController.populateTable();
        }

    }
}
