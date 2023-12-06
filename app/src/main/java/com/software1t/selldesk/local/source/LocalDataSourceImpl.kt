package com.software1t.selldesk.local.source

import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.data.repository.LocalDataSource
import com.software1t.selldesk.local.MyMockData
import com.software1t.selldesk.local.database.CarDao
import com.software1t.selldesk.local.mapper.CarLocalDataMapper
import com.software1t.selldesk.local.model.CarLocalModel


class LocalDataSourceImpl(
    private val carDao: CarDao,
    private val carMapper: CarLocalDataMapper,
//    private val carMapper: Mapper<CarLocalModel, CarDataModel>,
) : LocalDataSource {

    override suspend fun populateWithMockData() {
        carDao.addCarItems(MyMockData.myMockCars)
    }

    override suspend fun getCarItem(id: Int): CarDataModel {
        val carLocal = carDao.getCarItem(id)
        val carData = carMapper.from(carLocal)
        return carData
    }

    override suspend fun getCarItems(): List<CarDataModel> {
        val carLocalList = carDao.getCarItems()
        val carDataList = carMapper.fromList(carLocalList)
        return carDataList
    }

    override suspend fun getFavoriteCarItems(): List<CarDataModel> {
        val carLocalList = carDao.getFavoriteCarItems()
        val carDataList = carMapper.fromList(carLocalList)
        return carDataList
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
        carDao.deleteCarItems()
    }
}
