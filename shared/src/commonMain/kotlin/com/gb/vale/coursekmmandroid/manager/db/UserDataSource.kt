package com.gb.vale.coursekmmandroid.manager.db


interface UserDataSource {
    suspend fun insertUser(user: UserModel)
    suspend fun getUserById(id: Long): UserModel?
    suspend fun getUserValidate(name: String,pass : String): UserModel?
    suspend fun getAllUsers(): List<UserModel>
    suspend fun deleteUserById(id: Long)
}