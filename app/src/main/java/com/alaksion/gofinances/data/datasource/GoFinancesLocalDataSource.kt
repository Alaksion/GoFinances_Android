package com.alaksion.gofinances.data.datasource

import com.alaksion.gofinances.data.model.TransactionData

interface GoFinancesLocalDataSource {

    suspend fun get(): List<TransactionData>

    suspend fun create(transactionData: TransactionData)

    suspend fun delete(transactionData: TransactionData)
}