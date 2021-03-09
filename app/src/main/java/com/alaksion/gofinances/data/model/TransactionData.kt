package com.alaksion.gofinances.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alaksion.gofinances.domain.model.Transaction

@Entity
data class TransactionData(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id : Long,

    @ColumnInfo(name = "title")
    val title : String,

    @ColumnInfo(name = "value")
    val value : Double,

    @ColumnInfo(name = "description")
    val description : Double,

    @ColumnInfo(name = "createdAt")
    val createdAt : String,

    @ColumnInfo(name = "category")
    val category : String
)

fun TransactionData.mapToTransaction() : Transaction {
    return Transaction(
        id = this.id,
        title = this.title,
        value = this.value,
        description = this.description,
        createdAt = this.createdAt,
        category = this.category
    )
}