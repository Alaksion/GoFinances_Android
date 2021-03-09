package com.alaksion.gofinances.shared.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alaksion.gofinances.data.local.TransactionsDAO
import com.alaksion.gofinances.data.model.TransactionData

@Database(entities = [TransactionData::class], version = 1)
abstract class GoFinanceDatabase : RoomDatabase() {

    abstract fun transactionDao(): TransactionsDAO

    companion object {
        private lateinit var INSTANCE: GoFinanceDatabase
        fun getInstance(context: Context): RoomDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GoFinanceDatabase::class.java) {
                    INSTANCE =
                        Room.databaseBuilder(context, GoFinanceDatabase::class.java, "Database")
                            .build()
                }
            }
            return INSTANCE
        }
    }

}