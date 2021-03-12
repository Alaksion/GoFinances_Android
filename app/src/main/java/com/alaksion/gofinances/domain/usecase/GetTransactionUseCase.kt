package com.alaksion.gofinances.domain.usecase

import com.alaksion.gofinances.data.model.mapToTransaction
import com.alaksion.gofinances.data.repository.GoFinancesTransactionRepositoryImpl
import com.alaksion.gofinances.domain.model.Transaction

class GetTransactionUseCase(
    private val repository: GoFinancesTransactionRepositoryImpl
) {

    operator fun invoke(): List<Transaction> {
        return repository.get().map { item -> item.mapToTransaction() }
    }
}