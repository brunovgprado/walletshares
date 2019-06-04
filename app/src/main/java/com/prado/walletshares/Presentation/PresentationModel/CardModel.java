package com.prado.walletshares.Presentation.PresentationModel;

public class CardModel {
    private long ObjectId;
    private String title;
    private String subtitle;
    private String subtitle2;
    private int amount;
    private double value;
    private double unityValue;
    private double amountValue;

    public CardModel(long objectId, String title, String subtitle, String subtitle2, double unityValue, double value, int amount, double amountValue) {
        this(objectId, title, unityValue, value, amount, amountValue);

        this.setSubtitle(subtitle);
        this.setSubtitle2(subtitle2);
    }

    public CardModel(long objectId, String title, double unityValue, double value, int amount, double amountValue) {
        this.setObjectId(objectId);
        this.setTitle(title);
        this.setUnityValue(unityValue);
        this.setValue(value);
        this.setAmount(amount);
        this.setAmountValue(amountValue);
    }

    public long getObjectId() {
        return ObjectId;
    }

    public void setObjectId(long objectId) {
        ObjectId = objectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public double getUnityValue() {
        return unityValue;
    }

    public void setUnityValue(double unityValue) {
        this.unityValue = unityValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(double amountValue) {
        this.amountValue = amountValue;
    }
}
