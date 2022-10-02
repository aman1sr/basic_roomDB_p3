package com.example.basic_room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [FoodItem::class], version = 1, exportSchema = false)      // version and exportSchema are mainly used when we have to make Database Migrations, that's why exportSchemais set to false here.

public abstract class FoodItemRoomDB:RoomDatabase() {

    abstract fun foodItemDao(): FoodItemDao

    companion object {

        @Volatile
        private var INSTANCE: FoodItemRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): FoodItemRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodItemRoomDB::class.java,
                    "food_item_database"
                ).addCallback(FoodItemCallback(scope))
                    .build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

    private class FoodItemCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { foodItemRoomDB ->
                scope.launch {
                    // if you want to populate database
                    // when RoomDatabase is created
                    // populate here
                    foodItemRoomDB.foodItemDao().insert(FoodItem("Mango", 100f))
                    foodItemRoomDB.foodItemDao().insert(FoodItem("Apple", 120f))
                    foodItemRoomDB.foodItemDao().insert(FoodItem("Orange", 80f))
                }
            }
        }
    }
}



