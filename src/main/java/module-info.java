module com.mrisa.maplenudesk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.mrisa.maplenudesk to javafx.fxml;
    exports com.mrisa.maplenudesk;
}