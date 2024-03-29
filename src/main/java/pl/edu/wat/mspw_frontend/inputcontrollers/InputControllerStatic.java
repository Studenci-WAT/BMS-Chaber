package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.beans.property.BooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.readcontrollers.AbstractTableController;
import pl.edu.wat.mspw_frontend.util.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static pl.edu.wat.mspw_frontend.util.Toast.showToast;

public class InputControllerStatic {

    public static void generateDynamicControl(
            String id,
            String label,
            Map<String, Control> container,
            int rowIndex,
            Class<? extends Control> controlType,
            ObservableList<Item> options,
            ControlGenerator controller,
            GridPane inputGridPane
    ) {
        Control control;
        if (controlType.equals(TextField.class)) {
            control = controller.generateTextField(inputGridPane, id, label, rowIndex);
        } else if (controlType.equals(ChoiceBox.class)) {
            if (options.isEmpty()) {
                throw new IllegalArgumentException("ChoiceBox requires options");
            }
            ChoiceBox<Item> choiceBox = controller.generateChoiceBox(inputGridPane, id, label, rowIndex, options);
            control = choiceBox;
        } else if (controlType.equals(CheckBox.class)) {
            control = controller.generateCheckBox(inputGridPane, id, label, rowIndex);
        } else {
            throw new IllegalArgumentException("Unsupported control type: " + controlType.getSimpleName());
        }

        container.put(id, control);
    }

