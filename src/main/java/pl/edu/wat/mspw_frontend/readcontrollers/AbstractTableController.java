package pl.edu.wat.mspw_frontend.readcontrollers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public abstract class AbstractTableController<T, S> {
    @FXML
    protected TableView<T> tableView;
    protected S service;

    protected abstract void initializeService();
    protected abstract List<T> fetchData();

    @FXML
    private void initialize() {
        initializeService();
        createTableColumns();
        // chwilowo tutaj tak ustawiam bo nie moge sobie poradzic z tymi tabelami i ich rozmiarem, wysuwaja sie strasznie
        tableView.setPrefHeight(USE_COMPUTED_SIZE);
        tableView.setPrefWidth(USE_COMPUTED_SIZE);
        tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        Platform.runLater(this::populateTable);

    }

    private void createTableColumns() {
        for (Field field : getGenericTypeClass().getDeclaredFields()) {
            TableColumn<T, String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(column);
        }
    }

    public void populateTable() {
        List<T> dataList = fetchData();
        tableView.setItems(FXCollections.observableArrayList(dataList));
    }

    protected abstract Class<T> getGenericTypeClass();

    public TableView<T> getTableView() {
        return tableView;
    }
}
