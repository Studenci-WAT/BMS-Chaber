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
import pl.edu.wat.mspw_backend.service.FunWspWidoczDlaStrzelService;
import pl.edu.wat.mspw_backend.service.FunWspWidoczDlaWykrService;
import pl.edu.wat.mspw_backend.service.TypTerenuWidoczService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaStrzelDto;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaWykrDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspWidoczDlaStrzelController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspWidoczDlaWykrController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunWspWidoczDlaWykr {


    private FunWspWidoczDlaWykrService funWspWidoczDlaWykrService = new FunWspWidoczDlaWykrService();


    private TableFunWspWidoczDlaWykrController tablefunWspWidoczDlaWykrController;

    private TypTerenuWidoczService poziomOddzialOgnService = new TypTerenuWidoczService();


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
        loadTableView(TableViews.TABLE_FUN_WSP_WIDOCZ_DLA_WYKR.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tablefunWspWidoczDlaWykrController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablefunWspWidoczDlaWykrController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("TYP_TERENU_WIDOCZ_FK", "TYP_TERENU_WIDOCZ_FK", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WSP", "WSP", dynamicControls, 1, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_ZADYM_ISTOTNY", "POZIOM_ZADYM_ISTOTNY", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_ZAMGL_ISTOTNY", "POZIOM_ZAMGL_ISTOTNY", dynamicControls, 3,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_OPAD_ISTOTNY", "POZIOM_OPAD_ISTOTNY", dynamicControls, 4, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_MASK_ISTOTNY", "POZIOM_MASK_ISTOTNY", dynamicControls, 5, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("DZIEN", "DZIEN", dynamicControls, 6, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_WYSZK", "POZIOM_WYSZK", dynamicControls, 7,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("POZIOM_FORT", "POZIOM_FORT", dynamicControls, 8, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("TYP_PRZYRZADOW_OC_FK", "TYP_PRZYRZADOW_OC_FK", dynamicControls, 9, TextField.class, null,controller,inputGridPane);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer typ_przyrzadow_oc_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"TYP_PRZYRZADOW_OC_FKTextField",controller);
        Double wsp = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WSPTextField",controller);
        boolean poziom_zadym_istotny = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"POZIOM_ZADYM_ISTOTNYTextField",controller);
        boolean poziom_zamgl_istotny = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"POZIOM_ZAMGL_ISTOTNYTextField",controller);
        boolean poziom_opad_istotny = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"POZIOM_OPAD_ISTOTNYTextField",controller);
        boolean poziom_mask_istotny = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"POZIOM_MASK_ISTOTNYTextField",controller);
        boolean dzien = InputControllerStatic.getBooleanControlValue(stage,inputGridPane,"DZIENTextField",controller);
        Integer poziom_wyszk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_WYSZKTextField",controller);
        Integer poziom_fort = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_FORT_MANEWRTextField",controller);
        Integer typ_terenu_widocz_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"TYP_PRZYRZADOW_OC_FKTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funWspWidoczDlaWykrService.create(
                        FunWspWidoczDlaWykrDto.builder()
                                .typTerenuWidoczFk(typ_terenu_widocz_fk)
                                .wsp(wsp)
                                .poziomZadymIstotny(poziom_zadym_istotny)
                                .poziomZamglIstotny(poziom_zamgl_istotny)
                                .poziomOpadIstotny(poziom_opad_istotny)
                                .poziomMaskIstotny(poziom_mask_istotny)
                                .dzien(dzien)
                                .poziomWyszk(poziom_wyszk)
                                .poziomFort(poziom_fort)
                                .typPrzyrzadowOcFk(typ_przyrzadow_oc_fk)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablefunWspWidoczDlaWykrController != null) {
            tablefunWspWidoczDlaWykrController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        FunWspWidoczDlaWykrDto selectedFunWspWidoczDlaWykr = tablefunWspWidoczDlaWykrController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFunWspWidoczDlaWykr != null) {
            try{
                funWspWidoczDlaWykrService.delete(Long.valueOf(selectedFunWspWidoczDlaWykr.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablefunWspWidoczDlaWykrController != null) {
            tablefunWspWidoczDlaWykrController.populateTable();
        }

    }
}
