package com.example.comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.List;

public class DetailsViewController {

    @FXML
    private Button backButton;

    @FXML
    private GridPane detailsGridPane;

    @FXML
    private Label detailsLabel;

    @FXML
    private Label detailsPriceLabel;

    @FXML
    private Label detailsQuantityLabel;

    @FXML
    private Label detailsTickerLabel;

    @FXML
    private Label detailsTradeDateLabel;

    @FXML
    private Label detailsTradeTypeLabel;

    /**
     * Method updates labels on the details view according to the holding selected on the holdings view scene
     * @param HoldingId
     */
    public void getHoldingDetails(int HoldingId) {
        // read the holdings from the json file in the root of the project, save to a List object
        List<Holding> allHoldings = APIUtility.getHoldingsFromJsonFile();

        Holding currentHolding = null;

        // search for the holding with an id that matches the HoldingId param, and set currentHolding equal to it
        for (int i = 0; i < allHoldings.size(); i++) {
            currentHolding = allHoldings.get(i);
            if (currentHolding.getHoldingId() == HoldingId) {
                break;
            }
        }

        // update labels accordingly
        detailsTickerLabel.setText(currentHolding.getTicker());
        detailsTradeDateLabel.setText(currentHolding.getTradeDate());
        detailsTradeTypeLabel.setText(currentHolding.getTradeType());
        detailsQuantityLabel.setText(Integer.toString(currentHolding.getQuantity()));
        detailsPriceLabel.setText("$" + Double.toString(currentHolding.getPrice()));
    }

    /**
     * Method to call the switchToHoldingsView method in the SceneSwitcher class, passing in the view to switch to, the holdings view
     * @param event
     * @throws IOException
     */
    public void returnToHoldingsView(ActionEvent event) throws IOException {
        SceneSwitcher.switchToHoldingsView(event, "holdings-view.fxml");
    }
}
