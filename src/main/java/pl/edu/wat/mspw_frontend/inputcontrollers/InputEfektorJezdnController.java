package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
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
import pl.edu.wat.mspw_frontend.model.AmoDto;
import pl.edu.wat.mspw_frontend.model.EfektorJezdnyDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorJezdnyController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.edu.wat.mspw_frontend.interfaces.ChoiceList.kategoryRodzajPodwoziaList;
import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorJezdnController {

    private EfektorJezdnyService efektorJezdnyService = new EfektorJezdnyService();
    private RodzajPodwoziaService rodzajPodwoziaService = new RodzajPodwoziaService();
    private TableEfektorJezdnyController tableEfektorJezdnyController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora jezdnego");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_JEZDNY.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorJezdnyController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorJezdnyController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_EKO_DROGA", "ZUZYCIE_PALIWA_PREDK_EKO_DROGA", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_PREDK_EKO_TEREN", "ZUZYCIE_PALIWA_PREDK_EKO_TEREN", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZUZYCIE_PALIWA_MAX", "ZUZYCIE_PALIWA_MAX", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_MAX_DROGA", "PREDK_MAX_DROGA", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_MAX_TEREN", "PREDK_MAX_TEREN", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_EKO_DROGA", "PREDK_EKO_DROGA", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("PREDK_EKO_TEREN", "PREDK_EKO_TEREN", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("SZEROK_POKONYW_ROWOW", "SZEROK_POKONYW_ROWÓW", dynamicControls, 7, TextField.class,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("GLEBOK_BRODZ", "GLEBOK_BRODZ", dynamicControls, 8, TextField.class,null,controller,inputGridPane);

        InputControllerStatic.generateDynamicControl("RODZAJ_PODWOZIA_FK", "RODZAJ_PODWOZIA", dynamicControls, 9, ChoiceBox.class, kategoryRodzajPodwoziaList ,controller,inputGridPane);
        controller.generateButton(inputGridPane, "RODZAJ_PODWOZIA_FK", "#", Views.INPUTRODZAJPODWOZIA.getValue(), 2, 9);

    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Double zuzycie_paliwa_predk_eko_droga = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_EKO_DROGATextField",controller);
        Double zuzycie_paliwa_predk_eko_teren = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_PREDK_EKO_TERENTextField",controller);
        Double zuzycie_paliwa_max = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZUZYCIE_PALIWA_MAXTextField",controller);
        Double predk_max_droga = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MAX_DROGATextField",controller);
        Double predk_max_teren = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_MAX_TERENTextField",controller);
        Double predk_eko_droga = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_EKO_DROGATextField",controller);
        Double predk_eko_teren = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"PREDK_EKO_TERENTextField",controller);
        Double szerok_pokonyw_rowow = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"SZEROK_POKONYW_ROWOWTextField",controller);
        Double glebok_brodz = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"GLEBOK_BRODZTextField",controller);

        Integer rodzaj_podwozia_fk = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"RODZAJ_PODWOZIA_FKChoiceBox",controller);


        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorJezdnyService.create(
                        EfektorJezdnyDto.builder()
                                .rodzajPodwoziaFk(rodzaj_podwozia_fk)
                                .zuzyciePaliwaPredkEkoDroga(zuzycie_paliwa_predk_eko_droga)
                                .zuzyciePaliwaPredkEkoTeren(zuzycie_paliwa_predk_eko_teren)
                                .zuzyciePaliwaMax(zuzycie_paliwa_max)
                                .predkMaxDroga(predk_max_droga)
                                .predkMaxTeren(predk_max_teren)
                                .predkEkoDroga(predk_eko_droga)
                                .predkEkoTeren(predk_eko_teren)
                                .szerokPokonywRowow(szerok_pokonyw_rowow)
                                .glebokBrodz(glebok_brodz)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorJezdnyController != null) {
            tableEfektorJezdnyController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorJezdnyDto selectedEfektorJezdny = tableEfektorJezdnyController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorJezdny != null) {
            try{
                efektorJezdnyService.delete(Long.valueOf(selectedEfektorJezdny.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorJezdnyController != null) {
            tableEfektorJezdnyController.populateTable();
        }

    }
}
