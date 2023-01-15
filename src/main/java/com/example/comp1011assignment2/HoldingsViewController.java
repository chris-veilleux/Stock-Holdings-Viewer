package com.example.comp1011assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HoldingsViewController implements Initializable {

    @FXML
    private Button detailsButton;

    @FXML
    private Button filterButton;

    @FXML
    private Label holdingsLabel;

    @FXML
    private Label tickerLabel;

    @FXML
    private TableView<Holding> holdngsTableView;

    @FXML
    private TableColumn<Holding, Double> priceColumn;

    @FXML
    private TableColumn<Holding, Integer> quantityColumn;

    @FXML
    private TableColumn<Holding, String> tickerColumn;

    @FXML
    private TableColumn<Holding, String> typeColumn;


    @FXML
    private TextField tickerSearchTextField;

    /**
     * Overridden initialize method sets the visibility of the details button and populate the table view on program start
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detailsButton.setVisible(false);

        holdngsTableView.getSelectionModel().selectedItemProperty().addListener((obs, old, holdingChosen)->
        {
            if (holdingChosen != null) {
                detailsButton.setVisible(true);
            }
            else {
                detailsButton.setVisible(false);
            }
        });



        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tickerColumn.setCellValueFactory(new PropertyValueFactory<>("ticker"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("tradeType"));
        holdngsTableView.getItems().addAll(APIUtility.getHoldingsFromJsonFile());
    }

    /**
     * Calls the method to switch to the details view, passing in the holding that is currently selected
     * @param event
     * @throws IOException
     */
    @FXML
    private void getHoldingDetails(ActionEvent event) throws IOException {
        Holding holding = holdngsTableView.getSelectionModel().getSelectedItem();
        SceneSwitcher.switchToDetailsView(event, "details-view.fxml", holding.getHoldingId());
    }

    /**
     * Filters the results shown in the table view according to the user's search parameter
     * @param event
     */
    @FXML
    private void filterResults(ActionEvent event) {
        holdngsTableView.getItems().clear();

        String searchTicker = tickerSearchTextField.getText();

        List<Holding> filteredHoldings = new ArrayList<Holding>();

        List<Holding> allHoldings = APIUtility.getHoldingsFromJsonFile();

        for (Holding holding : allHoldings) {
            if ((holding.getTicker()).toUpperCase().contains(searchTicker.toUpperCase())) {
                filteredHoldings.add(holding);
            }
        }

        holdngsTableView.getItems().addAll(filteredHoldings);
    }
}