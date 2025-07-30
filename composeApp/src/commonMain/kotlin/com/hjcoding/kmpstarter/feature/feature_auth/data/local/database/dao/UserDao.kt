package com.hjcoding.kmpstarter.feature.feature_auth.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.database.entity.UserEntity

@Dao
abstract class UserDao {
    @Insert
    abstract suspend fun insert(item: UserEntity)

}


