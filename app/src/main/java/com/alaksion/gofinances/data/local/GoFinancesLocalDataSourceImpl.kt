package com.alaksion.gofinances.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alaksion.gofinances.data.datasource.GoFinancesLocalDataSource
import com.alaksion.gofinances.data.model.TransactionData
import com.alaksion.gofinances.shared.database.GoFinanceDatabase
import kotlinx.coroutines.flow.Flow

class GoFinancesLocalDataSourceImpl(
    private val db : GoFinanceDatabase
) : GoFinancesLocalDataSource {

    override fun get(): LiveData<List<TransactionData>> {
        return db.transactionDao().get()
    }

    override suspend fun create(transactionData: TransactionData) {
        db.transactionDao().create(transactionData)
    }
}