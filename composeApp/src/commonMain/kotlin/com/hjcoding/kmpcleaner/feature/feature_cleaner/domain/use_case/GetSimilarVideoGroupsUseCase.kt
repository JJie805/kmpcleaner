package com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.use_case

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.VideoGroup

class GetSimilarVideoGroupsUseCase {

    operator fun invoke(videos: List<Video>): List<VideoGroup> {
        if (videos.isEmpty()) {
            return emptyList()
        }
        // Placeholder logic: group by duration
        return videos.groupBy { it.duration / 1000 } // group by duration in seconds
            .values
            .filter { it.size > 1 }
            .map { VideoGroup(it) }
    }
}
