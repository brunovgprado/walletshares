package com.prado.walletshares.Domain.Interfaces;

import com.prado.walletshares.Domain.Entities.StockHolding;

import java.util.List;

public interface ICalculator {
     double calculates(List<StockHolding> stockHoldingList);
}
