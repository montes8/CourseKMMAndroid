package com.gb.vale.coursekmmandroid.repository.network

import com.gb.vale.coursekmmandroid.entity.RecipeModel
import com.gb.vale.coursekmmandroid.usecases.repository.network.IDataNetwork

class DataNetwork : IDataNetwork {

    override  suspend fun loadRecipes(): List<RecipeModel>{
        return arrayListOf()
    }

}