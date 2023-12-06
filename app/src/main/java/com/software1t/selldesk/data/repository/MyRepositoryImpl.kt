package com.software1t.selldesk.data.repository

import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.local.model.CarLocalModel


class MyRepositoryImpl(
//    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val carMapper: Mapper<CarDataModel, CarDomainModel>,
) : MyRepository {

    override suspend fun populateWithMockData() {
        localDataSource.populateWithMockData()
    }

    override suspend fun getCarItem(id: Int): CarDomainModel {
        val carData = localDataSource.getCarItem(id)
        val carDomain = carMapper.from(carData)
        return carDomain
    }

    override suspend fun getCarItems(): List<CarDomainModel> {
        val carDataList = localDataSource.getCarItems()
        val carDomainList = carMapper.fromList(carDataList)
        return carDomainList
    }

    override suspend fun getFavoriteCarItems(): List<CarDomainModel> {
        val carDataList = localDataSource.getFavoriteCarItems()
        val carDomainList = carMapper.fromList(carDataList)
        return carDomainList
    }

    override suspend fun addCarItem(car: CarLocalModel) {
        TODO("Not yet implemented")
    }

    override suspend fun addCarItems(cars: List<CarLocalModel>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCarItem(car: CarLocalModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarItemById(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarItem(car: CarLocalModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarItems() {
        localDataSource.deleteCarItems()
    }
}