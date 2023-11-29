module pl.edu.wat.mspw_projekt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.persistence;
    requires jakarta.persistence;
    requires lombok;

    opens pl.edu.wat.mspw_projekt to javafx.fxml;
    exports pl.edu.wat.mspw_projekt;
}