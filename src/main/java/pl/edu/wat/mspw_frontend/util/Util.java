package pl.edu.wat.mspw_frontend.util;

import pl.edu.wat.mspw_frontend.readcontrollers.AbstractTableController;

public class Util {

    public static void refreshData(AbstractTableController tabControl){

        if (tabControl != null) tabControl.populateTable();
    }
}
