package com.gb.vale.coursekmmandroid.manager.db


import android.content.Context
import com.gb.vale.coursekmmandroid.database.CourseKmmDb
import com.squareup.sqldelight.android.AndroidSqliteDriver

lateinit var appContext: Context

internal actual fun databaseDriverFactory(): CourseKmmDb {
    val driver = AndroidSqliteDriver(CourseKmmDb.Schema, appContext, "courseKmm.db")
    return CourseKmmDb(driver)
}
