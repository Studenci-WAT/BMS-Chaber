package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_backend.service.AmoService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputAmoController {
    private AmoService amoService;
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
    private Map<String, TextField> dynamicTextFields = new HashMap<>();
    private BooleanProperty anyTextFieldEmpty = new SimpleBooleanProperty(false);
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        setupTitle();
        setupDynamicTextFields();
        amoService = new AmoService();
        loadTableView(TableViews.TABLE_AMO.getValue());
        setupDynamicTextFieldsListeners();
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

    private void setupDynamicTextFields() {
        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA", 0);
        controller.generateTextField(inputGridPane,"SKROT","SKROT", 1);
        controller.generateTextField(inputGridPane,"KOD","KOD", 2);
        controller.generateTextField(inputGridPane,"KOD_NATO", "KOD_NATO", 3);
        controller.generateTextField(inputGridPane,"KALIBER", "KALIBER",4);
        controller.generateTextField(inputGridPane,"SZTUK_W_PACZCE","SZTUK_W_PACZCE", 5);
        controller.generateTextField(inputGridPane,"MASA SZTUKI","MASA SZTUKI",  6);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_X","WYM_PACZKI_X", 7);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Y", "WYM_PACZKI_Y", 8);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Z", "WYM_PACZKI_Z",9);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "NABÓJ",
                "POCISK RAKIETOWY",
                "GRANAT",
                "BOMBA",
                "TORPEDA",
                "MINA LĄDOWA",
                "MINA MORSKA"
        );
        //controller.generateChoiceBox(inputGridPane,"KATEG_FK", "KATEGORIA", 10, options1);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 10);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options2 = Arrays.asList(
                "PRZEBIJAJĄCA",
                "KUMULACYJNA",
                "ODŁAMKOWA",
                "ODŁAMKOWO BURZĄCA",
                "BURZĄCA",
                "DYMNA",
                "OŚWIETLAJĄCA",
                "ZAKŁÓCAJĄCA",
                "ZAPALAJĄCA",
                "CHEMICZNA",
                "MINUJĄCA"
        );
       // controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_BOJ_FK","RODZAJ_GLOWICY_BOJ_FK", 11, options2);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options3 = Arrays.asList(
                "BRAK",
                "RADAROWE",
                "TERMICZNE",
                "LASEROWE",
                "OPTYCZNE",
                "GPS",
                "INERCYJNE",
                "DUALNA IR UV",
                "GPS INERCYJNE"
        );
        //controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK",12, options3);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options4 = Arrays.asList(
                "BRAK",
                "RADIOWE",
                "PRZEWODOWE",
                "SAMONAPROWADZANIE PASYWNE",
                "SAMONAPROWADZANIE POLAKTYWNE",
                "SAMONAPROWADZANIE AKTYWNE"
        );
        //controller.generateChoiceBox(inputGridPane,"RODZAJ_NAPROW_FK","RODZAJ_NAPROW_FK", 13, options4);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
    }
    @FXML
    private void addButtonAction(){

    }
    @FXML
    private void deleteButtonAction() {

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
        deleteButton.disableProperty().bind(tableAmoController.getTableView().getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disabledProperty().addListener((observable, oldValue, newValue) -> updateDeleteButtonStyle());
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
