module com.example.comp1008guiassignment3_200465333 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1008guiassignment3_200465333 to javafx.fxml;
    exports com.example.comp1008guiassignment3_200465333;
}