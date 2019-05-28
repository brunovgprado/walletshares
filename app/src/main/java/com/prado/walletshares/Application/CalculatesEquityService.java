package com.prado.walletshares.Application;

import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Domain.Interfaces.ICalculator;

import java.util.List;

public class CalculatesEquityService implements ICalculator {
    public double calculates(List<StockHolding> stockHoldingList) {
        if (stockHoldingList != null) {
            if (stockHoldingList.size() > 0) {
                return stockHoldingList.stream().mapToDouble(s -> s.getAmountValue()).sum();
            }
        }
        return 0.00;
    }
}

