package com.alaksion.gofinances.data.repository

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.local.GoFinancesLocalDataSourceImpl
import com.alaksion.gofinances.data.model.TransactionData
import com.alaksion.gofinances.domain.repository.GoFinancesTransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GoFinancesTransactionRepositoryImpl(
    private val localDataSource: GoFinancesLocalDataSourceImpl
) : GoFinancesTransactionRepository {

    override fun get(): LiveData<List<TransactionData>> {
        return localDataSource.get()
    }

    override suspend fun create(transactionData: TransactionData) {
        localDataSource.create(transactionData)
    }
}