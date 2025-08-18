package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.home

sealed interface HomeAction {
    data object Refresh : HomeAction // 下拉刷新或重试
}