package com.example.comp1008guiassignment3_200465333;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("teacher_seating_chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 840);
        stage.setTitle("Teacher Seating Chart");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}