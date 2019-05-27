package com.prado.walletshares.Application;

import com.prado.walletshares.Domain.Entities.StockHolding;
import java.util.List;

public interface IPurchaseTransactionAppService {
    void saveTransaction(StockHolding stockHolding);
    List<StockHolding> getTransactions();
    StockHolding getTransactionById(long id);
    void deleteTransaction(long id);
}
