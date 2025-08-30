package com.example.recipeapp.util

import com.example.recipeapp.model.RecipeDto
import com.example.recipeapp.model.RecipeEntity

// DTO -> Entity
fun RecipeDto.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        name = name,
        ingredients = ingredients,
        instructions = instructions,
        prepTimeMinutes = prepTimeMinutes,
        cookTimeMinutes = cookTimeMinutes,
        servings = servings,
        difficulty = difficulty,
        cuisine = cuisine,
        caloriesPerServing = caloriesPerServing,
        tags = tags,
        image = image,
        rating = rating,
        reviewCount = reviewCount,
        mealType = mealType,
        isFavorite = false
    )
}

// List RecipeDTO -> List RecipeEntity
fun List<RecipeDto>.toEntityList(): List<RecipeEntity> {
    return this.map { it.toEntity() }
}

