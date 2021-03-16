package com.alaksion.gofinances.presentation.main.dashboard.listener

import com.alaksion.gofinances.domain.model.Transaction

interface TransactionListListener {
    fun onHoldClick(transaction: Transaction)
}