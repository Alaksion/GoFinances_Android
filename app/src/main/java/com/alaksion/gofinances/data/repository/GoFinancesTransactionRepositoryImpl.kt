package com.alaksion.gofinances.data.repository

import com.alaksion.gofinances.data.local.GoFinancesLocalDataSourceImpl
import com.alaksion.gofinances.data.model.TransactionData
import com.alaksion.gofinances.domain.repository.GoFinancesTransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class GoFinancesTransactionRepositoryImpl(
    private val localDataSource: GoFinancesLocalDataSourceImpl
) : GoFinancesTransactionRepository {


    override suspend fun get() = runBlocking {
        localDataSource.get()
    }

    override suspend fun create(transactionData: TransactionData) {
        CoroutineScope(IO).launch {
            localDataSource.create(transactionData)
        }
    }
}