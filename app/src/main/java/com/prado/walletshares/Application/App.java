package com.prado.walletshares.Application;

import android.app.Application;

import com.prado.walletshares.Presentation.PresentationModel.CardModel;

public class App extends Application {
    CardModel crdDetail;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public CardModel getCrdDetail() {
        return crdDetail;
    }

    public void setCrdDetail(CardModel crdDetail) {
        this.crdDetail = crdDetail;
    }
}
