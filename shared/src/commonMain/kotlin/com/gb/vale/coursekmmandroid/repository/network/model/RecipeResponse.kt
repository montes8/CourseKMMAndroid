package com.gb.vale.coursekmmandroid.repository.network.model

import com.gb.vale.coursekmmandroid.entity.RecipeModel
import com.gb.vale.coursekmmandroid.utils.EMPTY
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    @SerialName("id")
    var id : Long?,
    @SerialName("title")
    var title : String?,
    @SerialName("description")
    var description : String?,
    @SerialName("preparation")
    var preparation : String?,
    @SerialName("urlImg")
    var urlImg : String?,
    @SerialName("institute")
    var institute : String?,
    @SerialName("addressInstitute")
    var addressInstitute : String?,
    @SerialName("latitude")
    var latitude : String?,
    @SerialName("longitude")
    var longitude : String?
){
    companion object{
        fun loadToRecipes(response : List<RecipeResponse>) = response.map {
            RecipeModel(id = it.id?:0,title = it.title?: EMPTY,
                description = it.description?:EMPTY,preparation= it.preparation?:EMPTY,
                urlImg = it.urlImg?:EMPTY, institute = it.institute?:EMPTY,
                addressInstitute = it.addressInstitute?:EMPTY,
                latitude = it.latitude?:"0.0", longitude = it.longitude?:"0.0")
        }
    }
}