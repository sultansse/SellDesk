package com.software1t.selldesk.data.repository

import com.software1t.selldesk.common.Mapper
import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.domain.MyRepository
import com.software1t.selldesk.domain.model.CarDomainModel


class MyRepositoryImpl(
//    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val carMapper: Mapper<CarDataModel, CarDomainModel>,
) : MyRepository {

    override suspend fun getAllMyData(): List<CarDomainModel> {
        val carDataList = localDataSource.getAllMyData()
        val carDomainList = carMapper.fromList(carDataList)
        return carDomainList
    }
}