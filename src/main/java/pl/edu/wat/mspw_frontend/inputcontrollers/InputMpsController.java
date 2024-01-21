package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.model.MpsDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableMpsController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InputMpsController {
    private MpsService mpsService;
    private TableMpsController tableMpsController;
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

    private Map<String,  Control> dynamicControls = new HashMap<>();
    private BooleanProperty anyTextFieldEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    @FXML
    public void initialize() {
        setupTitle();
        setupDynamicTextFields();
        mpsService = new MpsService();
        loadTableView(TableViews.TABLE_MPS.getValue());
        setupDynamicControlsListeners();
        setupButtonProperties();
        updateAnyTextFieldEmpty();
        updateAddButtonStyle();
    }

    private void setupTitle() {
        labelTitle.setText("Wprowadzanie nowego rodzaju MPS");
        labelTitle.setAlignment(Pos.CENTER);
    }

    private void setupDynamicTextFields() {
        generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0,TextField.class, null);
        generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null);
        generateDynamicControl("KOD", "KOD", dynamicControls, 2, TextField.class, null);
    }

    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableMpsController = loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupDynamicControlsListeners() {
        dynamicControls.forEach((id, control) -> {
            if (control instanceof TextField) {
                ((TextField) control).textProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    updateAddButtonStyle();
                });
            } else if (control instanceof ChoiceBox) {
                ((ChoiceBox<?>) control).valueProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    updateAddButtonStyle();
                });
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    private void setupButtonProperties() {
        addButton.disableProperty().bind(anyTextFieldEmpty);
        deleteButton.disableProperty().bind(tableMpsController.getTableView().getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disabledProperty().addListener((observable, oldValue, newValue) -> updateDeleteButtonStyle());
    }

    @FXML
    private void addButtonAction(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        // - itp.
        TextField nazwaTextField = (TextField) controller.findControlById(inputGridPane, "NAZWATextField");
        TextField skrotTextField = (TextField) controller.findControlById(inputGridPane, "SKROTTextField");
        TextField kodTextField = (TextField) controller.findControlById(inputGridPane, "KODTextField");

        if(nazwaTextField.getText() != null || skrotTextField.getText() != null || kodTextField.getText() != null) {
            mpsService.create(
                    MpsDto.builder()
                            .nazwa(nazwaTextField.getText())
                            .skrot(skrotTextField.getText())
                            .kod(kodTextField.getText())
                            .build()
            );
        }
        // Odświeżenie tabeli
        if (tableMpsController != null) {
            tableMpsController.populateTable();
        }

        clearDynamicControls();
    }
    @FXML
    private void deleteButtonAction() {
        MpsDto selectedMps = tableMpsController.getTableView().getSelectionModel().getSelectedItem();
        if (selectedMps != null) {
            // Przekazanie ID do metody delete
            mpsService.delete(Long.valueOf(selectedMps.getId()));
        } else {
            // Pokaż komunikat, że nie wybrano rekordu
        }
        // Odświeżenie tabeli
        if (tableMpsController != null) {
            tableMpsController.populateTable();
        }
    }
    private void updateAnyTextFieldEmpty() {
        anyTextFieldEmpty.set(isAnyControlEmpty());
    }

    private boolean isAnyControlEmpty() {
        return dynamicControls.values().stream().anyMatch(control -> {
            if (control instanceof TextField) {
                return ((TextField) control).getText().isEmpty();
            } else if (control instanceof ChoiceBox) {
                return ((ChoiceBox<?>) control).getValue() == null;
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    private void generateDynamicControl(String id, String label, Map<String, Control> container, int rowIndex, Class<? extends Control> controlType, List<Item> options) {
        Control control;
        if (controlType.equals(TextField.class)) {
            control = controller.generateTextField(inputGridPane, id, label, rowIndex);
        } else if (controlType.equals(ChoiceBox.class)) {
            if (options.isEmpty()) {
                throw new IllegalArgumentException("ChoiceBox requires options");
            }
            control = controller.generateChoiceBox(inputGridPane, id, label, rowIndex, options);
        } else {
            throw new IllegalArgumentException("Unsupported control type: " + controlType.getSimpleName());
        }

        container.put(id, control);
    }

    private void updateAddButtonStyle() {
        if (addButton.isDisabled()) {
            addButton.getStyleClass().remove("button-disabled");
            addButton.getStyleClass().remove("button-enabled");
            addButton.getStyleClass().add("button-disabled");
        } else {
            addButton.getStyleClass().remove("button-disabled");
            addButton.getStyleClass().remove("button-enabled");
            addButton.getStyleClass().add("button-enabled");
        }
    }

    private void updateDeleteButtonStyle() {
        if (deleteButton.isDisabled()) {
            deleteButton.getStyleClass().remove("button-disabled");
            deleteButton.getStyleClass().remove("button-enabled");
            deleteButton.getStyleClass().add("button-disabled");
        } else {
            deleteButton.getStyleClass().remove("button-disabled");
            deleteButton.getStyleClass().remove("button-enabled");
            deleteButton.getStyleClass().add("button-enabled");
        }
    }

    private void clearDynamicControls() {
        dynamicControls.forEach((id, control) -> {
            if (control instanceof TextField) {
                ((TextField) control).clear();
            } else if (control instanceof ChoiceBox) {
                ((ChoiceBox<?>) control).setValue(null);
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }
}
