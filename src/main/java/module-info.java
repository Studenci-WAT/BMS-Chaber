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
    requires org.hibernate.orm.core;

    opens pl.edu.wat.mspw_projekt to javafx.fxml, org.hibernate.orm.core;
    opens pl.edu.wat.mspw_projekt.model to org.hibernate.orm.core;
    exports pl.edu.wat.mspw_projekt;
    exports pl.edu.wat.mspw_projekt.inputcontrollers;
    opens pl.edu.wat.mspw_projekt.inputcontrollers to javafx.fxml;
    exports pl.edu.wat.mspw_projekt.util;
    opens pl.edu.wat.mspw_projekt.util to javafx.fxml, org.hibernate.orm.core;
}