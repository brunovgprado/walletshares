package com.prado.walletshares.Application;

import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Domain.Interfaces.ICalculator;

import java.util.List;

public class CalculatesEquity implements ICalculator {
    public double calculates(List<StockHolding> stockHoldingList){
        return stockHoldingList.stream().mapToDouble(s -> s.getAmountValue()).sum();
    }
}
