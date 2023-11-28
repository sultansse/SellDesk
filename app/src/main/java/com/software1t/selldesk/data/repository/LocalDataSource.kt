package com.software1t.selldesk.data.repository

import com.software1t.selldesk.data.model.CarDataModel
import com.software1t.selldesk.local.model.CarLocalModel

interface LocalDataSource {

    suspend fun populateWithMockData()


    suspend fun getCarItem(id: Int): CarDataModel

    suspend fun getCarItems(): List<CarDataModel>

    suspend fun addCarItem(car: CarLocalModel)

    suspend fun addCarItems(cars: List<CarLocalModel>)

    suspend fun updateCarItem(car: CarLocalModel)

    suspend fun deleteCarItemById(id: Int)

    suspend fun deleteCarItem(car: CarLocalModel)

    suspend fun deleteCarItems()
}