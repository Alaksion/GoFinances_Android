package com.alaksion.gofinances.data.datasource

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.model.TransactionData

interface GoFinancesLocalDataSource {

    fun get(): LiveData<List<TransactionData>>

    suspend fun create(transactionData: TransactionData)
}