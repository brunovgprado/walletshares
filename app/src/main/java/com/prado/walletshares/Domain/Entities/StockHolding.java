package com.prado.walletshares.Domain.Entities;

import java.util.Date;

public class StockHolding {
    private long id;
    private String shareSymbol;
    private Double purchasePrice;
    private Double valueAtPurchase;
    private int numShares;
    private Date purchaseDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getValueAtPurchase() {
        return valueAtPurchase;
    }

    public void setValueAtPurchase(Double valueAtPurchase) {
        this.valueAtPurchase = valueAtPurchase;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
