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
import pl.edu.wat.mspw_frontend.model.StanMpsSpwDto;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSpwDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableStanMpsSpwController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableStrefaRazeniaSpwController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputStrefaRazeniaSpwController {
    private StrefaRazeniaSpwService strefaRazeniaSpwService = new StrefaRazeniaSpwService();


    private TableStrefaRazeniaSpwController tableStrefaRazeniaSpwController;


    private AmoService amoService = new AmoService();

    private KategoriaSpwService kategoriaSpwService = new KategoriaSpwService();




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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowej strefy rażenia SPW");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_STREFA_RAZENIA_SPW.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableStrefaRazeniaSpwController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableStrefaRazeniaSpwController = loader.getController();

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
        InputControllerStatic.generateDynamicControl("POW_RAZ_CEL_ODKR", "POW_RAZ_CEL_ODKR", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POW_RAZ_CEL_ZAKR", "POW_RAZ_CEL_ZAKR", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG_STRZEL", "ODLEG_STRZEL", dynamicControls, 3, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KATEG_SPW_FK", "KATEG_SPW_FK", dynamicControls, 4, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer amo_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"AMO_FKTextField",controller);
        Double pow_raz_cel_odkr = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"POW_RAZ_CEL_ODKRTextField",controller);
        Double pow_raz_cel_zakr = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"POW_RAZ_CEL_ZAKRTextField",controller);
        Double odleg_strzel = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ODLEG_STRZELTextField",controller);
        Integer kateg_spw_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"KATEG_SPW_FKTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                strefaRazeniaSpwService.create(
                        StrefaRazeniaSpwDto.builder()
                                .amoFk(amo_fk)
                                .powRazCelOdkr(pow_raz_cel_odkr)
                                .powRazCelZakr(pow_raz_cel_zakr)
                                .odlegStrzel(odleg_strzel)
                                .kategSpwFk(kateg_spw_fk)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableStrefaRazeniaSpwController != null) {
            tableStrefaRazeniaSpwController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        StrefaRazeniaSpwDto selectedStrefaRazeniaSpw = tableStrefaRazeniaSpwController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedStrefaRazeniaSpw != null) {
            try{
                strefaRazeniaSpwService.delete(Long.valueOf(selectedStrefaRazeniaSpw.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableStrefaRazeniaSpwController != null) {
            tableStrefaRazeniaSpwController.populateTable();
        }

    }
}
