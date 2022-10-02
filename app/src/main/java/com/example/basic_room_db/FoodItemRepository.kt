package com.example.basic_room_db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class FoodItemRepository(private val foodItemDao: FoodItemDao) {

    val alFoodItems: Flow<MutableList<FoodItem>> = foodItemDao.getFoodItems()

    /*
    * ROOM by default runs suspend queries off the MainThread
    *    and we are not required anything else to implement.
    * */
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodItem: FoodItem) {
        foodItemDao.insert(foodItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(foodItem: FoodItem) {
        foodItemDao.delete(foodItem)
    }



}