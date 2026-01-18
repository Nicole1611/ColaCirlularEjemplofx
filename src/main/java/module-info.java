module com.mycompany.colacircularefx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.colacircularefx.controller to javafx.fxml;
    exports com.mycompany.colacircularefx;
    exports com.mycompany.colacircularefx.model;
    exports com.mycompany.colacircularefx.controller;
    exports com.mycompany.colacircularefx.view;
}
