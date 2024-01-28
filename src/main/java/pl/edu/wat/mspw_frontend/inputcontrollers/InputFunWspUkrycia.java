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
import pl.edu.wat.mspw_backend.service.FunWspUkryciaService;
import pl.edu.wat.mspw_backend.service.TypTerenuWidoczService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.FunWspUkryciaDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableFunWspUkryciaController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputFunWspUkrycia {





    private FunWspUkryciaService funWspUkryciaService = new FunWspUkryciaService();


    private TableFunWspUkryciaController tablefunWspUkryciaController;

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
        loadTableView(TableViews.TABLE_FUN_WSP_UKRYCIA.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tablefunWspUkryciaController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tablefunWspUkryciaController = loader.getController();

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
        InputControllerStatic.generateDynamicControl("POZIOM_FORT", "POZIOM_FORT", dynamicControls, 2, TextField.class, null,controller,inputGridPane);


    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer typ_terenu_widocz_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"TYP_TERENU_WIDOCZ_FKTextField",controller);
        Double wsp = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WSPTextField",controller);
        Integer poziom_fort = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"POZIOM_FORTTextField",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                funWspUkryciaService.create(
                        FunWspUkryciaDto.builder()
                                .typTerenuWidoczFk(typ_terenu_widocz_fk)
                                .wsp(wsp)
                                .poziomFort(poziom_fort).build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tablefunWspUkryciaController!= null) {
            tablefunWspUkryciaController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        FunWspUkryciaDto selectedFunWspUkrycia = tablefunWspUkryciaController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedFunWspUkrycia != null) {
            try{
                funWspUkryciaService.delete(Long.valueOf(selectedFunWspUkrycia.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tablefunWspUkryciaController != null) {
            tablefunWspUkryciaController.populateTable();
        }

    }

}
