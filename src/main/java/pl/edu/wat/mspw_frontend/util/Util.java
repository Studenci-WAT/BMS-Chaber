package pl.edu.wat.mspw_frontend.util;

import javafx.scene.control.ChoiceBox;
import pl.edu.wat.mspw_frontend.interfaces.Item;
import pl.edu.wat.mspw_frontend.readcontrollers.AbstractTableController;

public class Util {

    public static void refreshData(AbstractTableController tabControl){

        if (tabControl != null) tabControl.populateTable();
    }
    public static Integer getSelectedItemId(ChoiceBox<Item> choiceBox) {
        return choiceBox.getValue() != null ? choiceBox.getValue().getId() : null;
    }

}
