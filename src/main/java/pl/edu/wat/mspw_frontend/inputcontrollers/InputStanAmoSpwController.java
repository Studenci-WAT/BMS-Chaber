package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_backend.service.*;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.model.StanAmoSpwDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableStanAmoSpwController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputStanAmoSpwController {
    private StanAmoSpwService stanAmoSpwService = new StanAmoSpwService();
    private SprzetWojService sprzetWojService = new SprzetWojService();
    private AmoService amoService = new AmoService();
    private TableStanAmoSpwController tableController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie ilości amunicji dla sprzętu wojskowego");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_STAN_AMO_SPW.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
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
        List<Item> amoList = amoService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        List<Item> spwList = sprzetWojService.getAll().stream()
                .map(object -> new Item(object.getId(), object.getNazwa()))
                .collect(Collectors.toList());

        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 0, ChoiceBox.class, amoList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "AMO_FK", "#", Views.INPUTAMOVIEW.getValue(), 2, 0);

        InputControllerStatic.generateDynamicControl("SPW_FK", "SPW_FK", dynamicControls, 1, ChoiceBox.class, spwList,controller,inputGridPane);
        controller.generateButton(inputGridPane, "SPW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 1);

        InputControllerStatic.generateDynamicControl("STAN_NORMATYW", "STAN NORMATYWNY", dynamicControls, 2, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();

        Integer liczba = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"STAN_NORMATYWTextField",controller);

        Integer amo= InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"AMO_FKChoiceBox",controller);
        Integer spw= InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SPW_FKChoiceBox",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                stanAmoSpwService.create(
                        StanAmoSpwDto.builder()
                                .stanNormatyw(liczba)
                                .spwFk(spw)
                                .amoFk(amo)
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
        StanAmoSpwDto selectedAmoSpw = tableController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedAmoSpw != null) {
            try{
                stanAmoSpwService.delete(Long.valueOf(selectedAmoSpw.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
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

