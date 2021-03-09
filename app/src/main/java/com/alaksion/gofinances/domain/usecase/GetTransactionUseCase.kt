package com.alaksion.gofinances.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.alaksion.gofinances.data.model.mapToTransaction
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.domain.repository.GoFinancesTransactionRepository

class GetTransactionUseCase(
    private val repository: GoFinancesTransactionRepository
) {

    operator fun invoke(): LiveData<List<Transaction>> {
        return Transformations.map(repository.get()) {
            it.map { item -> item.mapToTransaction() }
        }
    }
}