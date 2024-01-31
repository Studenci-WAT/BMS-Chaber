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
import pl.edu.wat.mspw_backend.service.EfektorJezdnyService;
import pl.edu.wat.mspw_backend.service.EfektorLacznService;
import pl.edu.wat.mspw_backend.service.RodzajPodwoziaService;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.model.EfektorJezdnyDto;
import pl.edu.wat.mspw_frontend.model.EfektorLacznDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorJezdnyController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableEfektorLacznController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputEfektorLacznController {
    private EfektorLacznService efektorLacznService = new EfektorLacznService();
    private TableEfektorLacznController tableEfektorLacznController;
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
        InputControllerStatic.setupTitle(labelTitle,"Wprowadzanie nowego efektora łączności");
        setupDynamicControls();
        loadTableView(TableViews.TABLE_EFEKTOR_LACZN.getValue());
        InputControllerStatic.setupDynamicControlsListeners(
                dynamicControls,
                addButton,
                anyControlEmpty
        );
        InputControllerStatic.setupButtonProperties(addButton,deleteButton,anyControlEmpty,tableEfektorLacznController);
        InputControllerStatic.updateAnyControlEmpty(anyControlEmpty,dynamicControls);
        InputControllerStatic.updateButtonStyle(addButton);
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableEfektorLacznController = loader.getController();

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

        InputControllerStatic.generateDynamicControl("LICZBA_TRAKTOW_KABL", "LICZBA_TRAKTOW_KABL", dynamicControls, 0, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LICZBA_TRAKTOW_RADIOL", "LICZBA_TRAKTOW_RADIOL", dynamicControls, 1,TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("LICZBA_SIECI_CNR_DO_PRZYLACZ", "LICZBA_SIECI_CNR_DO_PRZYLACZ", dynamicControls, 2, TextField.class, null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MOC_NADAJNIKA_RADIOL", "MOC_NADAJNIKA_RADIOL", dynamicControls, 3, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("WYSOK_ANTENY_RADIOL", "WYSOK_ANTENY_RADIOL", dynamicControls, 4, TextField.class,null, controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("MOC_NADAJNIKA", "MOC_NADAJNIKA", dynamicControls, 5, TextField.class ,null,controller,inputGridPane);
        InputControllerStatic.generateDynamicControl("ZASIEG_NADAJNIKA", "ZASIEG_NADAJNIKA", dynamicControls, 6, TextField.class,null,controller,inputGridPane);
    }
    @FXML
    private void addButtonAction(){

        Stage stage = (Stage) addButton.getScene().getWindow();
        Integer liczba_traktow_kabl = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"LICZBA_TRAKTOW_KABLTextField",controller);
        Integer liczba_traktow_radiol = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"LICZBA_TRAKTOW_RADIOLTextField",controller);
        Integer liczba_sieci_cnr_do_przylacz = InputControllerStatic.getIntegerControlValue(stage,inputGridPane,"LICZBA_SIECI_CNR_DO_PRZYLACZTextField",controller);
        Double moc_nadajnika_radiol = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"MOC_NADAJNIKA_RADIOLTextField",controller);
        Double wysok_anteny_radiol = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"WYSOK_ANTENY_RADIOLTextField",controller);
        Double moc_nadajnika = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"MOC_NADAJNIKATextField",controller);
        Double zasieg_nadajnika = InputControllerStatic.getDoubleControlValue(stage,inputGridPane,"ZASIEG_NADAJNIKATextField",controller);

        try {
            if (!InputControllerStatic.isAnyControlEmpty(dynamicControls)) {
                efektorLacznService.create(
                        EfektorLacznDto.builder()
                                .liczbaTraktowKabl(liczba_traktow_kabl)
                                .liczbaTraktowRadiol(liczba_traktow_radiol)
                                .liczbaSieciCnrDoPrzylacz(liczba_sieci_cnr_do_przylacz)
                                .mocNadajnikaRadiol(moc_nadajnika_radiol)
                                .wysokAntenyRadiol(wysok_anteny_radiol)
                                .mocNadajnika(moc_nadajnika)
                                .zasiegNadajnika(zasieg_nadajnika)
                                .build()
                );
            }
            showToast(stage, "Dodano Rekord!", Toast.ToastType.SUCCESS);
        } catch (Exception e) {
            showToast(stage, "Wystąpił błąd - sprawdź poprawność danych!", Toast.ToastType.ERROR);
        }

        if (tableEfektorLacznController != null) {
            tableEfektorLacznController.populateTable();
        }

        InputControllerStatic.clearDynamicControls(dynamicControls);
    }
    @FXML
    private void deleteButtonAction() {
        EfektorLacznDto selectedEfektorLaczn = tableEfektorLacznController.getTableView().getSelectionModel().getSelectedItem();
        Stage stage = (Stage) deleteButton.getScene().getWindow();
        if (selectedEfektorLaczn != null) {
            try{
                efektorLacznService.delete(Long.valueOf(selectedEfektorLaczn.getId()));
                showToast(stage, "Rekord usunięto!", Toast.ToastType.SUCCESS);

            }catch (Exception ex){
                showToast(stage, "Wystąpił błąd!", Toast.ToastType.ERROR);
            }
        } else {
            showToast(stage, "Wybierz rekord aby usunąć!", Toast.ToastType.INFO);
        }
        // Odświeżenie tabeli
        if (tableEfektorLacznController != null) {
            tableEfektorLacznController.populateTable();
        }

    }
}
