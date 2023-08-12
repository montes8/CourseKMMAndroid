package com.gb.vale.coursekmmandroid.manager.db

import com.gb.vale.coursekmmandroid.database.CourseKmmDb
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver


internal actual fun databaseDriverFactory(): CourseKmmDb {
    val driver = NativeSqliteDriver(CourseKmmDb.Schema, "members.db")
    return CourseKmmDb(driver)
}