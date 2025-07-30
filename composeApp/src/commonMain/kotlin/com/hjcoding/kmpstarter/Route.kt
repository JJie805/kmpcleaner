package com.hjcoding.kmpstarter

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Splash

    @Serializable
    data object Login

    @Serializable
    data object Home

    @Serializable
    data object Mine
}