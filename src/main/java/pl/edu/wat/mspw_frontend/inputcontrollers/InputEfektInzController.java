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
import pl.edu.wat.mspw_backend.service.EfektorInzService;
import pl.edu.wat.mspw_backend.service.EfektorPlywaniaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorInzDto;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorInzController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorPlywaniaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektInzController {
    private EfektorInzService efektorInzService = new EfektorInzService();
    private TableEfektorInzController tableEfektorInzController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora inżynieryjnego");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_INZ.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorInzController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorInzController = loader.getController();

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

        controller.generateCheckBox(inputGridPane,"DO_PRAC_ZIEMNYCH","DO_PRAC_ZIEMNYCH",0);
        controller.generateCheckBox(inputGridPane,"ELEMENT_PRZEPR_PROM","ELEMENT_PRZEPR_PROM",1);
        controller.generateCheckBox(inputGridPane,"ELEMENT_PRZEPR_MOST","ELEMENT_PRZEPR_MOST",2);
        InputControllerStatic.generateDynamicControl("NOSNOSC", "NOŚNOŚĆ", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SZEROK_PRZEPRAWY", "SZEROK_PRZEPRAWY", dynamicControls, 4, TextField.class,null, controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Boolean do_prac_ziemnych = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"DO_PRAC_ZIEMNYCHCheckBox",controller);
        Boolean element_przepr_prom = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ELEMENT_PRZEPR_PROMCheckBox",controller);
        Boolean element_przepr_most = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ELEMENT_PRZEPR_MOSTCheckBox",controller);
        Double nosnosc = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"NOSNOSCTextField",controller);
        Double szerok_przeprawy = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"SZEROK_PRZEPRAWYTextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorInzService.create(
                        EfektorInzDto.builder()
                                .doPracZiemnych(do_prac_ziemnych)
                                .elementPrzeprProm(element_przepr_prom)
                                .elementPrzeprMost(element_przepr_most)
                                .nosnosc(nosnosc)
                                .szerokPrzeprawy(szerok_przeprawy)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorInzController != null) {
            tableEfektorInzController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorInzDto selectedEfektorInz = tableEfektorInzController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorInz != null) {
            try{
                efektorInzService.delete(Long.valueOf(selectedEfektorInz.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorInzController != null) {
            tableEfektorInzController.populateTable();
        }

    }
}
