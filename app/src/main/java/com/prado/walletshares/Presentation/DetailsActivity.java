package com.prado.walletshares.Presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.prado.walletshares.Application.App;
import com.prado.walletshares.Presentation.PresentationModel.CardModel;
import com.prado.walletshares.R;

public class DetailsActivity extends AppCompatActivity {
    CardModel cardModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        App app = (App) getApplicationContext();
        cardModel = app.getCrdDetail();

        if(cardModel != null){
            setDataToViewDetails(cardModel);
        }
    }

    private void setDataToViewDetails(CardModel cardModel) {
        TextView title = (TextView)findViewById(R.id.text_title_details);
        title.setText("Teste");
    }
}
