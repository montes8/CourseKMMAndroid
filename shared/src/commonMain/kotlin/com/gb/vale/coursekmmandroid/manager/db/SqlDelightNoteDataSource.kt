package com.gb.vale.coursekmmandroid.manager.db

import database.UserEnttity
import com.gb.vale.coursekmmandroid.database.CourseKmmDb

class SqlDelightNoteDataSource(db: CourseKmmDb): UserDataSource {

    private val queries = db.userKmmQueries

    override suspend fun insertUser(user: UserModel) {
        queries.insertUser(user.name, user.pass)
    }

    override suspend fun getUserById(id: Long): UserModel? {
        return queries
            .getUserById(id)
            .executeAsOneOrNull()
            ?.toUser()
    }

    override suspend fun getUserValidate(name: String, pass: String): UserModel? {
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

fun UserEnttity.toUser(): UserModel {
    return UserModel(
        id = id,
        name = name,
        pass = pass
    )
}