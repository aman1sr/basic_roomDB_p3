package com.example.basic_room_db

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/*
* To have only one instance of the database and
*        of the repository in the entire application create them as members of the Application class.
* */
class MyApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy {
        FoodItemRoomDB.getDatabase(this, applicationScope)
    }

    val repository by lazy {
        FoodItemRepository(database.foodItemDao())
    }

}