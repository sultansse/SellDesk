package com.software1t.selldesk.di

import androidx.room.Room
import com.software1t.selldesk.common.constants.Constants.Companion.DATABASE_NAME
import com.software1t.selldesk.data.mapper.CarDataDomainMapper
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.domain.GetMyDataUseCase
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.domain.mapper.CarDomainUiMapper
import com.software1t.selldesk.local.database.AppDatabase
import com.software1t.selldesk.local.mapper.CarLocalDataMapper
import com.software1t.selldesk.presentation.details_screen.HomeComposer
import com.software1t.selldesk.presentation.home_screen.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val databaseModule = module {
/*
single { provideAppDatabase(context = androidContext()) }
    single {provideCarDAO(appDatabase = get())}
*/

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    factory { get<AppDatabase>().carDao() }
}

/*
val mapperModule = module {
    factory<Mapper<CarLocalModel, CarDataModel>> { provideLocalDataMapper() }
    factory<Mapper<CarDataModel, CarDomainModel>> { provideDataDomainMapper() }
    factory<Mapper<CarDomainModel, CarUiModel>> { provideDomainUiMapper() }
}
*/

val mapperModule = module {
    factory { CarLocalDataMapper() }
    factory { CarDataDomainMapper() }
    factory { CarDomainUiMapper() }
}


val dataSourceModule = module {
    factory<LocalDataSource> { provideLocalDataSource(carDao = get(), mapper = get()) }
//    factory<LocalDataSource> { provideLocalDataSource(mapper = get()) }
}

val repositoryModule = module {
    single<MyRepository> { provideMyRepository(localDataSource = get(), mapper = get()) }
}

val useCaseModule = module {
    factory<GetMyDataUseCase> { provideGetMyDataUseCase(repo = get(), mapper = get()) }
    factory { HomeComposer() }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(
//            itemComposer = get(),
            getMyData = get(),
        )
    }
}

val appModule = listOf(
    mapperModule,
    databaseModule,
    dataSourceModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)