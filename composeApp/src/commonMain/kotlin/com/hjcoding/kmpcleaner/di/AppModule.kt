package com.hjcoding.kmpcleaner.di

import GetHomePageDataUseCase
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.memory.MemoryCache
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
import com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.use_case.GetSystemInfoUseCase
import com.hjcoding.kmpcleaner.feature.feature_toolbox.presentation.ToolboxViewModel
import com.hjcoding.kmpcleaner.platform.MediaFetcherFactory
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


val appModule = module {

    single {
        ImageLoader.Builder(
            // Koin 会在这里暂停，去寻找一个能提供 PlatformContext 的配方
            context = get<PlatformContext>()
        ).apply {
            components {
                add(get<MediaFetcherFactory>())
            }
            // ... Coil 的其他配置，如内存缓存、磁盘缓存等 ...
            memoryCache { MemoryCache.Builder().maxSizePercent(get(), 0.25).build() }

        }.build()
    }
    single { TokenManager(userPreferences = get()) }
    single { HttpClientBuilder(tokenManager = get()).client}
    single { UserPreferences(dataStore = get()) }
    single { AuthDataSourceImpl(client = get()) } bind AuthDataSource::class
    single { AuthRespositoryImpl(authDataSource = get()) } bind AuthRespository::class

    single {
        MediaRespositoryImpl(mediaScanner = get(),
            contactsScanner = get(),
            deviceStorageSource = get()) } bind MediaRespository::class
    single { GetHomePageDataUseCase(
        mediaRepository = get(),
        getSimilarPhotoGroupsUseCase = get(),
        getLargeVideosUseCase = get(),
        getScreenshotsUseCase = get(),
        getSimilarVideoGroupsUseCase = get(),
        getDuplicateContactsUseCase = get(),
        getInvalidContactsUseCase = get(),
        getPastCalendarEventsUseCase = get()) }
    single { GetSimilarPhotoGroupsUseCase(mediaRepository = get())}
    single { GetLargeVideosUseCase(mediaRepository = get()) }
    single { GetScreenshotsUseCase(mediaRepository = get()) }
    single { GetSimilarVideoGroupsUseCase(mediaRepository = get()) }
    single { GetDuplicateContactsUseCase(contactsScanner = get()) }
    single { GetInvalidContactsUseCase(contactsScanner = get()) }
    single { GetPastCalendarEventsUseCase(calendarScanner = get()) }
    single { GetSystemInfoUseCase(platform = get(), mediaRespository = get()) }

    single { DeletePhotosUseCase(mediaRepository = get()) }
    single { DeleteVideosUseCase(mediaRepository = get()) }

    single { GetContactsUseCase() }
    single { DeleteContactsUseCase() }
    single { GetCalendarEventsUseCase() }
    single { DeleteCalendarEventsUseCase() }
    single { GetDuplicatePastEventsUseCase(getPastCalendarEventsUseCase = get()) }
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