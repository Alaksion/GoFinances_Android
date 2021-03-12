package com.alaksion.gofinances.data.local

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.datasource.GoFinancesLocalDataSource
import com.alaksion.gofinances.data.model.TransactionData
import com.alaksion.gofinances.shared.database.GoFinanceDatabase

class GoFinancesLocalDataSourceImpl(
    private val db : GoFinanceDatabase
) : GoFinancesLocalDataSource {

    override fun get(): List<TransactionData> {
        return db.transactionDao().get()
    }

    override fun create(transactionData: TransactionData) {
        db.transactionDao().create(transactionData)
    }
}