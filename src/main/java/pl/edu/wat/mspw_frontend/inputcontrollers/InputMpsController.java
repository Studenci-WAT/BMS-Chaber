package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.MpsDto;

import java.util.ArrayList;
import java.util.List;

public class InputMpsController {
    private MpsService mpsService ;

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;

    @FXML
    private TableView<MpsDto> mpsTable;
    @FXML
    private TableColumn<MpsDto, String> skrot;
    @FXML
    private TableColumn<MpsDto, String> nazwa;
    @FXML
    private TableColumn<MpsDto, String> kod;
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
        populateTable();
    }

    @FXML
    private void addButton(){
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
        updateTable();
    }

    private void populateTable() {
        skrot.setCellValueFactory(new PropertyValueFactory<>("skrot"));
        nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        kod.setCellValueFactory(new PropertyValueFactory<>("kod"));
        updateTable();

    }

    private void updateTable(){
        List<MpsDto> mpsDtoList = mpsService.getAll();
        ArrayList<MpsDto> mpsDtoArrayList = new ArrayList<>(mpsDtoList);
        mpsTable.setItems(FXCollections.observableArrayList(mpsDtoArrayList));
    }
}
