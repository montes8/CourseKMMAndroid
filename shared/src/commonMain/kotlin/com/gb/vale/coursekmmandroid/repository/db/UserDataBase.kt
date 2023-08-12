package com.gb.vale.coursekmmandroid.repository.db

import com.gb.vale.coursekmmandroid.entity.UserModel
import com.gb.vale.coursekmmandroid.manager.db.databaseDriverFactory
import com.gb.vale.coursekmmandroid.usecases.repository.db.IUserDataBase
import database.UserEntity
import database.UserKmmQueries

class UserDataBase( private val queries: UserKmmQueries = databaseDriverFactory().userKmmQueries):
    IUserDataBase {

    override suspend fun insertUser(user: UserModel) :Boolean{
        queries.insertUser(user.name, user.pass,user.token)
        return true
    }

    override suspend fun getUserById(id: Long): UserModel? {
        return queries
            .getUserById(id)
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getLogin(name: String, pass: String): UserModel? {
        return queries
            .getUserByActive(name,pass)
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getAllUsers(): List<UserModel> {
        return queries
            .selectAllUser()
            .executeAsList()
            .map { it.toUser() }
    }

    override suspend fun deleteUserById(id: Long) {
        queries.deleteNoteById(id)
    }
}

fun UserEntity.toUser(): UserModel {
    return UserModel(
        id = id,
        name = name,
        pass = pass,
        token = token
    )
}