package com.alaksion.gofinances.domain.model

data class Transaction(
    val id : Long,
    val title : String,
    val value : Double,
    val createdAt : String,
    val category : String
)