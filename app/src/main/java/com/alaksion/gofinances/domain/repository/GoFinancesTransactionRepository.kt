package com.alaksion.gofinances.domain.repository

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.model.TransactionData

interface GoFinancesTransactionRepository {

    fun get(): List<TransactionData>

    fun create(transactionData: TransactionData)
}