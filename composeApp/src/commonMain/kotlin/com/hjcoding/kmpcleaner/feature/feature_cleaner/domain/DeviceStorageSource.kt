package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain

import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.StorageDetails

interface DeviceStorageSource{
    fun getStorageDetails(): StorageDetails
}