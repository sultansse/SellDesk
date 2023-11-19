package com.software1t.selldesk.di

import com.software1t.selldesk.data.MyRepositoryImpl
import com.software1t.selldesk.data.model.LocalDataSource
import com.software1t.selldesk.domain.GetCategoriesUseCase
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.local.source.LocalDataSourceImpl
import com.software1t.selldesk.presentation.details_screen.DetailsViewModel
import com.software1t.selldesk.presentation.home_screen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val dataSourceModule = module {
    factory<LocalDataSource> { LocalDataSourceImpl() }
}

val repositoryModule = module {
    single<MyRepository> { MyRepositoryImpl(localDataSource = get()) }
}

val useCaseModule = module {
    factory { GetMyDataUseCase(repository = get()) }
    factory { GetCategoriesUseCase(repository = get()) }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(
        getMyData = get(),
        getCategories = get(),
        )
    }
}

val appModule = listOf(dataSourceModule, repositoryModule, useCaseModule, viewModelModule)