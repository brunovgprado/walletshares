package com.prado.walletshares.Domain.Interfaces;

import com.prado.walletshares.Domain.Entities.StockHolding;

import java.util.List;

public interface IStockHoldingRepository {
    void save(StockHolding stockHolding);
    List<StockHolding> get();
    StockHolding getById(long id);
    void delete(long id);
}
