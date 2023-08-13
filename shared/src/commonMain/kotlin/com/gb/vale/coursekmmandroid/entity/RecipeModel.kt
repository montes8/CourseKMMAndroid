package com.gb.vale.coursekmmandroid.entity

import com.gb.vale.coursekmmandroid.utils.EMPTY

data class RecipeModel (
    var id : Long = 0,
    var title : String = EMPTY,
    var description : String = EMPTY,
    var preparation : String = EMPTY,
    var urlImg : String = EMPTY,
    var institute : String = EMPTY,
    var addressInstitute : String = EMPTY,
    var latitude : String = "0.0",
    var longitude : String = "0.0"
)