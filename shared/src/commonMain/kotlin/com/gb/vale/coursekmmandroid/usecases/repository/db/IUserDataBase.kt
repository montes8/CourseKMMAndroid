package com.gb.vale.coursekmmandroid.usecases.repository.db

import com.gb.vale.coursekmmandroid.entity.UserModel

interface IUserDataBase {
    suspend fun insertUser(user: UserModel) :Boolean
    suspend fun getUserById(id: Long): UserModel?
    suspend fun getLogin(name: String,pass : String): UserModel?
    suspend fun getAllUsers(): List<UserModel>
    suspend fun deleteUserById(id: Long)

}