package com.alaksion.gofinances.presentation.main.createtransaction

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.alaksion.gofinances.domain.usecase.CreateTransactionUseCase

class CreateTransactionViewModel(
    application: Application,
    private val createTransactionUseCase: CreateTransactionUseCase
) : AndroidViewModel(application) {

    fun createTransaction(
        title: String,
        description: String,
        value: String,
        category: String
    ) {
        createTransactionUseCase.invoke(title, value.toDouble(), description, category)
    }

}