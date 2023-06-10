module com.example.tris_socket {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tris_socket to javafx.fxml;
    exports com.example.tris_socket;
}