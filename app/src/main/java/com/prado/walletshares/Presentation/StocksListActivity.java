package com.prado.walletshares.Presentation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.prado.walletshares.Application.App;
import com.prado.walletshares.Application.IPurchaseTransactionAppService;
import com.prado.walletshares.Application.PurchaseTransactionAppService;
import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Helper.GetCard;
import com.prado.walletshares.Helper.RVAdapter;
import com.prado.walletshares.Infra.StockHoldingRepository;
import com.prado.walletshares.Presentation.PresentationModel.CardModel;
import com.prado.walletshares.R;

import java.util.ArrayList;
import java.util.List;

public class StocksListActivity extends AppCompatActivity {
    IPurchaseTransactionAppService service;
    RecyclerView rv;
    List<CardModel> cardModels;
    LinearLayoutManager llm;
    RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stocks_list);
        rv = (RecyclerView)findViewById(R.id.rv);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        service = new PurchaseTransactionAppService(StockHoldingRepository.getInstance(this));
        this.loadStocks();
    }

    private void loadStocks(){
        if(service.getTransactions() == null) {
            showToastMessage("Empty list");
        }else if(service.getTransactions().size() > 0){
            cardModels = new ArrayList<CardModel>();
            service.getTransactions().forEach(tr -> {
                cardModels.add(setDataToCardModel(tr));
            });
            setItensToAdapter(cardModels);
        }
    }

    private CardModel setDataToCardModel(StockHolding stock){
        return new CardModel(
                stock.getId(),
                stock.getShareSymbol(),
                stock.getPricePerShare(),
                stock.getPricePerShare(),
                stock.getAmountShares(),
                stock.getAmountValue());
    }

    private void setItensToAdapter(List<CardModel> Cards){
        try{
            adapter = new RVAdapter(Cards, getGetIdCard());
            rv.setAdapter(adapter);
        }catch (Exception e){
            String msg = e.getMessage();
        }
    }

    @NonNull
    private GetCard getGetIdCard() {
        return cardModel -> openDetailsActivity(cardModel);
    }

    private void openDetailsActivity(CardModel cardModel){
        App app = (App) getApplicationContext();
        app.setCrdDetail(cardModel);

        Intent detailsActivity = new Intent(this, DetailsActivity.class);
        startActivity(detailsActivity);
    }

    private void showToastMessage(String msg) {
        showToastMessage( msg, Toast.LENGTH_SHORT);
    }

    private void showToastMessage(String msg, int length) {
        Toast.makeText(this, msg, length).show();
    }
}
