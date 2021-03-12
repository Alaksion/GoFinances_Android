package com.alaksion.gofinances.domain.usecase

import com.alaksion.gofinances.data.model.mapToTransactionData
import com.alaksion.gofinances.data.repository.GoFinancesTransactionRepositoryImpl
import com.alaksion.gofinances.domain.model.Transaction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class CreateTransactionUseCase(
    private val repository: GoFinancesTransactionRepositoryImpl
) {

    operator fun invoke(
        title: String,
        value: Double,
        description: String,
        category: String
    ) {

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        val transaction = Transaction(
            title = title,
            value = value,
            description = description,
            category = category,
            createdAt = currentDate,
            id = 0
        )

        repository.create(transaction.mapToTransactionData())
    }
}