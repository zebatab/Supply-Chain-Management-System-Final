module com.example.supplychainzeba17dec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainzeba17dec to javafx.fxml;
    exports com.example.supplychainzeba17dec;
}