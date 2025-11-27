package com.mbl.harmonytrainer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuitarNoteTrainer extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuitarNoteTrainer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 200, 300);
        stage.setTitle("Guitar Note Trainer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}