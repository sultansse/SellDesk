package com.software1t.selldesk.di

import android.content.Context
import androidx.room.Room
import com.software1t.selldesk.common.constants.Constants.Companion.DATABASE_NAME
import com.software1t.selldesk.data.mapper.CarDataDomainMapper
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.data.repository.MyRepositoryImpl
import com.software1t.selldesk.domain.ClearDatabaseUseCase
import com.software1t.selldesk.domain.ClearDatabaseUseCaseImpl
import com.software1t.selldesk.domain.GetCarsUseCase
import com.software1t.selldesk.domain.GetCarsUseCaseImpl
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.domain.PopulateDbUseCase
import com.software1t.selldesk.domain.PopulateDbUseCaseImpl
import com.software1t.selldesk.domain.mapper.CarDomainUiMapper
import com.software1t.selldesk.local.database.AppDatabase
import com.software1t.selldesk.local.database.CarDao
import com.software1t.selldesk.local.mapper.CarLocalDataMapper
import com.software1t.selldesk.local.source.LocalDataSourceImpl


fun provideLocalDataSource(carDao: CarDao, mapper: CarLocalDataMapper): LocalDataSource =
    LocalDataSourceImpl(carDao, mapper)

fun provideMyRepository(
    localDataSource: LocalDataSource,
    mapper: CarDataDomainMapper
): MyRepository =
    MyRepositoryImpl(localDataSource, mapper)

//usecases
fun providePopulateDbUseCase(repo: MyRepository): PopulateDbUseCase =
    PopulateDbUseCaseImpl(repo)

fun provideGetCarsUseCase(repo: MyRepository, mapper: CarDomainUiMapper): GetCarsUseCase =
    GetCarsUseCaseImpl(repo, mapper)

fun provideClearDatabaseUseCase(repo: MyRepository): ClearDatabaseUseCase =
    ClearDatabaseUseCaseImpl(repo)

//db
fun provideCarDAO(appDatabase: AppDatabase) = appDatabase.carDao()
fun provideAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}



//mappers
/*
fun provideLocalDataMapper() : Mapper<CarLocalModel, CarDataModel> = CarLocalDataMapper()
fun provideDataDomainMapper() : Mapper<CarDataModel, CarDomainModel> = CarDataDomainMapper()
fun provideDomainUiMapper() : Mapper<CarDomainModel, CarUiModel> = CarDomainUiMapper()
*/

/*
fun provideLocalDataSource(carDao: CarDao, mapper: Mapper<CarLocalModel, CarDataModel>): LocalDataSource = LocalDataSourceImpl(carDao, mapper)
fun provideMyRepository(localDataSource: LocalDataSource, mapper: Mapper<CarDataModel, CarDomainModel>): MyRepository = MyRepositoryImpl(localDataSource, mapper)
fun provideGetMyDataUseCase(repo: MyRepository, mapper: Mapper<CarDomainModel, CarUiModel>): GetMyDataUseCase = GetMyDataUseCaseImpl(repo, mapper)
*/