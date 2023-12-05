package pl.edu.wat.mspw_projekt.enums;

public enum Views {
    INPUTTEMPLATEVIEW("inputviews/input-template-view.fxml"),
    INPUTAMOVIEW("inputviews/input-amo-view.fxml"),
    INPUTSYSOGNVIEW("inputviews/input-sys-ogn-view.fxml"),
    INPUTSPWVIEW("inputviews/input-spw-view.fxml"),
    INPUTMPSVIEW("inputviews/input-mps-view.fxml");


    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
