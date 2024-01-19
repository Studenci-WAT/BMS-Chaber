package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_frontend.enums.Views;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.MpsDto;
import pl.edu.wat.mspw_frontend.readcontrollers.TableMpsController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputMpsController {
    private MpsService mpsService;
    private TableMpsController tableMpsController;

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
    @FXML
    private AnchorPane tableMpsContainer; // Container dla TableMpsView

    private ControlGenerator controller = new ControlGenerator();
    public void initialize() {
        // ustawienie tytulu strony
        labelTitle.setText("Wprowadzanie nowego rodzaju MPS");
        labelTitle.setAlignment(Pos.CENTER); // Ustawienie wyrównania tekstu na środek

        // generowanie kontrolek
        controller.generateTextField(inputGridPane,"NAZWA", "NAZWA",0);
        controller.generateTextField(inputGridPane,"SKROT","SKRÓT", 1);
        controller.generateTextField(inputGridPane,"KOD", "KOD",2);

        mpsService = new MpsService();
        loadTableMpsView();
    }
    private void loadTableMpsView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Views.MPSTABVIEW.getValue()));
            Node view = loader.load();

            tableMpsController = loader.getController();

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

            tableMpsContainer.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void addButtonAction(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        // - itp.
        TextField nazwaTextField = (TextField) controller.findControlById(inputGridPane, "NAZWATextField");
        TextField skrotTextField = (TextField) controller.findControlById(inputGridPane, "SKROTTextField");
        TextField kodTextField = (TextField) controller.findControlById(inputGridPane, "KODTextField");

        if(nazwaTextField.getText() != null || skrotTextField.getText() != null || kodTextField.getText() != null) {
            mpsService.create(
                    MpsDto.builder()
                            .nazwa(nazwaTextField.getText())
                            .skrot(skrotTextField.getText())
                            .kod(kodTextField.getText())
                            .build()
            );
        }
        // Odświeżenie tabeli
        if (tableMpsController != null) {
            tableMpsController.populateTable();
        }
    }
    @FXML
    private void deleteButtonAction() {
        MpsDto selectedMps = tableMpsController.getTableView().getSelectionModel().getSelectedItem();
        if (selectedMps != null) {
            // Przekazanie ID do metody delete
            mpsService.delete(Long.valueOf(selectedMps.getId()));
        } else {
            // Pokaż komunikat, że nie wybrano rekordu
        }
        // Odświeżenie tabeli
        if (tableMpsController != null) {
            tableMpsController.populateTable();
        }
    }


}
