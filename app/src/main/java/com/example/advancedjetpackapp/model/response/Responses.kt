package com.example.advancedjetpackapp.model.response

import com.google.gson.annotations.SerializedName

data class FoodsCategoriesResponse(val categories:List<FoodResponse>)

data class FoodResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String

)