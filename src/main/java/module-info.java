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
    requires java.naming;

    opens pl.edu.wat.mspw_projekt to javafx.fxml, org.hibernate.orm.core;
    exports pl.edu.wat.mspw_frontend.inputcontrollers;
    opens pl.edu.wat.mspw_frontend.inputcontrollers to javafx.fxml;
    exports pl.edu.wat.mspw_backend.util;
    opens pl.edu.wat.mspw_backend.util to javafx.fxml, org.hibernate.orm.core;
    exports pl.edu.wat.mspw_backend.model;
    opens pl.edu.wat.mspw_backend.model to javafx.fxml, org.hibernate.orm.core;
    exports pl.edu.wat.mspw_frontend;
    opens pl.edu.wat.mspw_frontend to javafx.fxml, org.hibernate.orm.core;
    exports pl.edu.wat;
    opens pl.edu.wat to javafx.fxml, org.hibernate.orm.core;
}