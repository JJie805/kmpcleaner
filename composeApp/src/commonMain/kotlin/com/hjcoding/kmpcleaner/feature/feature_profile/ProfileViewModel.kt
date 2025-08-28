package com.hjcoding.kmpcleaner.feature.feature_profile

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Feedback
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpcleaner.platform.Platform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ProfileViewModel(platform: Platform) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState())
    val state = _state
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ProfileState(
                profileItems = listOf(
                    ProfileItem("用户协议", Icons.Default.Book),
                    ProfileItem("隐私政策", Icons.Default.PrivacyTip),
                    ProfileItem("意见反馈", Icons.Default.Feedback),
                    ProfileItem("版本", Icons.Default.Info, value = platform.appVersionName)
                )
            )
        )

    fun onAction(action: ProfileAction) {
        // No actions yet
    }
}
