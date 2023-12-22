module com.mycompany.mavenproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.mavenproject to javafx.fxml;
    exports com.mycompany.mavenproject;
}
