package com.hjcoding.kmpstarter.di

import com.hjcoding.kmpstarter.platform.Platform
import com.hjcoding.kmpstarter.platform.WasmJsPlatform
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single { WasmJsPlatform() } bind Platform::class
}