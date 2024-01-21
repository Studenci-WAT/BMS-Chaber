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
import pl.edu.wat.mspw_backend.service.*;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputAmoController {
    private AmoService amoService;
    private KategoriaAmoService kategoriaAmoService = new KategoriaAmoService();
    private RodzajGlowicyBojService rodzajGlowicyBojService = new RodzajGlowicyBojService();
    private RodzajGlowicyNaprowService rodzajGlowicyNaprowService = new RodzajGlowicyNaprowService();
    private RodzajNaprowService rodzajNaprowService = new RodzajNaprowService();
    private TableAmoController  tableAmoController;
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
    private BooleanProperty anyTextFieldEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        setupTitle();
        setupDynamicControls();
        amoService = new AmoService();
        loadTableView(TableViews.TABLE_AMO.getValue());
        setupDynamicControlsListeners();
        setupButtonProperties();
        updateAnyTextFieldEmpty();
        updateAddButtonStyle();

    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableAmoController = loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setupTitle() {
        labelTitle.setText("Wprowadzanie nowego rodzaju amunicji");
        labelTitle.setAlignment(Pos.CENTER);
    }

    private void setupDynamicControls() {
        List<Item> kategoryList = kategoriaAmoService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());
        List<Item> rodzajGlowicyList = rodzajGlowicyBojService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        List<Item> rodzajGlowicyNaprowList = rodzajGlowicyNaprowService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        List<Item> rodzajNaprowList = rodzajNaprowService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());


        generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0,TextField.class, null);
        generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null);
        generateDynamicControl("KOD", "KOD", dynamicControls, 2, TextField.class, null);
        generateDynamicControl("KOD_NATO", "KOD_NATO", dynamicControls, 3, TextField.class, null);
        generateDynamicControl("KALIBER", "KALIBER", dynamicControls, 4, TextField.class, null);
        generateDynamicControl("SZTUK_W_PACZCE", "SZTUK_W_PACZCE", dynamicControls, 5, TextField.class, null);
        generateDynamicControl("MASA SZTUKI", "MASA SZTUKI", dynamicControls, 6, TextField.class, null);
        generateDynamicControl("WYM_PACZKI_X", "WYM_PACZKI_X", dynamicControls, 7, TextField.class, null);
        generateDynamicControl("WYM_PACZKI_Y", "WYM_PACZKI_Y", dynamicControls, 8, TextField.class, null);
        generateDynamicControl("WYM_PACZKI_Z", "WYM_PACZKI_Z", dynamicControls, 9, TextField.class, null);

        generateDynamicControl("KATEG_FK", "KATEGORIA", dynamicControls, 10, ChoiceBox.class, kategoryList);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTKATEGORIAAMOVIEW.getValue(), 2, 10);

        generateDynamicControl("RODZAJ_GLOWICY_BOJ_FK", "RODZAJ_GLOWICY_BOJ_FK", dynamicControls, 11, ChoiceBox.class, rodzajGlowicyList);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);

        generateDynamicControl("RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK", dynamicControls, 12, ChoiceBox.class, rodzajGlowicyNaprowList);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);

        generateDynamicControl("RODZAJ_NAPROW_FK", "RODZAJ_NAPROW_FK", dynamicControls, 13, ChoiceBox.class, rodzajGlowicyNaprowList);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
    }
    @FXML
    private void addButtonAction(){

    }
    @FXML
    private void deleteButtonAction() {

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
        deleteButton.disableProperty().bind(tableAmoController.getTableView().getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disabledProperty().addListener((observable, oldValue, newValue) -> updateDeleteButtonStyle());
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
