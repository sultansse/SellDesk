package com.software1t.selldesk.domain

import com.software1t.selldesk.domain.model.CarDomainModel
import com.software1t.selldesk.local.model.CarLocalModel


interface MyRepository {

    suspend fun populateWithMockData()

    suspend fun getCarItem(id: Int): CarDomainModel

    suspend fun getCarItems(): List<CarDomainModel>

    suspend fun getFavoriteCarItems(): List<CarDomainModel>

    suspend fun addCarItem(car: CarLocalModel)

    suspend fun addCarItems(cars: List<CarLocalModel>)

    suspend fun updateCarItem(car: CarLocalModel)

    suspend fun deleteCarItemById(id: Int)

    suspend fun deleteCarItem(car: CarLocalModel)

    suspend fun deleteCarItems()
}