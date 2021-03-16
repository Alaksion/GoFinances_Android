package com.alaksion.gofinances.presentation.main.dashboard

import android.app.Application
import androidx.lifecycle.*
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.domain.usecase.DeleteTransactionUseCase
import com.alaksion.gofinances.domain.usecase.GetTransactionUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DashBoardViewModel(
    application: Application,
    private val getTransactionUseCase: GetTransactionUseCase,
    private val deleteTransactionUseCase: DeleteTransactionUseCase
) : AndroidViewModel(application) {

    private val mTransactionList = MutableLiveData<List<Transaction>>()
    var transactionList : LiveData<List<Transaction>> = mTransactionList

    fun loadTransactions() {
        viewModelScope.launch {
            mTransactionList.value = getTransactionUseCase.invoke()
        }
    }

    fun deleteTransaction(transaction: Transaction) {
        viewModelScope.launch {
            deleteTransactionUseCase.invoke(transaction)
        }
    }
}