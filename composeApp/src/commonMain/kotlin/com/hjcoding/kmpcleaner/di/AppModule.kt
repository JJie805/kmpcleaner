package com.hjcoding.kmpcleaner.di

import GetHomePageDataUseCase
import com.hjcoding.kmpcleaner.core.data.local.preferences.UserPreferences
import com.hjcoding.kmpcleaner.core.network.ktor.HttpClientBuilder
import com.hjcoding.kmpcleaner.feature.feature_auth.data.AuthDataSourceImpl
import com.hjcoding.kmpcleaner.feature.feature_auth.data.local.TokenManager
import com.hjcoding.kmpcleaner.feature.feature_auth.data.repository.AuthRespositoryImpl
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.AuthDataSource
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.repository.AuthRespository
import com.hjcoding.kmpcleaner.feature.feature_auth.domain.use_case.GuestLoginUseCase
import com.hjcoding.kmpcleaner.feature.feature_auth.presentation.login.LoginViewModel
import com.hjcoding.kmpcleaner.feature.feature_auth.presentation.splash.SplashViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.repository.MediaRespositoryImpl
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case.*
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.calendar.CalendarViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.contacts.ContactsViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home.HomeViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.largevideos.LargeVideosViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.screenshots.ScreenshotsViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarphotos.SimilarPhotosViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarscreenshots.SimilarScreenshotsViewModel
import com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarvideos.SimilarVideosViewModel
import com.hjcoding.kmpcleaner.feature.feature_profile.ProfileViewModel
import com.hjcoding.kmpcleaner.feature.feature_toolbox.ToolboxViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


val appModule = module {
    single { TokenManager(userPreferences = get()) }
    single { HttpClientBuilder(tokenManager = get()).client}
    single { UserPreferences(dataStore = get()) }
    single { AuthDataSourceImpl(client = get()) } bind AuthDataSource::class
    single { AuthRespositoryImpl(authDataSource = get()) } bind AuthRespository::class

    single {
        MediaRespositoryImpl(mediaScanner = get(), contactsScanner = get(), deviceStorageSource = get()) } bind MediaRespository::class
    single { GetHomePageDataUseCase(
        mediaRepository = get(),
        getSimilarPhotoGroupsUseCase = get(),
        getLargeVideosUseCase = get(),
        getScreenshotsUseCase = get(),
        getSimilarVideoGroupsUseCase = get(),
        getDuplicateContactsUseCase = get()
    ) } bind GetHomePageDataUseCase::class
    single { GetSimilarPhotoGroupsUseCase(mediaRepository = get())} bind GetSimilarPhotoGroupsUseCase::class
    single { GetLargeVideosUseCase(mediaRepository = get()) } bind GetLargeVideosUseCase::class
    single { GetScreenshotsUseCase(mediaRepository = get()) } bind GetScreenshotsUseCase::class
    single { DeletePhotosUseCase(mediaRepository = get()) } bind DeletePhotosUseCase::class
    single { DeleteVideosUseCase(mediaRepository = get()) } bind DeleteVideosUseCase::class
    single { GetSimilarVideoGroupsUseCase(mediaRepository = get()) } bind GetSimilarVideoGroupsUseCase::class
    single { GetContactsUseCase() }
    single { DeleteContactsUseCase() }
    single { GetCalendarEventsUseCase() }
    single { DeleteCalendarEventsUseCase() }
    single { GuestLoginUseCase(authRespository = get(), tokenManager = get()) }

    viewModelOf(::SplashViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::ScreenshotsViewModel)
    viewModelOf(::SimilarPhotosViewModel)
    viewModelOf(::SimilarScreenshotsViewModel)
    viewModelOf(::LargeVideosViewModel)
    viewModelOf(::SimilarVideosViewModel)
    viewModelOf(::ContactsViewModel)
    viewModelOf(::CalendarViewModel)
    viewModelOf(::ToolboxViewModel)
    viewModelOf(::ProfileViewModel)
}