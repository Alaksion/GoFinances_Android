package com.alaksion.gofinances.presentation.main.createtransaction

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alaksion.gofinances.domain.usecase.CreateTransactionUseCase
import com.alaksion.gofinances.shared.utils.Event
import kotlinx.coroutines.launch

class CreateTransactionViewModel(
    application: Application,
    private val createTransactionUseCase: CreateTransactionUseCase
) : AndroidViewModel(application) {

    var notifyNavigateBackToDashboard = MutableLiveData<Event<Unit>>()

    fun createTransaction(
        title: String,
        description: String,
        value: String,
        category: String
    ) {
        viewModelScope.launch {
            createTransactionUseCase.invoke(title, value.toDouble(), description, category)
            notifyNavigateBackToDashboard.value = Event(Unit)
        }

    }

}