package com.alaksion.gofinances.domain.usecase

import com.alaksion.gofinances.data.model.mapToTransactionData
import com.alaksion.gofinances.data.repository.GoFinancesTransactionRepositoryImpl
import com.alaksion.gofinances.domain.model.Transaction

class DeleteTransactionUseCase(
    val repository: GoFinancesTransactionRepositoryImpl
) {
    suspend operator fun invoke(transaction: Transaction) {
        repository.delete(transaction.mapToTransactionData())
    }
}