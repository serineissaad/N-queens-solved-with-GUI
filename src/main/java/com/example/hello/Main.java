package com.example.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("session.fxml"))));
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("demo.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setHeight(675);
        primaryStage.setWidth(753);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}