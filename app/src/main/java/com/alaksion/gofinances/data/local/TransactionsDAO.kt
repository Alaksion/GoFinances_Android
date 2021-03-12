package com.alaksion.gofinances.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alaksion.gofinances.data.model.TransactionData

@Dao
interface TransactionsDAO {

    @Insert
    fun create(transaction: TransactionData)

    @Query(value = "select * from TransactionData order by createdAt desc")
    fun get() : List<TransactionData>
}