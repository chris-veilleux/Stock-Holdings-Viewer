package com.example.comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    /**
     * Switches the view shown to the user to the details view
     * @param event
     * @param fxmlFile
     * @param holdingId
     * @throws IOException
     */
    public static void switchToDetailsView(ActionEvent event, String fxmlFile, int holdingId) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());


        DetailsViewController controller = fxmlLoader.getController();
        controller.getHoldingDetails(holdingId);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle("Details");

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches the view shown to the user to the holdings view
     * @param event
     * @param fxmlFile
     * @throws IOException
     */
    public static void switchToHoldingsView(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle("All Holdings");

        stage.setScene(scene);
        stage.show();
    }
}