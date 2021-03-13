package com.alaksion.gofinances.domain.model

enum class TransactionTypes (private val text: String) {

    INCOME("Income"),
    OUTCOME("Outcome");

    fun getText() : String {
        return text
    }

    override fun toString(): String {
        return this.text
    }

 }

