package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.KadlubService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.KadlubDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableKadlubController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputKadlubController {
    private KadlubService kadlubService = new KadlubService();
    private TableKadlubController tableController;
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
        InputControllerStatic.setupTitle(labelTitle,
                "Wprowadzanie danych o grubości pancerza RHA dla pocisków kumulacyjnych i kinetycznych");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_KADLUB.getValue());
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

        InputControllerStatic.generateDynamicControl("PANCERZ_BOK_KINET_RHA", "BOK - Kinet", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_BOK_KUMUL_RHA", "BOK - Kumul", dynamicControls, 5, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_FRONT_KINET_RHA", "FRONT - Kinet", dynamicControls, 1, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_FRONT_KUMUL_RHA", "FRONT - Kumul", dynamicControls, 6, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_TYL_KINET_RHA", "TYL - Kinet", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_TYL_KUMUL_RHA", "TYL - Kumul", dynamicControls, 7, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_SPOD_KINET_RHA", "SPÓD - Kinet", dynamicControls, 3, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_SPOD_KUMUL_RHA", "SPÓD - Kumul", dynamicControls, 8, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_STROP_KINET_RHA", "STROP - Kinet", dynamicControls, 4, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PANCERZ_STROP_KUMUL_RHA", "STROP - Kumul", dynamicControls, 9, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();


        double pancerzBokKinetRha = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_BOK_KINET_RHATextField",controller);
        double pancerzBokKumul = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_BOK_KUMUL_RHATextField",controller);
        double pancerzFrontKinet = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_FRONT_KINET_RHATextField",controller);
        double pancerzFrontKumul = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_FRONT_KUMUL_RHATextField",controller);
        double pancerzTylKinet = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_TYL_KINET_RHATextField",controller);
        double pancerzTylKumul = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_TYL_KUMUL_RHATextField",controller);
        double pancerzSpodKinet = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_SPOD_KINET_RHATextField",controller);
        double pancerzSpodKumul = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_SPOD_KUMUL_RHATextField",controller);
        double pancerzStropKinet = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_STROP_KINET_RHATextField",controller);
        double pancerzStropKumul = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PANCERZ_STROP_KUMUL_RHATextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                kadlubService.create(
                        KadlubDto.builder()
                                .pancerzBokKinetRha(pancerzBokKinetRha)
                                .pancerzBokKumulRha(pancerzBokKumul)
                                .pancerzFrontKinetRha(pancerzFrontKinet)
                                .pancerzFrontKumulRha(pancerzFrontKumul)
                                .pancerzTylKinetRha(pancerzTylKinet)
                                .pancerzTylKumulRha(pancerzTylKumul)
                                .pancerzSpodKinetRha(pancerzSpodKinet)
                                .pancerzSpodKumulRha(pancerzSpodKumul)
                                .pancerzStropKinetRha(pancerzStropKinet)
                                .pancerzStropKumulRha(pancerzStropKumul)
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
        KadlubDto selectedKadlub = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedKadlub != null) {
            try{
                kadlubService.delete(Long.valueOf(selectedKadlub.getId()));
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
