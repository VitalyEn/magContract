module com.contract {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires java.desktop;

    opens com.contract to javafx.fxml;
    exports com.contract;
}