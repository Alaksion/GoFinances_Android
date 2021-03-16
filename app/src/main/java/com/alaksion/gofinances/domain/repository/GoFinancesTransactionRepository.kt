package com.alaksion.gofinances.domain.repository

import com.alaksion.gofinances.data.model.TransactionData

interface GoFinancesTransactionRepository {

    suspend fun get(): List<TransactionData>

    suspend fun create(transactionData: TransactionData)

    suspend fun delete(transactionData: TransactionData)
}