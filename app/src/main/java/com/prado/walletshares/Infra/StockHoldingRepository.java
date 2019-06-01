package com.prado.walletshares.Infra;

import android.support.v7.app.AppCompatActivity;

import com.orhanobut.hawk.Hawk;
import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Domain.Interfaces.IStockHoldingRepository;

import java.util.ArrayList;
import java.util.List;

public class StockHoldingRepository implements IStockHoldingRepository{
    private static final String KEY = "StockHoldings";

    public StockHoldingRepository(AppCompatActivity appCompatActivity){
        Hawk.init(appCompatActivity).build();
    }

    public void save(StockHolding stockHolding){
        List<StockHolding> stockHoldingList;

        if(Hawk.contains(KEY)){
            stockHoldingList = get();
            stockHolding.setId(getNextId(stockHoldingList));
            stockHoldingList.add(stockHolding);
        }else{
            stockHoldingList = new ArrayList<StockHolding>();
            stockHoldingList.add(stockHolding);
        }
        Hawk.put(KEY, stockHoldingList);
    }

    public List<StockHolding> get(){
        ArrayList<StockHolding> stockHoldingList = Hawk.get(KEY);
        return stockHoldingList;
    }

    public StockHolding getById(long id){
        StockHolding stockHolding;

        if(Hawk.contains(KEY)){
            List<StockHolding>  stockHoldingList = get();
            stockHolding = stockHoldingList.stream().filter(s -> s.getId() == id)
                    .findAny().orElse(null);
        }else{
            stockHolding = new StockHolding();
        }
        return stockHolding;
    }

    public void delete(long id){
        StockHolding stockHolding;

        if(Hawk.contains(KEY)){
            List<StockHolding>  stockHoldingList = get();
            stockHolding = stockHoldingList.stream().filter(s -> s.getId() == id)
                    .findAny().orElse(null);

            stockHoldingList.remove(stockHolding);
            Hawk.put(KEY, stockHoldingList);
        }else{
            stockHolding = new StockHolding();
        }
    }

    private long getNextId(List<StockHolding> stockHoldings){
        return SequenceGenerator.nextValue(stockHoldings.stream()
                .mapToLong(StockHolding::getId).max().getAsLong());
    }
}
