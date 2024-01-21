package pl.edu.wat.mspw_frontend.inputcontrollers;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import pl.edu.wat.mspw_frontend.interfaces.ControlGenerator;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.readcontrollers.AbstractTableController;

import java.util.List;
import java.util.Map;

public class InputControllerStatic {

    public static void generateDynamicControl(
            String id,
            String label,
            Map<String, Control> container,
            int rowIndex,
            Class<? extends Control> controlType,
            List<Item> options,
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
            choiceBox.getItems().addAll(options);
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

    public static void updateAddButtonStyle(Button addButton) {
        if (addButton.isDisabled()) {
            addButton.getStyleClass().remove("button-disabled");
            addButton.getStyleClass().remove("button-enabled");
            addButton.getStyleClass().add("button-disabled");
        } else {
            addButton.getStyleClass().remove("button-disabled");
            addButton.getStyleClass().remove("button-enabled");
            addButton.getStyleClass().add("button-enabled");
        }
    }

    public static void updateDeleteButtonStyle(Button deleteButton) {
        if (deleteButton.isDisabled()) {
            deleteButton.getStyleClass().remove("button-disabled");
            deleteButton.getStyleClass().remove("button-enabled");
            deleteButton.getStyleClass().add("button-disabled");
        } else {
            deleteButton.getStyleClass().remove("button-disabled");
            deleteButton.getStyleClass().remove("button-enabled");
            deleteButton.getStyleClass().add("button-enabled");
        }
    }

}
