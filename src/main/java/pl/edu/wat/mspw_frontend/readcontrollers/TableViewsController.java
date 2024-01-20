package pl.edu.wat.mspw_frontend.readcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import pl.edu.wat.mspw_frontend.enums.TableViews;
import pl.edu.wat.mspw_frontend.enums.Views;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class TableViewsController {
    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        // Iterowanie przez wszystkie wartości enuma TableViews i tworzenie zakładek
        for (TableViews tableView : TableViews.values()) {
            Tab tab = new Tab(tableView.name());
            loadViewToTab(tab, tableView.getValue());
            tabPane.getTabs().add(tab);
        }

        // Ustawienie polityki skalowania zakładek, aby wypełniały dostępną przestrzeń
        tabPane.setTabMinWidth(Region.USE_PREF_SIZE);
        tabPane.setTabMaxWidth(Double.MAX_VALUE); // Ustawienie maksymalnej szerokości na 'nieskończoność'
        tabPane.setTabMinHeight(Region.USE_PREF_SIZE);
        tabPane.setTabMaxHeight(Double.MAX_VALUE); // Ustawienie maksymalnej wysokości na 'nieskończoność'
    }


    private void loadViewToTab(Tab tab, String fxmlPath) {
        try {
            URL url = getClass().getResource(fxmlPath);
            if (url == null) {
                throw new IOException("Cannot find resource: " + fxmlPath);
            }
            FXMLLoader loader = new FXMLLoader(url);
            Node view = loader.load();

            AnchorPane anchorPane = new AnchorPane();
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            anchorPane.getChildren().add(view);

            tab.setContent(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Appropriate error handling
        }
    }

}

