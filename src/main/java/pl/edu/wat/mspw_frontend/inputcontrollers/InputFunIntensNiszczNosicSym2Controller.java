package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.FunIntensNiszczNosicSym2Service;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunIntensNiszczNosicSym2Dto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunIntensNiszczNosicSym2Controller;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.typKlimatuList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunIntensNiszczNosicSym2Controller {
    private FunIntensNiszczNosicSym2Service funIntensNiszczNosicSym2Service = new FunIntensNiszczNosicSym2Service();
    private TableFunIntensNiszczNosicSym2Controller tableController;

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
        InputControllerStatic.setupTitle(labelTitle, "Wprowadzanie danych do funkcji");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_FUN_INTENS_NISZCZ_NOSIC_SYM2.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton, deleteButton, anyControlEmpty, tableController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty, dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }

    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableController = loader.getController();

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
        InputControllerStatic.generateDynamicControl("TYP_KLIMATU_FK", "TYP_KLIMATU_FK", dynamicControls, 0, ChoiceBox.class, typKlimatuList, controller, inputGridPane);
        controller.generateButton(inputGridPane, "TYP_KLIMATU_FK", "#", Views.INPUTTYPKLIMATU.getValue(), 2, 0);

        InputControllerStatic.generateDynamicControl("POZIOM_FORT", "POZIOM_FORT", dynamicControls, 1, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("INTENSYWNOSC", "INTENSYWNOSC", dynamicControls, 2, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG", "ODLEG", dynamicControls, 3, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("CEL_OPANC", "CEL_OPANC", dynamicControls, 4, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK", "POZIOM_WYSZK", dynamicControls, 5, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_ZDOLN_MANEWR", "POZIOM_ZDOLN_MANEWR PRZYRZ OC", dynamicControls, 6, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("KLASA_STRZEL", "KLASA_STRZEL", dynamicControls, 7, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("KLASA_CELU", "KLASA_CELU", dynamicControls, 8, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("WSP_A", "WSP_A", dynamicControls, 9, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("WSP_B", "WSP_B", dynamicControls, 10, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZASIEG_MIN", "ZASIEG_MIN", dynamicControls, 11, TextField.class, null, controller, inputGridPane);
        InputControllerStatic.generateDynamicControl("ZASIEG_MAX", "ZASIEG_MAX", dynamicControls, 12, TextField.class, null, controller, inputGridPane);
    }

    @FXML
    private void addButtonAction() {
        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer typKlimatuFk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "TYP_KLIMATU_FKChoiceBox", controller);
        Integer poziomFort = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_FORTTextField", controller);
        Double intensywnosc = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "INTENSYWNOSCTextField", controller);
        Double odleg = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ODLEGTextField", controller);
        Boolean celOpanc = InputControllerStatic.getBooleanControlValue(stage, inputGridPane, "CEL_OPANCTextField", controller);
        Integer poziomWyszk = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "CEL_OPANCTextField", controller);
        Integer poziomZdolnManewr = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "POZIOM_ZDOLN_MANEWRTextField", controller);
        Integer klasaStrzel = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "KLASA_STRZELTextField", controller);
        Integer klasaCelu = InputControllerStatic.getIntegerControlValue(stage, inputGridPane, "KLASA_CELUTextField", controller);
        Double wspA = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "WSP_ATextField", controller);
        Double wspB = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "WSP_BTextField", controller);
        Double zasiegMin = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ZASIEG_MINTextField", controller);
        Double zasiegMax = InputControllerStatic.getDoubleControlValue(stage, inputGridPane, "ZASIEG_MAXTextField", controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funIntensNiszczNosicSym2Service.create(
                        FunIntensNiszczNosicSym2Dto.builder()
                                .typKlimatuFk(typKlimatuFk)
                                .poziomFort(poziomFort)
                                .intensywnosc(intensywnosc)
                                .odleg(odleg)
                                .celOpanc(celOpanc)
                                .poziomWyszk(poziomWyszk)
                                .poziomZdolnManewr(poziomZdolnManewr)
                                .klasaStrzel(klasaStrzel)
                                .klasaCelu(klasaCelu)
                                .wspA(wspA)
                                .wspB(wspB)
                                .zasiegMin(zasiegMin)
                                .zasiegMax(zasiegMax)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableController != null) {
            tableController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }

    @FXML
    private void deleteButtonAction() {
        FunIntensNiszczNosicSym2Dto selectedFireSys = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFireSys != null) {
            try {
                funIntensNiszczNosicSym2Service.delete(Long.valueOf(selectedFireSys.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            } catch (Exception ex) {
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableController != null) {
            tableController.populateTable();
        }
    }
}
