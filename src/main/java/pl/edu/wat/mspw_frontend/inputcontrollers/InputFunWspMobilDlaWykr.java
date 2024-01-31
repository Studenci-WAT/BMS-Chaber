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
import pl.edu.wat.mspw_backend.service.FunWspMobilDlaStrzelService;
import pl.edu.wat.mspw_backend.service.FunWspMobilDlaWykrService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaStrzelDto;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaWykrDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspMobilDlaStrzelController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspMobilDlaWykrController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunWspMobilDlaWykr {



    private FunWspMobilDlaWykrService funWspMobilDlaWykrService = new FunWspMobilDlaWykrService();


    private TableFunWspMobilDlaWykrController tablefunWspMobilDlaWykrController;



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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie dane do funkcji");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_FUN_WSP_MOBIL_DLA_WYKR.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tablefunWspMobilDlaWykrController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablefunWspMobilDlaWykrController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("WSP", "WSP", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MOBIL_CELU_ISTOTNA", "MOBIL_CELU_ISTOTNA", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MOBIL_STRZEL_ISTOTNA", "MOBIL_STRZEL_ISTOTNA", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK", "POZIOM_WYSZK", dynamicControls, 3,TextField.class, null,controller,inputGridPane);


    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Double wsp = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WSPTextField",controller);
        boolean mobil_celu_istotna = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"MOBIL_CELU_ISTOTNATextField",controller);
        boolean mobil_strzel_istotna = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"MOBIL_STRZEL_ISTOTNATextField",controller);
        Integer poziom_wyszk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_WYSZKTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funWspMobilDlaWykrService.create(
                        FunWspMobilDlaWykrDto.builder()
                                .wsp(wsp)
                                .mobilCeluIstotna(mobil_celu_istotna)
                                .mobilStrzelIstotna(mobil_strzel_istotna)
                                .poziomWyszk(poziom_wyszk)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablefunWspMobilDlaWykrController != null) {
            tablefunWspMobilDlaWykrController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        FunWspMobilDlaWykrDto selectedFunWspMobilDlaWykr = tablefunWspMobilDlaWykrController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFunWspMobilDlaWykr != null) {
            try{
                funWspMobilDlaWykrService.delete(Long.valueOf(selectedFunWspMobilDlaWykr.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablefunWspMobilDlaWykrController != null) {
            tablefunWspMobilDlaWykrController.populateTable();
        }

    }

}
