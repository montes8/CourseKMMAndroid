package com.gb.vale.coursekmmandroid.usecases.repository.network

import com.gb.vale.coursekmmandroid.entity.RecipeModel

interface IDataNetwork {
    suspend fun loadRecipes( ): List<RecipeModel>

}