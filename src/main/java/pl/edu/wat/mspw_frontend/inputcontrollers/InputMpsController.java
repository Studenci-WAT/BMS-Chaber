package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.MpsDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableMpsController;

import java.io.IOException;
import java.util.HashMap;
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

    private Map<String, TextField> dynamicTextFields = new HashMap<>();
    private BooleanProperty anyTextFieldEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    @FXML
    public void initialize() {
        setupTitle();
        setupDynamicTextFields();
        mpsService = new MpsService();
        loadTableView(TableViews.TABLE_MPS.getValue());
        setupDynamicTextFieldsListeners();
        setupButtonProperties();
        updateAnyTextFieldEmpty();
        updateAddButtonStyle();
    }

    private void setupTitle() {
        labelTitle.setText("Wprowadzanie nowego rodzaju MPS");
        labelTitle.setAlignment(Pos.CENTER);
    }

    private void setupDynamicTextFields() {
        generateDynamicTextField("NAZWA", "NAZWA", dynamicTextFields, 0);
        generateDynamicTextField("SKROT", "SKRÓT", dynamicTextFields, 1);
        generateDynamicTextField("KOD", "KOD", dynamicTextFields, 2);
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

    private void setupDynamicTextFieldsListeners() {
        dynamicTextFields.forEach((id, textField) ->
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    updateAddButtonStyle();
                }));
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

        dynamicTextFields.values().forEach(textField -> textField.setText(""));
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
        anyTextFieldEmpty.set(isAnyTextFieldEmpty());
    }

    private boolean isAnyTextFieldEmpty() {
        return dynamicTextFields.values().stream()
                .anyMatch(textField -> textField.getText().isEmpty());
    }

    private void generateDynamicTextField(String id, String label, Map<String, TextField> container, int rowIndex) {
        TextField textField = controller.generateTextField(inputGridPane,id, label,rowIndex);
        container.put(id, textField);
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
}

