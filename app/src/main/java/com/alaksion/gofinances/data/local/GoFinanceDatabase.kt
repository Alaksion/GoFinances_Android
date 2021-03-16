package com.alaksion.gofinances.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alaksion.gofinances.data.local.TransactionsDAO
import com.alaksion.gofinances.data.model.TransactionData

@Database(entities = [TransactionData::class], version = 2)
abstract class GoFinanceDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionsDAO

}