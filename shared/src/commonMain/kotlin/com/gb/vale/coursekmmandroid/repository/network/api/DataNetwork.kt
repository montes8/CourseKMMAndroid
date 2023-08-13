package com.gb.vale.coursekmmandroid.repository.network.api

import com.gb.vale.coursekmmandroid.entity.RecipeModel
import com.gb.vale.coursekmmandroid.repository.network.KmmService
import com.gb.vale.coursekmmandroid.repository.network.model.RecipeResponse
import com.gb.vale.coursekmmandroid.usecases.repository.network.IDataNetwork

class DataNetwork : IDataNetwork {

    private val apiService: KmmService = KmmService()

    override suspend fun loadRecipes() : List<RecipeModel> {
        return RecipeResponse.loadToRecipes(apiService.getRecipes())
    }

}