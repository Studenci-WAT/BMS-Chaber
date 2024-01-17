package pl.edu.wat.mspw_frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.IOException;

import pl.edu.wat.mspw_frontend.enums.Views;

public class MainViewController {
    @FXML
    private StackPane contentArea;

    @FXML
    private TabPane tabPane;
    public void initialize() {
        // Dynamiczne tworzenie zakładek
        addTabWithDynamicGridPane("CREATE", 1, 6);
        addTabWithDynamicGridPane("READ", 1, 6);

        // Tworzenie przycisków dynamicznie w pierwszej zakładce
        GridPane firstTabGridPane = (GridPane) ((AnchorPane) tabPane.getTabs().get(0).getContent()).getChildren().get(0);
        generateNavigationButton(firstTabGridPane, "TEMPLATE VIEW", "templateInputNavigator", 0);
        generateNavigationButton(firstTabGridPane, "RODZAJ AMUNICJI", "amoInputNavigator", 1);
        generateNavigationButton(firstTabGridPane, "SYSTEM OGNIA", "sysOgnInputNavigator", 2);
        generateNavigationButton(firstTabGridPane, "SPW", "spwInputNavigator", 3);
        generateNavigationButton(firstTabGridPane, "MPS", "mpsInputNavigator", 4);
        // Dodaj więcej przycisków w pierwszej zakładce, jeśli jest to potrzebne
    }
    public void loadView(String fxmlPath) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
            // Obsługa błędu
        }
    }
    private void generateNavigationButton(GridPane gridPane, String text, String id, int rowIndex) {
        Button button = new Button(text);
        button.setId(id);
        button.setOnAction(event -> handleButtonAction(event));

        HBox hBox = new HBox(button); // HBox do wyśrodkowania przycisku
        hBox.setAlignment(Pos.CENTER); // Wyśrodkowanie przycisku w HBox

        addElementToGridPane(gridPane, hBox, 0, rowIndex); // Dodaje HBox do GridPane
    }


    private void addTabWithDynamicGridPane(String tabTitle, int numberOfColumns, int numberOfRows) {
        GridPane gridPane = new GridPane();
        setupDynamicGridPane(gridPane, numberOfColumns, numberOfRows);

        AnchorPane anchorPane = new AnchorPane(gridPane);
        AnchorPane.setTopAnchor(gridPane, 34.0);
        AnchorPane.setLeftAnchor(gridPane, -6.0);

        Tab tab = new Tab(tabTitle);
        tab.setContent(anchorPane);
        tabPane.getTabs().add(tab);
    }

    private void handleButtonAction(ActionEvent event) {
        // Obsługa akcji przycisku
        Button clickedButton = (Button) event.getSource();
        switch(clickedButton.getId()){
            case "templateInputNavigator":
                loadView(Views.INPUTTEMPLATEVIEW.getValue());
                break;
            case "amoInputNavigator":
                loadView(Views.INPUTAMOVIEW.getValue());
                break;
            case "sysOgnInputNavigator":
                loadView(Views.INPUTSYSOGNVIEW.getValue());
                break;
            case "spwInputNavigator":
                loadView(Views.INPUTSPWVIEW.getValue());
                break;
            case "mpsInputNavigator":
                loadView(Views.INPUTMPSVIEW.getValue());
                break;

        }
    }

    private void setupDynamicGridPane(GridPane gridPane, int numberOfColumns, int numberOfRows) {
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();

        // Ustawienia dla kolumn
        for (int i = 0; i < numberOfColumns; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHalignment(HPos.CENTER); // Wyśrodkowanie w poziomie
            columnConstraints.setHgrow(Priority.SOMETIMES);
            // Usunięcie ustawienia prefWidth może pomóc w lepszym wyśrodkowaniu
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        // Ustawienia dla wierszy
        for (int i = 0; i < numberOfRows; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setMinHeight(10);
            rowConstraints.setPrefHeight(50); // Zwiększona wysokość dla większych odstępów
            rowConstraints.setVgrow(Priority.SOMETIMES);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        gridPane.setVgap(10); // Ustawienie pionowego odstępu między wierszami
    }

    private void addElementToGridPane(GridPane gridPane, Node element, int columnIndex, int rowIndex) {
        gridPane.add(element, columnIndex, rowIndex);
        GridPane.setHalignment(element, HPos.CENTER); // Ustawienie wyrównania poziomego
        GridPane.setValignment(element, VPos.CENTER); // Ustawienie wyrównania pionowego
        GridPane.setMargin(element, new Insets(10, 0, 10, 50)); // Ustawienie marginesów
    }



}
