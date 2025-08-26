package com.hjcoding.kmpcleaner.feature.feature_profile

import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileItem(val name: String, val icon: ImageVector)

data class ProfileState(
    val profileItems: List<ProfileItem> = emptyList()
)
