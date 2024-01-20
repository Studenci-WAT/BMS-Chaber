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
import pl.edu.wat.mspw_frontend.readcontrollers.TableAmoController;
import pl.edu.wat.mspw_frontend.readcontrollers.TableMpsController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InputAmoController {
    private TableAmoController  tableAmoController;
    @FXML
    private AnchorPane tableContainer; // Container dla TableMpsView
    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju amunicji");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA","NAZWA", 0);
        controller.generateTextField(inputGridPane,"SKROT","SKROT", 1);
        controller.generateTextField(inputGridPane,"KOD","KOD", 2);
        controller.generateTextField(inputGridPane,"KOD_NATO", "KOD_NATO", 3);
        controller.generateTextField(inputGridPane,"KALIBER", "KALIBER",4);
        controller.generateTextField(inputGridPane,"SZTUK_W_PACZCE","SZTUK_W_PACZCE", 5);
        controller.generateTextField(inputGridPane,"MASA SZTUKI","MASA SZTUKI",  6);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_X","WYM_PACZKI_X", 7);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Y", "WYM_PACZKI_Y", 8);
        controller.generateTextField(inputGridPane,"WYM_PACZKI_Z", "WYM_PACZKI_Z",9);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options1 = Arrays.asList(
                "NABÓJ",
                "POCISK RAKIETOWY",
                "GRANAT",
                "BOMBA",
                "TORPEDA",
                "MINA LĄDOWA",
                "MINA MORSKA"
        );
        controller.generateChoiceBox(inputGridPane,"KATEG_FK", "KATEGORIA", 10, options1);
        controller.generateButton(inputGridPane, "KATEG_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 10);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options2 = Arrays.asList(
                "PRZEBIJAJĄCA",
                "KUMULACYJNA",
                "ODŁAMKOWA",
                "ODŁAMKOWO BURZĄCA",
                "BURZĄCA",
                "DYMNA",
                "OŚWIETLAJĄCA",
                "ZAKŁÓCAJĄCA",
                "ZAPALAJĄCA",
                "CHEMICZNA",
                "MINUJĄCA"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_BOJ_FK","RODZAJ_GLOWICY_BOJ_FK", 11, options2);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_BOJ_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 11);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options3 = Arrays.asList(
                "BRAK",
                "RADAROWE",
                "TERMICZNE",
                "LASEROWE",
                "OPTYCZNE",
                "GPS",
                "INERCYJNE",
                "DUALNA IR UV",
                "GPS INERCYJNE"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_GLOWICY_NAPROW_FK", "RODZAJ_GLOWICY_NAPROW_FK",12, options3);
        controller.generateButton(inputGridPane, "RODZAJ_GLOWICY_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 12);
        // TODO TE OPCJE TRZEBA BRAĆ Z TABEL SŁOWNIKOWYCH
        List<String> options4 = Arrays.asList(
                "BRAK",
                "RADIOWE",
                "PRZEWODOWE",
                "SAMONAPROWADZANIE PASYWNE",
                "SAMONAPROWADZANIE POLAKTYWNE",
                "SAMONAPROWADZANIE AKTYWNE"
        );
        controller.generateChoiceBox(inputGridPane,"RODZAJ_NAPROW_FK","RODZAJ_NAPROW_FK", 13, options4);
        controller.generateButton(inputGridPane, "RODZAJ_NAPROW_FK", "#", Views.INPUTSPWVIEW.getValue(), 2, 13);
        loadTableView(TableViews.TABLE_AMO.getValue());
    }
    private void loadTableView(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Node view = loader.load();

            tableAmoController = loader.getController();

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
