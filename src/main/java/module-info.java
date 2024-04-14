module com.example.emis {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires com.jfoenix;
    requires com.gluonhq.maps;
    requires MaterialFX;


    opens com.example.emis to javafx.fxml;
    exports com.example.emis;
    exports com.example.emis.Controllers;
    opens com.example.emis.Controllers to javafx.fxml;
}