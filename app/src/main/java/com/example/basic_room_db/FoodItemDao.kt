package com.example.basic_room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDao {

    @Query("SELECT * FROM FoodItem ORDER BY name")
    fun getFoodItems():Flow<MutableList<FoodItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(foodItem: FoodItem)

    @Delete
    suspend fun delete(foodItem: FoodItem)
}