package com.prado.walletshares.Infra;

import android.content.Context;
import android.view.View;

import com.orhanobut.hawk.Hawk;
import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Domain.Interfaces.IStockHoldingRepository;

import java.util.ArrayList;
import java.util.List;

public class StockHoldingRepository implements IStockHoldingRepository{
    public StockHoldingRepository(){
        //Hawk.init().build();
    }

    public void save(StockHolding stockHolding){};
    public List<StockHolding> get(){
        return new ArrayList<StockHolding>();
    };
    public StockHolding getById(long id){
        return new StockHolding();
    };
    public void delete(long id){};
}
