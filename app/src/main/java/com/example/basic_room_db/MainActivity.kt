package com.example.basic_room_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val foodItemViewModel: FoodItemViewModel by viewModels {
        FoodItemViewModel.FoodItemViewModelFactory((application as MyApplication).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val foodItem = FoodItem("Tarbuj", 140f)
//
//        foodItemViewModel.insert(foodItem)

        foodItemViewModel.allFoodItems.observe(this, {
            foodItemList ->
            foodItemList?.let {
//                var foodItems = foodItemList

                var msg = ""

                for (foodItem in foodItemList) {
                    msg += foodItem.toString() + "\n\n"
                }

                AlertDialog.Builder(this).setMessage(msg).show()

            }
        })






    }
}