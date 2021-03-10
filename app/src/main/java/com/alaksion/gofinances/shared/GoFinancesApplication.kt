package com.alaksion.gofinances.shared

import android.app.Application
import com.alaksion.gofinances.di.transactionModule
import org.koin.android.ext.android.startKoin

class GoFinancesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, arrayListOf(transactionModule))
    }
}