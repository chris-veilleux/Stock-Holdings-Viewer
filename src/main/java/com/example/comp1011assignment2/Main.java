package com.example.comp1011assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("holdings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("All Holdings");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // On program start, call the API to get the latest data - data is written to jsonData.json in the root of the project
        try {
            APIUtility.getHoldingsFromSSS();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        launch();
    }
}