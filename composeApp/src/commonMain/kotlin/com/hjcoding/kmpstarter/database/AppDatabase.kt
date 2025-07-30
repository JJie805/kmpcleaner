package com.hjcoding.kmpstarter.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.database.dao.UserDao
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.database.entity.UserEntity

// shared/src/commonMain/kotlin/Database.kt

@Database(entities = [UserEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

