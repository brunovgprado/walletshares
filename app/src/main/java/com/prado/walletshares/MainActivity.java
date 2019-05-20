package com.prado.walletshares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.prado.walletshares.Presentation.PurchaseTransactionActivity;
import com.prado.walletshares.Presentation.SaleTransactionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPurchaseActivity(View view){
        Intent purchaseActivity = new Intent(this, PurchaseTransactionActivity.class);
        startActivity(purchaseActivity);
    }

    public void startSaleActivity(View view){
        Intent saleActivity = new Intent(this, SaleTransactionActivity.class);
        startActivity(saleActivity);
    }

}
