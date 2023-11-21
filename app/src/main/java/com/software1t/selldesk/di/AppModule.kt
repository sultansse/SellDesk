package com.software1t.selldesk.di

import com.software1t.selldesk.data.repository.MyRepositoryImpl
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.local.source.LocalDataSourceImpl
import com.software1t.selldesk.presentation.home_screen.HomeComposer
import com.software1t.selldesk.presentation.home_screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataSourceModule = module {
    factory<LocalDataSource> { LocalDataSourceImpl() }
}

val repositoryModule = module {
    single<MyRepository> { MyRepositoryImpl(localDataSource = get()) }
}

val useCaseModule = module {
    factory { GetMyDataUseCase(repository = get()) }
    factory { HomeComposer() }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            itemComposer = get(),
            getMyData = get(),
        )
    }
}

val appModule = listOf(dataSourceModule, repositoryModule, useCaseModule, viewModelModule)