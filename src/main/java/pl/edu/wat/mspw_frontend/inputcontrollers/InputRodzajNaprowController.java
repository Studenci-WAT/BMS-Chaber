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
import pl.edu.wat.mspw_backend.service.RodzajGlowicyNaprowService;
import pl.edu.wat.mspw_backend.service.RodzajNaprowService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.RodzajGlowicyNaprowDto;
import pl.edu.wat.mspw_frontend.model.RodzajNaprowDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableRodzajGlowicyNaprowController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableRodzajNaprowController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputRodzajNaprowController {
    private RodzajNaprowService rodzajNaprowService = new RodzajNaprowService();
    private TableRodzajNaprowController tableController;
    @FXML
    private AnchorPane tableContainer;
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
    @FXML
    public void initialize() {
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie nowego rodzaju naprowadzania");
        setupDynamicTextFields();
        loadTableView(TableViews.TABLE_RODZAJ_NAPROW.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }


    private void setupDynamicTextFields() {
        InputControllerStatic.generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
    }

    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableController= loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void addButtonAction(){
        String nazwa = InputControllerStatic.getControlValue(inputGridPane,"NAZWATextField",TextField.class,controller);
        String skrot = InputControllerStatic.getControlValue(inputGridPane,"SKROTTextField",TextField.class,controller);

        Stage stage = (Stage) addButton.getScene().getWindow();
        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                rodzajNaprowService.create(
                        RodzajNaprowDto.builder()
                                .nazwa(nazwa)
                                .skrot(skrot)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }
        // Odświeżenie tabeli
        if (tableController!= null) {
            tableController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        RodzajNaprowDto selectedType = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedType != null) {
            try{
                rodzajNaprowService.delete(Long.valueOf(selectedType.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableController!= null) {
            tableController.populateTable();
        }
    }
}
