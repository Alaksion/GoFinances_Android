package com.alaksion.gofinances.data.local

import com.alaksion.gofinances.data.datasource.GoFinancesLocalDataSource
import com.alaksion.gofinances.data.model.TransactionData

class GoFinancesLocalDataSourceImpl(
    private val db : GoFinanceDatabase
) : GoFinancesLocalDataSource {

    override suspend fun get(): List<TransactionData> {
        return db.transactionDao().get()
    }

    override suspend fun create(transactionData: TransactionData) {
        db.transactionDao().create(transactionData)
    }

    override suspend fun delete(transactionData: TransactionData) {
        db.transactionDao().delete(transactionData)
    }
}