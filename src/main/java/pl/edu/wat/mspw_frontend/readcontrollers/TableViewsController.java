package pl.edu.wat.mspw_frontend.readcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import pl.edu.wat.mspw_frontend.enums.Views;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TableViewsController {
    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        // Tworzenie zakładek
        Tab tab1 = new Tab("MPS");
        Tab tab2 = new Tab("Amo");
        Tab tab3 = new Tab("Spw");
        // Dodawanie zakładek do TabPane
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        loadViewToTab(tab1, Views.MPSTABVIEW.getValue());
        loadViewToTab(tab2, Views.AMOTABVIEW.getValue());
        loadViewToTab(tab3, Views.SPWTABVIEW.getValue());
    }

    private void loadViewToTab(Tab tab, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Node view = loader.load();

            // Ustawianie widoku w AnchorPane dla dynamicznego skalowania
            AnchorPane anchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            anchorPane.getChildren().add(view);

            tab.setContent(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Obsługa błędu
        }
    }
}

