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
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_backend.service.SprzetWojService;
import pl.edu.wat.mspw_backend.service.StanMpsSpwService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.StanMpsSpwDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableStanMpsSpwController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputStanMpsSpwController {
    private StanMpsSpwService stanMpsSpwService = new StanMpsSpwService();


    private TableStanMpsSpwController tableStanMpsSpwController;


    private SprzetWojService sprzetWojService = new SprzetWojService();

    private MpsService mpsService = new MpsService();


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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego stanu MPS-SPW");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_STAN_MPS_SPW.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableStanMpsSpwController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableStanMpsSpwController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("SPW_FK", "SPW_FK", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MPS_FK", "MPS_FK", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("STAN_NORMATYW", "STAN_NORMATYW", dynamicControls, 2, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer spw_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SPW_FKTextField",controller);
        Integer mps_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"MPS_FKTextField",controller);
        Double stan_normatyw = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"STAN_NORMATYWTextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                stanMpsSpwService.create(
                        StanMpsSpwDto.builder()
                                .spwFk(spw_fk)
                                .mpsFk(mps_fk)
                                .stanNormatyw(stan_normatyw)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableStanMpsSpwController != null) {
            tableStanMpsSpwController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        StanMpsSpwDto selectedStanMpsSpw = tableStanMpsSpwController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedStanMpsSpw != null) {
            try{
                stanMpsSpwService.delete(Long.valueOf(selectedStanMpsSpw.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableStanMpsSpwController != null) {
            tableStanMpsSpwController.populateTable();
        }

    }

}
