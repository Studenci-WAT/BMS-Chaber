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
    private AmoService amoService = new AmoService();
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
    private BooleanProperty anyControlEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        setupTitle();
        setupDynamicControls();
        loadTableView(TableViews.TABLE_AMO.getValue());
        setupDynamicControlsListeners();
        setupButtonProperties();
        updateAnyTextFieldEmpty();
        InputControllerStatic.updateAddButtonStyle(addButton);
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


        InputControllerStatic.generateDynamicControl("NAZWA", "NAZWA", dynamicControls, 0,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SKROT", "SKRÓT", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KOD", "KOD", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KOD_NATO", "KOD_NATO", dynamicControls, 3, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KALIBER", "KALIBER", dynamicControls, 4, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SZTUK_W_PACZCE", "SZTUK_W_PACZCE", dynamicControls, 5, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MASA SZTUKI", "MASA SZTUKI", dynamicControls, 6, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_X", "WYM_PACZKI_X", dynamicControls, 7, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_Y", "WYM_PACZKI_Y", dynamicControls, 8, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYM_PACZKI_Z", "WYM_PACZKI_Z", dynamicControls, 9, TextField.class,null,controller,inputGridPane);

        InputControllerStatic.generateDynamicControl("KATEG_FK", "KATEGORIA", dynamicControls, 10, ChoiceBox.class, kategoryList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTKATEGORIAAMOVIEW.getValue(), 2, 10);

        InputControllerStatic.generateDynamicControl("RODZAJ_GLOWICY_BOJ_FK", "RODZAJ_GLOWICY_BOJ_FK", dynamicControls, 11, ChoiceBox.class, rodzajGlowicyList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);

        InputControllerStatic.generateDynamicControl("RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK", dynamicControls, 12, ChoiceBox.class, rodzajGlowicyNaprowList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);

        InputControllerStatic.generateDynamicControl("RODZAJ_NAPROW_FK", "RODZAJ_NAPROW_FK", dynamicControls, 13, ChoiceBox.class, rodzajNaprowList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
    }
    @FXML
    private void addButtonAction(){

       // InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {

    }
    private void setupDynamicControlsListeners() {
        dynamicControls.forEach((id, control) -> {
            if (control instanceof TextField) {
                ((TextField) control).textProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    InputControllerStatic.updateAddButtonStyle(addButton);
                });
            } else if (control instanceof ChoiceBox) {
                ((ChoiceBox<?>) control).valueProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    InputControllerStatic.updateAddButtonStyle(addButton);
                });
            } else if (control instanceof CheckBox) {
                ((CheckBox) control).selectedProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyTextFieldEmpty();
                    InputControllerStatic.updateAddButtonStyle(addButton);
                });
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    private void setupButtonProperties() {
        addButton.disableProperty().bind(anyControlEmpty);
        deleteButton.disableProperty().bind(tableAmoController.getTableView().getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disabledProperty().addListener((observable, oldValue, newValue) -> InputControllerStatic.updateDeleteButtonStyle(deleteButton));
    }
    private void updateAnyTextFieldEmpty() {
        anyControlEmpty.set(InputControllerStatic.isAnyControlEmpty(dynamicControls));
    }
}
