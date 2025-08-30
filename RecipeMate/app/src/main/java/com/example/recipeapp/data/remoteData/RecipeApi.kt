package com.example.recipeapp.data.remoteData

import com.example.recipeapp.model.RecipeResponse
import retrofit2.http.GET

interface RecipeApi {
    @GET("recipes") //https://dummyjson.com/recipes
    suspend fun getRecipes(): RecipeResponse //suspend == async method
}