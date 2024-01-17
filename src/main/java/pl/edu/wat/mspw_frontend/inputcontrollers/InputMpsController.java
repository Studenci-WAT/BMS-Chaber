package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_backend.model.MpsEntity;
import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_backend.util.MainDao;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.model.MpsDto;

public class InputMpsController {
    private MpsService mpsService ;

    @FXML
    private GridPane inputGridPane;

    @FXML
    private Label labelTitle;
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
    }

    @FXML
    private void addButton(){
        // Kod, który ma zostać wykonany, gdy użytkownik kliknie przycisk "DODAJ"
        // - Walidacja danych wejściowych
        // - Dodawanie danych do listy lub tabeli
        // - Komunikacja z bazą danych
        // - itp.

          mpsService.create(
                  MpsDto.builder()
                          .nazwa(getControlString(1))
                          .skrot(getControlString(3))
                          .kod(getControlString(5))
                          .build()
          );

    }

    private String getControlString ( int index) {
        Node node = inputGridPane.getChildren().get(index);
        if(node instanceof  TextField) {
            TextField textField = (TextField) node;
            return textField.getText();
        } else if (node instanceof  Label) {
            Label label = (Label) node;
            return label.getText();
        }
        return "";
    }
}
