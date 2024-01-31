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
import pl.edu.wat.mspw_backend.service.EfektorLataniaService;
import pl.edu.wat.mspw_backend.service.EfektorPlywaniaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorLataniaDto;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorLataniaController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorPlywaniaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorPlywaniaController {
    private EfektorPlywaniaService efektorPlywaniaService = new EfektorPlywaniaService();
    private TableEfektorPlywaniaController tableEfektorPlywaniaController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora plywania");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_PLYWANIA.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorPlywaniaController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorPlywaniaController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("PREDK_MAX_NA_WODZIE", "PREDK_MAX_NA_WODZIE", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_EKO_NA_WODZIE", "PREDK_EKO_NA_WODZIE", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_MAX_POD_WODA", "PREDK_MAX_POD_WODA", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_EKO_POD_WODA", "PREDK_EKO_POD_WODA", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("DZIELNOSC", "DZIELNOSC", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_MAX_NA_WOD", "ZUZYCIE_PALIWA_PREDK_MAX_NA_WOD", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_EKO_NA_WOD", "ZUZYCIE_PALIWA_PREDK_EKO_NA_WOD", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_MAX_POD_WOD", "ZUZYCIE_PALIWA_PREDK_MAX_POD_WOD", dynamicControls, 7, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_EKO_POD_WOD", "ZUZYCIE_PALIWA_PREDK_EKO_POD_WOD", dynamicControls, 8, TextField.class,null,controller,inputGridPane);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Double predk_max_na_wodzie = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MAX_NA_WODZIETextField",controller);
        Double predk_eko_na_wodzie = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_EKO_NA_WODZIETextField",controller);
        Double predk_max_pod_woda = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MAX_POD_WODATextField",controller);
        Double predk_eko_pod_woda = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_EKO_POD_WODATextField",controller);
        Integer dzielnosc = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"DZIELNOSCTextField",controller);
        Double zuzycie_paliwa_predk_max_na_wod = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_MAX_NA_WODTextField",controller);
        Double zuzycie_paliwa_predk_eko_na_wod = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_EKO_NA_WODTextField",controller);
        Double zuzycie_paliwa_predk_max_pod_wod = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_MAX_POD_WODTextField",controller);
        Double zuzycie_paliwa_predk_eko_pod_wod = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_EKO_POD_WODTextField",controller);
        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorPlywaniaService.create(
                        EfektorPlywaniaDto.builder()
                                .predkMaxNaWodzie(predk_max_na_wodzie)
                                .predkEkoNaWodzie(predk_eko_na_wodzie)
                                .predkMaxPodWoda(predk_max_pod_woda)
                                .predkEkoPodWoda(predk_eko_pod_woda)
                                .dzielnosc(dzielnosc)
                                .zuzyciePaliwaPredkMaxNaWod(zuzycie_paliwa_predk_max_na_wod)
                                .zuzyciePaliwaPredkEkoNaWod(zuzycie_paliwa_predk_eko_na_wod)
                                .zuzyciePaliwaPredkMaxPodWod(zuzycie_paliwa_predk_max_pod_wod)
                                .zuzyciePaliwaPredkEkoPodWod(zuzycie_paliwa_predk_eko_pod_wod)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorPlywaniaController != null) {
            tableEfektorPlywaniaController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorPlywaniaDto selectedEfektorPlywania = tableEfektorPlywaniaController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorPlywania != null) {
            try{
                efektorPlywaniaService.delete(Long.valueOf(selectedEfektorPlywania.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorPlywaniaController != null) {
            tableEfektorPlywaniaController.populateTable();
        }

    }
}
