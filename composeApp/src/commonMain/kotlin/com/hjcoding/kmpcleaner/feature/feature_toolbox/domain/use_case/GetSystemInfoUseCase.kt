package com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.repository.MediaRespository
import com.hjcoding.kmpcleaner.feature.feature_toolbox.domain.model.SystemInfo
import com.hjcoding.kmpcleaner.platform.Platform

class GetSystemInfoUseCase(
    private val platform: Platform,
    private val mediaRespository: MediaRespository
) {
    suspend operator fun invoke(): SystemInfo {
        return SystemInfo(
            cpuUsage = platform.getCpuUsage(),
            memoryUsage = platform.getMemoryUsage(),
            storageUsage = mediaRespository.getStorageUsage()
        )
    }
}