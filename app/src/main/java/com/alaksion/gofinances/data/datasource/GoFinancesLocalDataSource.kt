package com.alaksion.gofinances.data.datasource

import androidx.lifecycle.LiveData
import com.alaksion.gofinances.data.model.TransactionData

interface GoFinancesLocalDataSource {

    fun get(): List<TransactionData>

    fun create(transactionData: TransactionData)
}