    public static void clearDynamicControls(Map<String, Control> dynamicControls) {
        dynamicControls.forEach((id, control) -> {
            if (control instanceof TextField) {
                ((TextField) control).clear();
            } else if (control instanceof ChoiceBox) {
                ((ChoiceBox<?>) control).setValue(null);
            } else if (control instanceof CheckBox) {
                ((CheckBox) control).setSelected(false);
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    public static boolean isAnyControlEmpty(Map<String,Control> dynamicControls) {
        return dynamicControls.values().stream().anyMatch(control -> {
            if (control instanceof TextField) {
                return ((TextField) control).getText().isEmpty();
            } else if (control instanceof ChoiceBox) {
                return ((ChoiceBox<?>) control).getValue() == null;
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    public static void updateButtonStyle(Button button) {
        if (button.isDisabled()) {
            button.getStyleClass().remove("button-disabled");
            button.getStyleClass().remove("button-enabled");
            button.getStyleClass().add("button-disabled");
        } else {
            button.getStyleClass().remove("button-disabled");
            button.getStyleClass().remove("button-enabled");
            button.getStyleClass().add("button-enabled");
        }
    }



    public static void setupDynamicControlsListeners(Map<String, Control> dynamicControls, Button addButton, BooleanProperty anyControlEmpty) {
        dynamicControls.forEach((id, control) -> {
            if (control instanceof TextField) {
                ((TextField) control).textProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyControlEmpty(anyControlEmpty,dynamicControls);
                    InputControllerStatic.updateButtonStyle(addButton);
                });
            } else if (control instanceof ChoiceBox) {
                ((ChoiceBox<?>) control).valueProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyControlEmpty(anyControlEmpty,dynamicControls);
                    InputControllerStatic.updateButtonStyle(addButton);
                });
            } else if (control instanceof CheckBox) {
                ((CheckBox) control).selectedProperty().addListener((observable, oldValue, newValue) -> {
                    updateAnyControlEmpty(anyControlEmpty,dynamicControls);
                    InputControllerStatic.updateButtonStyle(addButton);
                });
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + control.getClass().getSimpleName());
            }
        });
    }

    public static void updateAnyControlEmpty(BooleanProperty anyControlEmpty, Map<String, Control> dynamicControls) {
        anyControlEmpty.set(InputControllerStatic.isAnyControlEmpty(dynamicControls));
    }

    public static void setupButtonProperties(Button addButton, Button deleteButton, BooleanProperty anyControlEmpty, AbstractTableController tableController) {
        addButton.disableProperty().bind(anyControlEmpty);
        deleteButton.disableProperty().bind(tableController.getTableView().getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disabledProperty().addListener((observable, oldValue, newValue) -> InputControllerStatic.updateButtonStyle(deleteButton));
    }

    public static void setupTitle(Label labelTitle, String text) {
        labelTitle.setText(text);
        labelTitle.setAlignment(Pos.CENTER);
    }

    public static <T> String getControlValue(GridPane parentContainer, String controlId, Class<T> controlType, ControlGenerator controller) {
        Node control = controller.findControlById(parentContainer, controlId);

        if (controlType.isInstance(control)) {
            if (controlType.equals(TextField.class)) {
                return ((TextField) control).getText();
            } else if (controlType.equals(ChoiceBox.class)) {
                Object selectedValue = ((ChoiceBox<Item>) control).getValue().getId();
                return selectedValue != null ? selectedValue.toString() : null;
            } else if (controlType.equals(CheckBox.class)) {
                return Boolean.toString(((CheckBox) control).isSelected());
            } else {
                throw new IllegalArgumentException("Unsupported control type: " + controlType.getSimpleName());
            }
        } else {
            throw new IllegalArgumentException("Control with ID " + controlId + " not found or is not of type " + controlType.getSimpleName());
        }
    }

    public static Double getDoubleControlValue(Stage stage, GridPane parentContainer, String controlId, ControlGenerator controller) {
        Node control = controller.findControlById(parentContainer, controlId);

        if (control instanceof TextField) {
            try {
                String text = ((TextField) control).getText();
                return text.isEmpty() ? null : Double.parseDouble(text);
            } catch (NumberFormatException e) {
                showToast(stage, "Wystąpił błąd - invalid double value for TextField with ID " + controlId, Toast.ToastType.ERROR);
                throw new IllegalArgumentException("Invalid double value for TextField with ID " + controlId);
            }
        } else if (control instanceof ChoiceBox) {
            Object selectedValue = ((ChoiceBox<Item>) control).getValue().getId();
            if (selectedValue instanceof Double) {
                return (Double) selectedValue;
            } else {
                showToast(stage, "Wystąpił błąd - invalid double value for Choicebox with ID " + controlId, Toast.ToastType.ERROR);
                throw new IllegalArgumentException("Invalid double value for ChoiceBox with ID " + controlId);
            }
        } else {
            throw new IllegalArgumentException("Unsupported control type or control not found for ID " + controlId);
        }
    }

    public static Integer getIntegerControlValue(Stage stage, GridPane parentContainer, String controlId, ControlGenerator controller) {
        Node control = controller.findControlById(parentContainer, controlId);

        if (control instanceof TextField) {
            try {
                String text = ((TextField) control).getText();
                return text.isEmpty() ? null : Integer.parseInt(text);
            } catch (NumberFormatException e) {
                showToast(stage, "Wystąpił błąd - invalid integer value for TextField with ID " + controlId, Toast.ToastType.ERROR);
                throw new IllegalArgumentException("Invalid integer value for TextField with ID " + controlId);
            }
        } else if (control instanceof ChoiceBox) {
            Object selectedValue = ((ChoiceBox<Item>) control).getValue().getId();
            if (selectedValue instanceof Integer) {
                return (Integer) selectedValue;
            } else {
                showToast(stage, "Wystąpił błąd - invalid integer value for Choicebox with ID " + controlId, Toast.ToastType.ERROR);
                throw new IllegalArgumentException("Invalid integer value for ChoiceBox with ID " + controlId);
            }
        } else {
            throw new IllegalArgumentException("Unsupported control type or control not found for ID " + controlId);
        }
    }

    public static Boolean getBooleanControlValue(Stage stage, GridPane parentContainer, String controlId, ControlGenerator controller) {
        Node control = controller.findControlById(parentContainer, controlId);

        if (control instanceof CheckBox) {
                return ((CheckBox) control).isSelected();
        } else if (control instanceof ChoiceBox) {
            Object selectedValue = ((ChoiceBox<Item>) control).getValue().getId();
            if (selectedValue instanceof Integer) {
                return (Boolean) selectedValue;
            } else {
                showToast(stage, "Wystąpił błąd - invalid boolean value for Choicebox with ID " + controlId, Toast.ToastType.ERROR);
                throw new IllegalArgumentException("Invalid boolean value for ChoiceBox with ID " + controlId);
            }
        } else {
            throw new IllegalArgumentException("Unsupported control type or control not found for ID " + controlId);
        }
    }

}
