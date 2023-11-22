package com.software1t.selldesk.local.database

import androidx.room.*
import com.software1t.selldesk.local.model.CarLocalModel


@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCarItem(car: CarLocalModel): Long

    @Query("SELECT * FROM CARS_TABLE WHERE id = :id")
    suspend fun getCarItem(id: Int): CarLocalModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCarItems(cars: List<CarLocalModel>): List<Long>

    @Query("SELECT * FROM CARS_TABLE")
    suspend fun getCarItems(): List<CarLocalModel>

    @Update
    suspend fun updateCarItem(car: CarLocalModel): Int

    @Query("DELETE FROM CARS_TABLE WHERE id = :id")
    suspend fun deleteCarItemById(id: Int): Int

    @Delete
    suspend fun deleteCarItem(car: CarLocalModel): Int

    @Query("DELETE FROM CARS_TABLE")
    suspend fun clearCachedCarItems(): Int
}