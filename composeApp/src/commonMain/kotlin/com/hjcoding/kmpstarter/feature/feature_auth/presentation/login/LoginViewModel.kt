package com.hjcoding.kmpstarter.feature.feature_auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjcoding.kmpstarter.core.domain.onError
import com.hjcoding.kmpstarter.core.domain.onSuccess
import com.hjcoding.kmpstarter.feature.feature_auth.domain.repository.AuthRespository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(val authRespository: AuthRespository) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state
        .onStart {
            fetchConfig()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    private fun fetchConfig() = viewModelScope.launch {
        authRespository.getConfigValue("isVisitor")
            .onSuccess { configValue ->
                println("getConfigValue: $configValue")
            }.onError {
                println("getConfigValue: $it")
            }
    }

    fun onAction(action: LoginAction) {

    }
}