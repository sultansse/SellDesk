package com.software1t.selldesk.local.source

import com.software1t.selldesk.common.Resource
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

    override suspend fun getAllMyData(): List<CarDataModel> {
//             val postLocalList = postDAO.getPostItems()
//        return postMapper.fromList(postLocalList)
        val carLocalList = MyMockData.myMockCars
        val carDataList = carMapper.fromList(carLocalList)
        return carDataList
    }

    override suspend fun addCarItem(car: CarLocalModel): Resource<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun getCarItem(id: Int): Resource<CarLocalModel> {
        TODO("Not yet implemented")
    }

    override suspend fun addCarItems(cars: List<CarLocalModel>): Resource<List<Long>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCarItems(): Resource<List<CarLocalModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCarItem(car: CarLocalModel): Resource<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarItemById(id: Int): Resource<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCarItem(car: CarLocalModel): Resource<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun clearCachedCarItems(): Resource<Int> {
        TODO("Not yet implemented")
    }
}
