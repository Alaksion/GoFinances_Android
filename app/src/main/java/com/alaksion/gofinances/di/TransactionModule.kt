package com.alaksion.gofinances.di

import androidx.room.Room
import com.alaksion.gofinances.data.local.GoFinancesLocalDataSourceImpl
import com.alaksion.gofinances.data.repository.GoFinancesTransactionRepositoryImpl
import com.alaksion.gofinances.domain.usecase.GetTransactionUseCase
import com.alaksion.gofinances.presentation.main.dashboard.DashBoardViewModel
import com.alaksion.gofinances.shared.database.GoFinanceDatabase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val transactionModule = module {

    factory { GoFinancesLocalDataSourceImpl(db = get()) }
    factory { GoFinancesTransactionRepositoryImpl(localDataSource = get()) }
    factory { GetTransactionUseCase(repository = get()) }

    viewModel {
        DashBoardViewModel(getTransactionUseCase = get(), application = get())
    }

    single {
        Room.databaseBuilder(
            get(),
            GoFinanceDatabase::class.java,
            "Database"
        ).build()
    }
}