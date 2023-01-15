package com.example.comp1011assignment2;

import com.google.gson.annotations.SerializedName;

public class Holding {
    @SerializedName("holdingId")
    private int holdingId;
    @SerializedName("ticker")
    private String ticker;
    @SerializedName("tradeDate")
    private String tradeDate;
    @SerializedName("tradeType")
    private String tradeType;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("price")
    private double price;

    /**
     * Constructor for Holding objects, using set methods
     * @param holdingId
     * @param ticker
     * @param tradeDate
     * @param tradeType
     * @param quantity
     * @param price
     */
    public Holding(int holdingId, String ticker, String tradeDate, String tradeType, int quantity, double price) {
        setHoldingId(holdingId);
        setTicker(ticker);
        setTradeDate(tradeDate);
        setTradeType(tradeType);
        setQuantity(quantity);
        setPrice(price);
    }

    /**
     * Returns the holding id of a Holding
     * @return
     */
    public int getHoldingId() {
        return holdingId;
    }

    /**
     * Set holding id of a Holding if it is greater than 0, otherwise, throw an exception
     * @param holdingId
     */
    public void setHoldingId(int holdingId) {
        if (holdingId > 0)
            this.holdingId = holdingId;
        else
            throw new IllegalArgumentException("HoldingId must be greater than 0.");
    }

    /**
     * Returns the ticker symbol for a Holding
     * @return
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Set ticker symbol of a Holding if it is greater than 0 and less than 6, otherwise, throw an exception
     * @param ticker
     */
    public void setTicker(String ticker) {
        if (ticker.length() > 0 && ticker.length() <= 5)
            this.ticker = ticker;
        else
            throw new IllegalArgumentException("Stock ticker is required and must not exceed 5 characters.");
    }

    /**
     * Returns the trade date of a Holding
     * @return
     */
    public String getTradeDate() {
        return tradeDate;
    }

    /**
     * Set the trade date of a Holding if it is in 1792 or later, otherwise, throw an exception
     * @param tradeDate
     */
    public void setTradeDate(String tradeDate) {
        if (Integer.parseInt(tradeDate.substring(0,4)) >= 1792)
            this.tradeDate = tradeDate;
        else
            throw new IllegalArgumentException("Trade date must not have occurred before 1792.");
    }

    /**
     * Returns the type of trade for a Holding (Buy / Sell)
     * @return
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * Set the trade type of a Holding if it is either Buy or Sell, otherwise, throw an exception
     * @param tradeType
     */
    public void setTradeType(String tradeType) {
        if (tradeType.toUpperCase().equals("BUY") || tradeType.toUpperCase().equals("SELL"))
            this.tradeType = tradeType;
        else
            throw new IllegalArgumentException("Trade type must be either Buy or Sell.");
    }

    /**
     * Returns the quantity for a Holding
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of a Holding transaction if it is greater than 0, otherwise, throw an exception
     * @param quantity
     */
    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
        else
            throw new IllegalArgumentException("Quantity must be greater than 0.");
    }

    /**
     * Returns the purchase price of a holding
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the purchase price of a holding if it is in the range 0-1,000,000, otherwise, throw an exception
     * @param price
     */
    public void setPrice(double price) {
        if (price >= 0 && price <= 1000000)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must not exceed $1,000,000 per share.");
    }
}
