package pl.edu.wat.mspw_frontend.enums;

public enum Views {
    INPUTTEMPLATEVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-template-view.fxml"),
    INPUTAMOVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-amo-view.fxml"),
    INPUTSYSOGNVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-sys-ogn-view.fxml"),
    INPUTSPWVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-spw-view.fxml"),
    INPUTMPSVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-mps-view.fxml");


    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
