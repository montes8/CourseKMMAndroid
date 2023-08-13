package com.gb.vale.coursekmmandroid.repository.network

import com.gb.vale.coursekmmandroid.entity.RecipeModel
import com.gb.vale.coursekmmandroid.repository.network.manager.KtorApi
import com.gb.vale.coursekmmandroid.repository.network.model.RecipeResponse
import com.gb.vale.coursekmmandroid.utils.validateData
import io.ktor.client.call.*
import io.ktor.client.request.*

class KmmService : KtorApi() {

    suspend fun getRecipes(): List<RecipeResponse> = client.get("") {
        pathUrlGet("user/loadRecipes")
    }.validateData()

    suspend fun saveRecipes(): List<RecipeResponse> = client.get {
        pathUrlPost("service/user/loadRecipes", RecipeModel())
    }.body()

}