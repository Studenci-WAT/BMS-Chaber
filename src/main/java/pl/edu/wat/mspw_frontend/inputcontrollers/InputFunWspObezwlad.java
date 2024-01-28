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
import pl.edu.wat.mspw_backend.service.*;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczTrafObDto;
import pl.edu.wat.mspw_frontend.model.FunWspObezwladDto;
import pl.edu.wat.mspw_frontend.model.PoziomOddzialOgnDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunPstwoZniszczTrafObController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspObezwladController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunWspObezwlad {





    private FunWspObezwladService funWspObezwladService = new FunWspObezwladService();


    private TableFunWspObezwladController tablefunWspObezwladController;

    private PoziomOddzialOgnService poziomOddzialOgnService = new PoziomOddzialOgnService();



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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie dane do funkcji");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_FUN_WSP_OBEZWLAD.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tablefunWspObezwladController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablefunWspObezwladController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("POZIOM_ODDZIAL_OGN_FK", "POZIOM_ODDZIAL_OGN_FK", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WSP", "WSP", dynamicControls, 1, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("STRZEL_OPANC", "STRZEL_OPANC", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK", "POZIOM_WYSZK", dynamicControls, 3,TextField.class, null,controller,inputGridPane);


    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer poziom_oddzial_ogn_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_ODDZIAL_OGN_FKTextField",controller);
        Double wsp = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WSPTextField",controller);
        Boolean strzel_opanc = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"STRZEL_OPANCTextField",controller);
        Integer poziom_wyszk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_WYSZKTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funWspObezwladService.create(
                        FunWspObezwladDto.builder()
                                .poziomOddzialOgnFk(poziom_oddzial_ogn_fk)
                                .wsp(wsp)
                                .strzelOpanc(strzel_opanc)
                                .poziomWyszk(poziom_wyszk).build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablefunWspObezwladController != null) {
            tablefunWspObezwladController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        FunWspObezwladDto selectedFunWspObezwlad = tablefunWspObezwladController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFunWspObezwlad != null) {
            try{
                funWspObezwladService.delete(Long.valueOf(selectedFunWspObezwlad.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablefunWspObezwladController != null) {
            tablefunWspObezwladController.populateTable();
        }

    }


}
