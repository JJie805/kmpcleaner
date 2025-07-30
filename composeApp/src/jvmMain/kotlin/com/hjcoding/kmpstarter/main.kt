package com.hjcoding.kmpstarter

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hjcoding.kmpstarter.di.initKoin

fun main() = application {
    initKoin {

    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "kmp_starter",
    ) {
        App()
    }
}