module com.example.projectui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectui to javafx.fxml;
    exports com.example.projectui;
}