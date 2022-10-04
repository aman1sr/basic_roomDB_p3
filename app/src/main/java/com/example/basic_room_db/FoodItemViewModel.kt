package com.example.basic_room_db

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.*
import kotlinx.coroutines.launch

/* The ViewModel is responsible to provide data to the UI  */
class FoodItemViewModel(private val foodItemRepository: FoodItemRepository) : ViewModel() {

    val allFoodItems : LiveData<MutableList<FoodItem>> = foodItemRepository.alFoodItems.asLiveData()

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insert(foodItem: FoodItem) = viewModelScope.launch {
        foodItemRepository.insert(foodItem)
    }

//    fun delete(foodItem: FoodItem) = viewModelScope.launch {
//        foodItemRepository.delete(foodItem)
//    }

    class FoodItemViewModelFactory(private val foodItemRepository: FoodItemRepository)
        :ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FoodItemViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return FoodItemViewModel(foodItemRepository) as T
            }
            throw IllegalArgumentException("Unknown VieModel Class")
        }

    }

}