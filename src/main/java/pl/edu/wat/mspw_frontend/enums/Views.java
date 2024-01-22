package pl.edu.wat.mspw_frontend.enums;

public enum Views {
    INPUTAMOVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-amo-view.fxml"),
    INPUTBLANKVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-blank-view.fxml"),
    INPUTSYSOGNVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-sys-ogn-view.fxml"),
    INPUTSPWVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-spw-view.fxml"),
    INPUTMPSVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-mps-view.fxml"),
    INPUTKATEGORIAAMOVIEW("/pl/edu/wat/mspw_projekt/inputviews/input-kategoria-amo-view.fxml"),
    READTABLES("/pl/edu/wat/mspw_projekt/readviews/table-read-view.fxml"),
    INPUTEFEKTORLACZN("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-laczn-view.fxml"),
    INPUTEFEKTORJEZDN("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-jezdn-view.fxml"),
    INPUTEFEKTORPLYWANIA("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-plywania-view.fxml"),
    INPUTEFEKTORINZ("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-inz-view.fxml"),
    INPUTEFEKTORWE("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-we-view.fxml"),
    INPUTKAKLUB("/pl/edu/wat/mspw_projekt/inputviews/input-kadlub-view.fxml"),
    INPUTEFEKTORTRANSP("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-transp-view.fxml"),
    INPUTKATEGORY("/pl/edu/wat/mspw_projekt/inputviews/input-kategory-view.fxml"),
    INPUTEFEKTORLATANIA("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-latania-view.fxml"),
    INPUTROZPOZ("/pl/edu/wat/mspw_projekt/inputviews/input-rozpoz-view.fxml"),
    INPUTRODZAJGLOWICYBOJ("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-glowicy-boj-view.fxml"),
    INPUTRODZAJGLOWICYNAPROW("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-glowicy-naprow-view.fxml"),
    INPUTRODZAJNAPROW("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-naprow-view.fxml"),
    INPUTRODZAJSYSTEMUOGN("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-systemu-ogn-view.fxml");

    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
