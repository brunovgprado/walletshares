package com.prado.walletshares.Application;

import com.prado.walletshares.Domain.Entities.StockHolding;
import com.prado.walletshares.Domain.Interfaces.IStockHoldingRepository;

import java.util.List;

public class PurchaseTransactionAppService implements IPurchaseTransactionAppService {
    private IStockHoldingRepository _repository;

    public PurchaseTransactionAppService(IStockHoldingRepository repository){
        _repository = repository;
    };

    @Override
    public void saveTransaction(StockHolding stockHolding) {
        _repository.save(stockHolding);
    }

    @Override
    public List<StockHolding> getTransactions() {
        return _repository.get();
    }

    @Override
    public StockHolding getTransactionById(long id) {
        return _repository.getById(id);
    }

    @Override
    public void deleteTransaction(long id) {
        _repository.delete(id);
    }
}
