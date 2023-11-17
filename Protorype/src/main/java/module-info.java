module ws23.protorype {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens ws23.protorype to javafx.fxml;
    exports ws23.protorype;
    exports ws23.protorype.Model;
    opens ws23.protorype.Model to javafx.fxml;
}