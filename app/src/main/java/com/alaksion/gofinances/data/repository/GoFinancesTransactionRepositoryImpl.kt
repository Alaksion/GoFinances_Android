package com.alaksion.gofinances.data.repository

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.local.GoFinancesLocalDataSourceImpl
import com.alaksion.gofinances.data.model.TransactionData
import com.alaksion.gofinances.domain.repository.GoFinancesTransactionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class GoFinancesTransactionRepositoryImpl(
    private val localDataSource: GoFinancesLocalDataSourceImpl
) : GoFinancesTransactionRepository, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun get() : List<TransactionData> {
        return localDataSource.get()
    }

    override fun create(transactionData: TransactionData) {
        localDataSource.create(transactionData)
    }
}