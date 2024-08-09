module com.example.recipemanagmentsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.recipemanagmentsystem to javafx.fxml;
    exports com.example.recipemanagmentsystem;
}