package com.software1t.selldesk.local.database

import androidx.room.*
import com.software1t.selldesk.local.model.CarLocalModel


@Dao
interface CarDao {

    @Query("SELECT * FROM CARS_TABLE WHERE id = :id")
    suspend fun getCarItem(id: Int): CarLocalModel

    @Query("SELECT * FROM CARS_TABLE")
    suspend fun getCarItems(): List<CarLocalModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCarItem(car: CarLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCarItems(cars: List<CarLocalModel>)

    @Update
    suspend fun updateCarItem(car: CarLocalModel)

    @Query("DELETE FROM CARS_TABLE WHERE id = :id")
    suspend fun deleteCarItemById(id: Int)

    @Delete
    suspend fun deleteCarItem(car: CarLocalModel)

    @Query("DELETE FROM CARS_TABLE")
    suspend fun deleteCarItems()
}