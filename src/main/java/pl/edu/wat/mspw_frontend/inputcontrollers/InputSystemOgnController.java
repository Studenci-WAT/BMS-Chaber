package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.readcontrollers.TableSystemOgnController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InputSystemOgnController {

    private TableSystemOgnController tableSystemOgnController;
    @FXML
    private AnchorPane tableContainer; // Container dla TableMpsView
    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju systemu ognia");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA", 0);
        controller.generateTextField(inputGridPane,"SKROT","SKROT", 1);
        controller.generateTextField(inputGridPane,"SZYBKOSTRZELNOSC", "SZYBKOSTRZELNOŚĆ 1/MIN",2);
        controller.generateTextField(inputGridPane,"KALIBER", "KALIBER",3);
        controller.generateTextField(inputGridPane,"DLUG_SERII", "DLUG_SERII", 4);
        controller.generateTextField(inputGridPane,"CZAS_CELOWANIA", "CZAS_CELOWANIA", 5);
        controller.generateTextField(inputGridPane,"KLASA_PRZYRZ_OC","KLASA PRZYRZ OC", 6);
        controller.generateTextField(inputGridPane,"LICZBA_KAN_CEL", "LICZBA_KAN_CEL", 7);

        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "ARMATA",
                "ARMATOHAUBICA",
                "HAUBICA",
                "MOŹDZIEŻ",
                "GRANATNIK",
                "DZIAŁKO",
                "KARABIN",
                "WYRZUTNIA PK",
                "WYRZUTNIA PNK",
                "ZASOBNIK BOMB K",
                "ZASOBNIK BOMB NK",
                "WYRZUTNIA TORPED",
                "STAWIACZ MIN"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_SYSTEMU_OGN_FK", "RODZAJ_SYSTEMU_OGN_FK", 8, options1);
        controller.generateButton(inputGridPane, "RODZAJ_SYSTEMU_OGN_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 8);

        loadTableView(TableViews.TABLE_SYSTEM_OGN.getValue());
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableSystemOgnController = loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void addButtonAction(){

    }
    @FXML
    private void deleteButtonAction() {

    }
}
