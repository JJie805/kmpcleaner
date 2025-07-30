package com.hjcoding.kmpstarter.di

import com.hjcoding.kmpstarter.core.data.local.preferences.UserPreferences
import com.hjcoding.kmpstarter.core.network.ktor.HttpClientBuilder
import com.hjcoding.kmpstarter.feature.feature_auth.data.AuthDataSourceImpl
import com.hjcoding.kmpstarter.feature.feature_auth.data.local.TokenManager
import com.hjcoding.kmpstarter.feature.feature_auth.data.repository.AuthRespositoryImpl
import com.hjcoding.kmpstarter.feature.feature_auth.domain.AuthDataSource
import com.hjcoding.kmpstarter.feature.feature_auth.domain.repository.AuthRespository
import com.hjcoding.kmpstarter.feature.feature_auth.domain.use_case.GuestLoginUseCase
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.home.HomeViewModel
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.login.LoginViewModel
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.mine.MineViewModel
import com.hjcoding.kmpstarter.feature.feature_auth.presentation.splash.SplashViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


val appModule = module {
    single { TokenManager(userPreferences = get()) }
    single { HttpClientBuilder(tokenManager = get()).client}
    single { UserPreferences(dataStore = get()) }
    single { AuthDataSourceImpl(client = get()) } bind AuthDataSource::class
    single { AuthRespositoryImpl(authDataSource = get()) } bind AuthRespository::class
    single { GuestLoginUseCase(authRespository = get(), tokenManager = get()) }
    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::MineViewModel)
}