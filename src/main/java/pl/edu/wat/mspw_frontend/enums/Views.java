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
    INPUTKADLUB("/pl/edu/wat/mspw_projekt/inputviews/input-kadlub-view.fxml"),
    INPUTEFEKTORTRANSP("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-transp-view.fxml"),
    INPUTKATEGORY("/pl/edu/wat/mspw_projekt/inputviews/input-kategory-view.fxml"),
    INPUTEFEKTORLATANIA("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-latania-view.fxml"),
    INPUTEFEKTORROZPOZ("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-rozpoz-view.fxml"),
    INPUTRODZAJGLOWICYBOJ("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-glowicy-boj-view.fxml"),
    INPUTRODZAJGLOWICYNAPROW("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-glowicy-naprow-view.fxml"),
    INPUTRODZAJNAPROW("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-naprow-view.fxml"),
    INPUTRODZAJSYSTEMUOGN("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-systemu-ogn-view.fxml"),
    INPUTSPWSYSOGN("/pl/edu/wat/mspw_projekt/inputviews/input-spw-sys-ogn-view.fxml"),
    INPUTSTANAMOSPW("/pl/edu/wat/mspw_projekt/inputviews/input-stan-amo-spw-view.fxml"),
    INPUTEFEKTORJEZDNY("/pl/edu/wat/mspw_projekt/inputviews/input-efektor-jezdn-view.fxml"),
    INPUTRODZAJPODWOZIA("/pl/edu/wat/mspw_projekt/inputviews/input-rodzaj-podwozia-view.fxml"),
    INPUTSTANMPSSPW("/pl/edu/wat/mspw_projekt/inputviews/input-stan-mps-spw-view.fxml"),
    INPUTPARAMSTRZELOGBEZP("/pl/edu/wat/mspw_projekt/inputviews/input-param-strzel-og-bezp-view.fxml"),
    INPUTPARAMSTRZELOGPOSR("/pl/edu/wat/mspw_projekt/inputviews/input-param-strzel-og-posr-view.fxml"),
    INPUTPRZEBIJALPANRHA("/pl/edu/wat/mspw_projekt/inputviews/input-przebijal-pan-rha-view.fxml"),
    STREFARAZENIASPW("/pl/edu/wat/mspw_projekt/inputviews/input-strefa-razenia-spw-view.fxml");
    private final String value;

    Views(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
