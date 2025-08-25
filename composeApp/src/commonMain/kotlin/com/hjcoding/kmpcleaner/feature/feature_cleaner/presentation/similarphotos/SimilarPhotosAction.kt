package com.hjcoding.kmpcleaner.feature.feature_cleaner.presentation.similarphotos

sealed interface SimilarPhotosAction {
    data class ToggleSelection(val photoId: String) : SimilarPhotosAction
    object DeleteSelected : SimilarPhotosAction
}
