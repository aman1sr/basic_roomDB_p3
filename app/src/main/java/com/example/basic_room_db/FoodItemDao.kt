package com.example.basic_room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodItemDao {
/*
* Flow<> from kotlin-coroutines is used to observe data changes in the database.
* */
    @Query("SELECT * FROM FoodItem ORDER BY name")
    fun getFoodItems():Flow<MutableList<FoodItem>>

/*
*         @Insert and @Delete are DAO method annotations where SQL query is not required
* */
    @Insert(onConflict = OnConflictStrategy.IGNORE)     // OnConflictStrategy.IGNORE ignores the conflict when adding new item if the item is already present in the table.
     fun insert(foodItem: FoodItem)      // suspend fun are generally used to handle long running tasks without blocking the main thread

//    @Delete
//    suspend fun delete(foodItem: FoodItem)
}