package com.gb.vale.coursekmmandroid.android.utils

import android.content.Context
import android.widget.Toast

fun Context.toastGeneric(message : String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}