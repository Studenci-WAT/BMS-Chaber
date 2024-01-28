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
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczOpDto;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczTrafObDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunPstwoZniszczOpController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunPstwoZniszczTrafObController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunPstwoZniszczTrafOb {



    private FunPstwoZniszczTrafObService funPstwoZniszczTrafObServiceService = new FunPstwoZniszczTrafObService();


    private TableFunPstwoZniszczTrafObController tablefunPstwoZniszczTrafObController;

    private AmoService amoService = new AmoService();

    private SystemOgnService systemOgnService = new SystemOgnService();


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
        loadTableView(TableViews.TABLE_FUN_PSTWO_ZNISZCZ_TRAF_OB.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tablefunPstwoZniszczTrafObController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablefunPstwoZniszczTrafObController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("SYS_OGN_FK", "SYS_OGN_FK", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("AMO_FK", "AMO_FK", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SPW_CEL_FK", "SPW_CEL_FK", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PSTWO", "PSTWO", dynamicControls, 3,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ODLEG", "ODLEG", dynamicControls, 4, TextField.class, null,controller,inputGridPane);


    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer sys_ogn_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SYS_OGN_FKTextField",controller);
        Integer amo_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"AMO_FKTextField",controller);
        Integer spw_cel_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"SPW_CEL_FKTextField",controller);
        Double pstwo = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PSTWOTextField",controller);
        Double odleg = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ODLEGTextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funPstwoZniszczTrafObServiceService.create(
                        FunPstwoZniszczTrafObDto.builder()
                                .sysOgnFk(sys_ogn_fk)
                                .amoFk(amo_fk)
                                .spwCelFk(spw_cel_fk)
                                .pstwo(pstwo)
                                .odleg(odleg)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablefunPstwoZniszczTrafObController != null) {
            tablefunPstwoZniszczTrafObController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        FunPstwoZniszczTrafObDto selectedFunPstwoZniszczTrafOb = tablefunPstwoZniszczTrafObController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFunPstwoZniszczTrafOb != null) {
            try{
                funPstwoZniszczTrafObServiceService.delete(Long.valueOf(selectedFunPstwoZniszczTrafOb.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablefunPstwoZniszczTrafObController != null) {
            tablefunPstwoZniszczTrafObController.populateTable();
        }

    }

}
