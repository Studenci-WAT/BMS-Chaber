package pl.edu.wat.mspw_frontend.enums;

public enum Views {
    INPUTTEMPLATEVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-template-view.fxml"),
    INPUTAMOVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-amo-view.fxml"),
    INPUTSYSOGNVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-sys-ogn-view.fxml"),
    INPUTSPWVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-spw-view.fxml"),
    INPUTMPSVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-mps-view.fxml"),
    READTABLES("/pl/edu/wat/mspw_projekt/readviews/table-read-view.fxml"),
    MPSTABVIEW("/pl/edu/wat/mspw_projekt/readviews/table-mps-view.fxml"),
    AMOTABVIEW("/pl/edu/wat/mspw_projekt/readviews/table-amo-view.fxml"),
    SPWTABVIEW("/pl/edu/wat/mspw_projekt/readviews/table-spw-view.fxml");
    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
