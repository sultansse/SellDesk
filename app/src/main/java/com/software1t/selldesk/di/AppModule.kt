package com.software1t.selldesk.di

import com.software1t.selldesk.data.mapper.CarDataDomainMapper
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.domain.mapper.CarDomainUiMapper
import com.software1t.selldesk.local.mapper.CarLocalDataMapper
import com.software1t.selldesk.presentation.details_screen.DetailsComposer
import com.software1t.selldesk.presentation.details_screen.DetailsViewModel
import com.software1t.selldesk.presentation.home_screen.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/*
val mapperModule = module {
    factory<Mapper<CarLocalModel, CarDataModel>> { provideLocalDataMapper() }
    factory<Mapper<CarDataModel, CarDomainModel>> { provideDataDomainMapper() }
    factory<Mapper<CarDomainModel, CarUiModel>> { provideDomainUiMapper() }
}
*/

val databaseModule = module {
    single { provideAppDatabase(context = androidContext()) }
    single { provideCarDAO(appDatabase = get()) }
}

val mapperModule = module {
    factory { CarLocalDataMapper() }
    factory { CarDataDomainMapper() }
    factory { CarDomainUiMapper() }
}

val dataSourceModule = module {
    factory<LocalDataSource> { provideLocalDataSource(carDao = get(), mapper = get()) }
}

val repositoryModule = module {
    single<MyRepository> { provideMyRepository(localDataSource = get(), mapper = get()) }
}

val useCaseModule = module {
    factory<GetMyDataUseCase> { provideGetMyDataUseCase(repo = get(), mapper = get()) }
}

val otherClassesModule = module {
    factory { DetailsComposer() }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            getMyData = get(),
        )
    }
    viewModel {
        DetailsViewModel(
            itemComposer = get(),
        )
    }
}


val appModule = listOf(
    otherClassesModule,
    mapperModule,
    databaseModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)