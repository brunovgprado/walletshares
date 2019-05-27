package com.prado.walletshares.Domain.Entities;

import java.util.Date;

public class StockHolding {
    private long id;
    private String shareSymbol;
    private Double pricePerShare;
    private int amountShares;
    private Date purchaseDate;
    private Double OperationRate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShareSymbol() {
        return shareSymbol;
    }

    public void setShareSymbol(String shareSymbol) {
        this.shareSymbol = shareSymbol;
    }

    public Double getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(Double pricePerShare) {
        this.pricePerShare = pricePerShare;
    }

    public int getAmountShares() {
        return amountShares;
    }

    public void setAmountShares(int amountShares) {
        this.amountShares = amountShares;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getAmountValue(){
        return pricePerShare * amountShares;
    }

    public Double getOperationRate() {
        return OperationRate;
    }

    public void setOperationRate(Double operationRate) {
        OperationRate = operationRate;
    }


}
