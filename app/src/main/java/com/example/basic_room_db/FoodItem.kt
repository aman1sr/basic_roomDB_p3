package com.example.basic_room_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodItem")
class FoodItem (@PrimaryKey @ColumnInfo(name = "name") val name: String,
                @ColumnInfo(name = "price") val price: Float)