package com.prado.walletshares.Presentation.PresentationModel;

public class CardModel {
    private int ObjectId;
    private String title;
    private String subtitle;
    private double value;


    public int getObjectId() {
        return ObjectId;
    }

    public void setObjectId(int objectId) {
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
}
