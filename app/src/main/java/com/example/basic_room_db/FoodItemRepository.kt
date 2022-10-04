package com.example.basic_room_db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/* repository class is responsible for interacting with the Room database
        and will need to provide methods that use the DAO to insert, delete and query items.
*/
class FoodItemRepository(private val foodItemDao: FoodItemDao) {

    val alFoodItems: Flow<MutableList<FoodItem>> = foodItemDao.getFoodItems()


    /*
    * In insert()  functions we are directly inserting  food item without ensuring that long running tasks
    *            shouldn't perform on the main thread because room by default runs suspend queries off the MainThread
    * */
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodItem: FoodItem) {
        foodItemDao.insert(foodItem)
    }

//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun delete(foodItem: FoodItem) {
//        foodItemDao.delete(foodItem)
//    }



}