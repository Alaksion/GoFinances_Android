package com.alaksion.gofinances.domain.model

enum class TransactionTypes (private val text: String) {

    INCOME("income"),
    OUTCOME("outcome");

    fun getText() : String {
        return text
    }

 }

