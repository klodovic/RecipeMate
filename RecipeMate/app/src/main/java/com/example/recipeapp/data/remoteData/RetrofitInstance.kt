package com.example.recipeapp.data.remoteData

object RetrofitInstance {
    val api: RecipeApi by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl("https://dummyjson.com/") // API endpoint url
            .addConverterFactory( // JSON conversion
                retrofit2.converter.gson.GsonConverterFactory.create()
            )
            .build()
            .create(RecipeApi::class.java)
    }
}