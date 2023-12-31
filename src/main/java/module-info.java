module com.example.integration_project_oop2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    exports com.example.integration_project_oop2;
    opens com.example.integration_project_oop2 to javafx.fxml;
    exports com.example.integration_project_oop2.Controllers;
    opens com.example.integration_project_oop2.Controllers to javafx.fxml;
    exports com.example.integration_project_oop2.Classes;
    opens com.example.integration_project_oop2.Classes to javafx.fxml;
    exports com.example.integration_project_oop2.Lists;
    opens com.example.integration_project_oop2.Lists to javafx.fxml;
}