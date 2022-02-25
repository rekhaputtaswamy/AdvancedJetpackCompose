package com.example.advancedjetpackapp.model.api

import com.example.advancedjetpackapp.model.response.FoodsCategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class FoodsWebservice {
    private lateinit var api: FoodsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(FoodsApi::class.java)
    }

    suspend fun getFoods(): FoodsCategoriesResponse {
        return api.getFoods()
    }

    interface FoodsApi {
        @GET("categories.php")
        suspend fun getFoods(): FoodsCategoriesResponse
    }
}