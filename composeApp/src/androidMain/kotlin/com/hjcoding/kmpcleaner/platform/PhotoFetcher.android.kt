package com.hjcoding.kmpcleaner.platform

import android.content.ContentUris
import android.graphics.Bitmap
import android.os.Build
import android.provider.MediaStore
import android.util.Size
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Media
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Photo
import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Video
import com.hjcoding.kmpcleaner.util.AppContext
import java.io.ByteArrayOutputStream

actual fun getMediaThumbnailData(media: Media): ByteArray? {
    val context = AppContext.get()
    val id = media.id.toLong()
    val uri = when (media) {
        is Photo -> ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
        is Video -> ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id)
    }

    return try {
        val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            context.contentResolver.loadThumbnail(uri, Size(256, 256), null)
        } else {
            @Suppress("DEPRECATION")
            when (media) {
                is Photo -> MediaStore.Images.Thumbnails.getThumbnail(context.contentResolver, id, MediaStore.Images.Thumbnails.MINI_KIND, null)
                is Video -> MediaStore.Video.Thumbnails.getThumbnail(context.contentResolver, id, MediaStore.Video.Thumbnails.MINI_KIND, null)
            }
        }
        val stream = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.JPEG, 80, stream)
        stream.toByteArray()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}