package com.example.advancedjetpackapp.model

import com.example.advancedjetpackapp.model.api.FoodsWebservice
import com.example.advancedjetpackapp.model.response.FoodsCategoriesResponse

class FoodsRepository(private val webservice: FoodsWebservice = FoodsWebservice()) {
    suspend fun getFoods(): FoodsCategoriesResponse {
        return webservice.getFoods()
    }
}