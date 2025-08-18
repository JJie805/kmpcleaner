package com.hjcoding.kmpcleaner.di

import com.hjcoding.kmpcleaner.platform.Platform
import com.hjcoding.kmpcleaner.platform.WasmJsPlatform
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { WasmJsPlatform() } bind Platform::class
}