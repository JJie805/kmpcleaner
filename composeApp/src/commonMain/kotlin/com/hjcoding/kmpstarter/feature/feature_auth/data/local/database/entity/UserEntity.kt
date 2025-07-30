package com.hjcoding.kmpstarter.feature.feature_auth.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "user_table")
@Serializable
data class UserEntity(
    @PrimaryKey
    val id : Int,
    val account : String,
    val password : String,
    val accessToken : String
)