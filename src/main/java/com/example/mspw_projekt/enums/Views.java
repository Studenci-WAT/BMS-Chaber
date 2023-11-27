package com.example.mspw_projekt.enums;

public enum Views {
    HOMEVIEW("home-view.fxml"),
    AMMOFORMVIEW("input-amo-view.fxml"),
    FIRESYSFORMVIEW("input-fire-sys-view.fxml");


    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
