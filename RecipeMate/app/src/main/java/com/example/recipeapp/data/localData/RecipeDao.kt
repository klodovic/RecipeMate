package com.example.recipeapp.data.localData

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.recipeapp.model.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    //// 1. API fetch
    // 1.1. Inserts recipes from API
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recipes: List<RecipeEntity>)

    //// 2. User interaction

    // 2.1. Gets all recipes from database table
    @Query("select * from recipes")
    fun gelAllRecipes(): Flow<List<RecipeEntity>>
    //Flow -> live data. Flow is part of the Kotlin coroutines designed
    // to provide efficient way to handle asynchronous data stream.
    // Works well with Room to fetch and update during data manipulation
    // *** Flow methods (like: getAllRecipes() and getRecipe(id)) should not be
    // suspend. Room takes care about asynchronous data stream.

    // 2.2. Adds recipe
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: RecipeEntity)

    // 2.3. Updates recipe
    @Update
    suspend fun updateRecipe(recipe: RecipeEntity)

    // 2.4. Deletes recipe
    @Delete
    suspend fun deleteRecipe(recipe: RecipeEntity)

    // 2.5. Gets single recipe
    @Query("select * from recipes where id=:id")
    fun getRecipe(id: Int): Flow<RecipeEntity>


    //// 3. Favorite feature

    // 3.1. Gets all favorite recipes from database table
    @Query("select * from recipes where isFavorite = 1")
    fun getFavoriteRecipes(): Flow<List<RecipeEntity>>

    // 3.2. Marks recipe favorite
    @Query("update recipes set isFavorite = 1 where id=:id")
    suspend fun markAsFavorite(id: Int)

    // 3.3. Unmarks recipe favorite
    @Query("update recipes set isFavorite = 0 where id=:id")
    suspend fun unmarkAsFavorite(id: Int)

}