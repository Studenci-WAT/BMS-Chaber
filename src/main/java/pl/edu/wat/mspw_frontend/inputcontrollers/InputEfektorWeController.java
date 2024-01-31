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
import pl.edu.wat.mspw_backend.service.EfektorPlywaniaService;
import pl.edu.wat.mspw_backend.service.EfektorWeService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;
import pl.edu.wat.mspw_frontend.model.EfektorWeDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorPlywaniaController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorWeController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorWeController {
    private EfektorWeService efektorWeService = new EfektorWeService();
    private TableEfektorWeController tableEfektorWeController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora WE");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_WE.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorWeController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorWeController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("NAMIERZ_PROMIEN", "NAMIERZ_PROMIEŃ", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("NAMIERZ_CZESTOTLMIN", "NAMIERZ_CZĘSTOTLMIN", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("NAMIERZ_CZESTOTL_MAX", "NAMIERZ_CZĘSTOTL_MAX", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("NAMIERZ_CZAS", "NAMIERZ_CZAS", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("NAMIERZ_SZYBKOSC_PRZESZUK", "NAMIERZ_SZYBKOŚĆ_PRZESZUK", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZAKLOC_PROMIEN", "ZAKŁÓC_PROMIEŃ", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZAKLOC_CZESTOTL_MIN", "ZAKŁÓC_CZĘSTOTL_MIN", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZAKLOC_CZESTOTL_MAX", "ZAKŁÓC_CZĘSTOTL_MAX", dynamicControls, 7, TextField.class ,null,controller,inputGridPane);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer namierz_promien = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"NAMIERZ_PROMIENTextField",controller);
        Integer namierz_czestotlmin = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"NAMIERZ_CZESTOTLMINTextField",controller);
        Integer namierz_czestotl_max = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"NAMIERZ_CZESTOTL_MAXTextField",controller);
        Integer namierz_czas = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"NAMIERZ_CZASTextField",controller);
        Integer namierz_szybkosc_przeszuk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"NAMIERZ_SZYBKOSC_PRZESZUKTextField",controller);
        Integer zakloc_promien = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"ZAKLOC_PROMIENTextField",controller);
        Integer zakloc_czestotl_min = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"ZAKLOC_CZESTOTL_MINTextField",controller);
        Integer zakloc_czestotl_max = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"ZAKLOC_CZESTOTL_MAXTextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorWeService.create(
                        EfektorWeDto.builder()
                                .namierzPromien(namierz_promien)
                                .namierzCzestotlmin(namierz_czestotlmin)
                                .namierzCzestotlMax(namierz_czestotl_max)
                                .namierzCzas(namierz_czas)
                                .namierzSzybkoscPrzeszuk(namierz_szybkosc_przeszuk)
                                .zaklocPromien(zakloc_promien)
                                .zaklocCzestotlMin(zakloc_czestotl_min)
                                .zaklocCzestotlMax(zakloc_czestotl_max)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorWeController != null) {
            tableEfektorWeController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorWeDto selectedEfektorWe = tableEfektorWeController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorWe != null) {
            try{
                efektorWeService.delete(Long.valueOf(selectedEfektorWe.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorWeController != null) {
            tableEfektorWeController.populateTable();
        }

    }
}
