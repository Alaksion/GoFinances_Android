package com.alaksion.gofinances.presentation.main.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alaksion.gofinances.domain.model.Transaction
import com.alaksion.gofinances.domain.usecase.GetTransactionUseCase

class DashBoardViewModel(
    application: Application,
    private val getTransactionUseCase: GetTransactionUseCase
) : AndroidViewModel(application) {

    private val mTransactionList = MutableLiveData<List<Transaction>>()
    var transactionList: LiveData<List<Transaction>> = mTransactionList

    fun loadTransactions() {
        mTransactionList.value = getTransactionUseCase.invoke().value
    }
}