package com.alaksion.gofinances.domain.usecase

import com.alaksion.gofinances.data.model.mapToTransactionData
import com.alaksion.gofinances.data.repository.GoFinancesTransactionRepositoryImpl
import com.alaksion.gofinances.domain.model.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class CreateTransactionUseCase(
    private val repository: GoFinancesTransactionRepositoryImpl
) {

    operator fun invoke(
        title: String,
        value: Double,
        description: String,
        category: String
    ) {
        val transaction = Transaction(
            title = title,
            value = value,
            description = description,
            category = category,
            createdAt = LocalDateTime.now().toString(),
            id = 0
        )

        CoroutineScope(IO).launch {
            repository.create(transaction.mapToTransactionData())
        }
    }
}