module com.forepaw.clinic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.forepaw.clinic to javafx.fxml;
    opens com.forepaw.clinic.controllers.fxcontrollers to javafx.fxml ;
    opens com.forepaw.clinic.models to javafx.fxml;
    opens com.forepaw.clinic.controllers.dbcontrollers to javafx.fxml;
    exports com.forepaw.clinic;
}