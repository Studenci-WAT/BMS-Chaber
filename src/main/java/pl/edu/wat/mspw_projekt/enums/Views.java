package pl.edu.wat.mspw_projekt.enums;

public enum Views {
    AMMOFORMVIEW("input-amo-view.fxml"),
    INPUTTEMPLATEVIEW("input-template-view.fxml");


    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
