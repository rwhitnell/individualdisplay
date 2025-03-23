module edu.guilford {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.base;

    opens edu.guilford to javafx.fxml;
    exports edu.guilford;
}
