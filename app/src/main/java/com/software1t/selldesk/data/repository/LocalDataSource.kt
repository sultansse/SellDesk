package com.software1t.selldesk.data.repository

import com.software1t.selldesk.common.Resource
import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.local.model.CarLocalModel

interface LocalDataSource {

    suspend fun getAllMyData(): List<CarDataModel>


    suspend fun addCarItem(car: CarLocalModel): Resource<Long>

    suspend fun getCarItem(id: Int): Resource<CarLocalModel>

    suspend fun addCarItems(cars: List<CarLocalModel>): Resource<List<Long>>

    suspend fun getCarItems(): Resource<List<CarLocalModel>>

    suspend fun updateCarItem(car: CarLocalModel): Resource<Int>

    suspend fun deleteCarItemById(id: Int): Resource<Int>

    suspend fun deleteCarItem(car: CarLocalModel): Resource<Int>

    suspend fun clearCachedCarItems(): Resource<Int>
}