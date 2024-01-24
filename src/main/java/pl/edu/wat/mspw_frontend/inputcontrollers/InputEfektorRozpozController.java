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
import pl.edu.wat.mspw_backend.service.EfektorInzService;
import pl.edu.wat.mspw_backend.service.EfektorRozpozService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorInzDto;
import pl.edu.wat.mspw_frontend.model.EfektorRozpozDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorInzController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorRozpozController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorRozpozController {
    private EfektorRozpozService efektorRozpozService = new EfektorRozpozService();
    private TableEfektorRozpozController tableEfektorRopozController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora rozpoznania");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_ROZPOZ.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorRopozController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorRopozController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("ROZPOZ_AKUST", "ROZPOZ_AKUST", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_AKUST_PROMIEN", "ROZPOZ_AKUST_PROMIEN", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_TERMICZ", "ROZPOZ_TERMICZ", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_TERMICZ_PROMIEN_DZIEN", "ROZPOZ_TERMICZ_PROMIEN_DZIEN", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_TERMICZ_PROMIEN_NOC", "ROZPOZ_TERMICZ_PROMIEN_NOC", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_NOKTOW", "ROZPOZ_NOKTOW", dynamicControls, 5, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_NOKTOW_PROMIEN", "ROZPOZ_NOKTOW_PROMIEN", dynamicControls, 6, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_RADAR", "ROZPOZ_RADAR", dynamicControls, 7, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ROZPOZ_RADAR_PROMIEN", "ROZPOZ_RADAR_PROMIEN", dynamicControls, 8, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("KLASA_PRZYRZ_OC", "KLASA_PRZYRZ_OC", dynamicControls, 9, TextField.class,null, controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Boolean rozpoz_akust = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ROZPOZ_AKUSTTextField",controller);
        Double rozpoz_akust_promien = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ROZPOZ_AKUST_PROMIENTextField",controller);
        Boolean rozpoz_termicz = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ROZPOZ_TERMICZTextField",controller);
        Double rozpoz_termicz_promien_dzien = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ROZPOZ_TERMICZ_PROMIEN_DZIENTextField",controller);
        Double rozpoz_termicz_promien_noc = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ROZPOZ_TERMICZ_PROMIEN_NOCTextField",controller);
        Boolean rozpoz_noktow = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ROZPOZ_NOKTOWTextField",controller);
        Double rozpoz_noktow_promien = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ROZPOZ_NOKTOW_PROMIENTextField",controller);
        Boolean rozpoz_radar = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"ROZPOZ_RADARTextField",controller);
        Double rozpoz_radar_promien = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ROZPOZ_RADAR_PROMIENTextField",controller);
        Integer klasa_przyrz_oc = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"KLASA_PRZYRZ_OCTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorRozpozService.create(
                        EfektorRozpozDto.builder()
                                .rozpozAkust(rozpoz_akust)
                                .rozpozAkustPromien(rozpoz_akust_promien)
                                .rozpozTermicz(rozpoz_termicz)
                                .rozpozTermiczPromienDzien(rozpoz_termicz_promien_dzien)
                                .rozpozTermiczPromienNoc(rozpoz_termicz_promien_noc)
                                .rozpozNoktow(rozpoz_noktow)
                                .rozpozNoktowPromien(rozpoz_noktow_promien)
                                .rozpozRadar(rozpoz_radar)
                                .rozpozRadarPromien(rozpoz_radar_promien)
                                .klasaPrzyrzOc(klasa_przyrz_oc)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorRopozController != null) {
            tableEfektorRopozController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorRozpozDto selectedRozpozInz = tableEfektorRopozController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedRozpozInz != null) {
            try{
                efektorRozpozService.delete(Long.valueOf(selectedRozpozInz.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorRopozController != null) {
            tableEfektorRopozController.populateTable();
        }

    }
}
