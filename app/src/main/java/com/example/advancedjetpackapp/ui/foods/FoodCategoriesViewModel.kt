package com.example.advancedjetpackapp.ui.foods

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.advancedjetpackapp.model.FoodsRepository
import com.example.advancedjetpackapp.model.response.FoodResponse
import kotlinx.coroutines.*

class FoodCategoriesViewModel(private val repository: FoodsRepository = FoodsRepository()): ViewModel() {
    val foodsState: MutableState<List<FoodResponse>> = mutableStateOf(emptyList<FoodResponse>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val foods = getFoods()
            foodsState.value = foods
        }
    }

    private suspend fun getFoods(): List<FoodResponse> {
        return repository.getFoods().categories
    }
}