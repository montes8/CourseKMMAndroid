package com.gb.vale.coursekmmandroid.usecases

import com.gb.vale.coursekmmandroid.entity.UserModel
import com.gb.vale.coursekmmandroid.repository.db.UserDataBase
import com.gb.vale.coursekmmandroid.usecases.repository.db.IUserDataBase


class UseUseCase {

    private val iUserDataBase : IUserDataBase = UserDataBase()

    suspend fun login(user : String , pass : String) : UserModel?{
        return iUserDataBase.getLogin(user,pass)
    }

    suspend fun register(user : String , pass : String,token :String):Boolean = iUserDataBase.insertUser(UserModel(0,user,pass,token))

}