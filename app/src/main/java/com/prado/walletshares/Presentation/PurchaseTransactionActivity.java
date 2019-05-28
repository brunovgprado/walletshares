package com.prado.walletshares.Presentation;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prado.walletshares.Application.IPurchaseTransactionAppService;
import com.prado.walletshares.Application.PurchaseTransactionAppService;
import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Infra.StockHoldingRepository;
import com.prado.walletshares.R;

import java.util.List;

public class PurchaseTransactionActivity extends AppCompatActivity {
    TextInputEditText inputSymbol;
    TextInputEditText pricePerShare;
    TextInputEditText amountShares;
    TextInputEditText operationRate;
    StockHolding stock;
    IPurchaseTransactionAppService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_transaction);
        service = new PurchaseTransactionAppService(new StockHoldingRepository(this));
    }

    public void savePurchaseOperation(View view){
        if(isInvalidForm()){
            this.showToastMessage("A mandatory field is empty");
        }else{
            if(loadValuesFromFieldToObject()){
                service.saveTransaction(stock);
                this.clearFields();
                this.showToastMessage("Transaction Saved!");
            }
        }
    }

    public void clearFields(){
        this.loadFields();

        this.inputSymbol.setText("");
        this.pricePerShare.setText("");
        this.amountShares.setText("");
        this.operationRate.setText("");
    }

    private void loadFields(){
        inputSymbol = (TextInputEditText)findViewById(R.id.txt_symbol);
        pricePerShare = (TextInputEditText)findViewById(R.id.txt_price_per_share);
        amountShares = (TextInputEditText)findViewById(R.id.txt_amount_shares);
        operationRate = (TextInputEditText)findViewById(R.id.txt_operation_rate);
    }

    private boolean loadValuesFromFieldToObject(){
        this.loadFields();

        try{
            String symbol = inputSymbol.getText().toString();
            double price = Double.parseDouble(pricePerShare.getText().toString());
            int amount = Integer.parseInt(amountShares.getText().toString());
            String rateField = operationRate.getText().toString();
            double rate = Double.parseDouble(rateField.isEmpty() ? "0" : rateField);

            stock = new StockHolding();
            stock.setShareSymbol(symbol);
            stock.setPricePerShare(price);
            stock.setAmountShares(amount);
            stock.setOperationRate(rate);

            return true;
        }catch (Exception ex){
            this.showToastMessage("An error was occurred!");
            return false;
        }
    }

    private boolean isInvalidForm(){
        this.loadFields();

        return (this.inputSymbol.getText().toString()).isEmpty()
        || (this.pricePerShare.getText().toString()).isEmpty()
        || (this.amountShares.getText().toString()).isEmpty();
    }

    private void showToastMessage(String msg) {
        showToastMessage( msg, Toast.LENGTH_SHORT);
    }

    private void showToastMessage(String msg, int length) {
        Toast.makeText(this, msg, length).show();
    }
}
