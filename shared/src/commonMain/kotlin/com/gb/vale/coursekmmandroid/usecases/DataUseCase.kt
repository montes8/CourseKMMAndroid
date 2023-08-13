package com.gb.vale.coursekmmandroid.usecases

import com.gb.vale.coursekmmandroid.repository.network.api.DataNetwork
import com.gb.vale.coursekmmandroid.usecases.repository.network.IDataNetwork

class DataUseCase  {

    private val iDataNetwork : IDataNetwork = DataNetwork()

    suspend fun loadRecipes() = iDataNetwork.loadRecipes()

}