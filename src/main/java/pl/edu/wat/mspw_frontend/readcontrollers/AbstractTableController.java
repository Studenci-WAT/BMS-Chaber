package pl.edu.wat.mspw_frontend.readcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

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
        populateTable();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    private void createTableColumns() {
        for (Field field : getGenericTypeClass().getDeclaredFields()) {
            TableColumn<T, String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(column);
        }
    }

    private void populateTable() {
        List<T> dataList = fetchData();
        tableView.setItems(FXCollections.observableArrayList(dataList));
    }

    protected abstract Class<T> getGenericTypeClass();
}
