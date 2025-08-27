package com.hjcoding.kmpcleaner.platform

import android.content.ContentUris
import android.content.Context
import android.media.MediaMetadataRetriever
import android.provider.MediaStore
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.PhotoEntity
import com.hjcoding.kmpcleaner.feature.feature_cleaner.data.local.VideoEntity

class AndroidMediaScanner(private val context: Context) : MediaScanner {
    override fun getAllPhotos(completion: (List<PhotoEntity>) -> Unit) {
        val photos = mutableListOf<PhotoEntity>()
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT
        )
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val dateAddedColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)
            val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
            val widthColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
            val heightColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val dateAdded = it.getLong(dateAddedColumn)
                val size = it.getLong(sizeColumn)
                val width = it.getInt(widthColumn)
                val height = it.getInt(heightColumn)
                photos.add(
                    PhotoEntity(
                        id = id.toString(),
                        creationDate = dateAdded,
                        sizeInBytes = size,
                        width = width,
                        height = height
                    )
                )
            }
        }
        completion(photos)
    }

    override fun getScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit) {
        val photos = mutableListOf<PhotoEntity>()
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT
        )
        val selection = "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} = 'Screenshots'"
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val dateAddedColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)
            val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
            val widthColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
            val heightColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val dateAdded = it.getLong(dateAddedColumn)
                val size = it.getLong(sizeColumn)
                val width = it.getInt(widthColumn)
                val height = it.getInt(heightColumn)
                photos.add(
                    PhotoEntity(
                        id = id.toString(),
                        creationDate = dateAdded,
                        sizeInBytes = size,
                        width = width,
                        height = height
                    )
                )
            }
        }
        completion(photos)
    }

    override fun getNonScreenshotPhotos(completion: (List<PhotoEntity>) -> Unit) {
        val photos = mutableListOf<PhotoEntity>()
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.WIDTH,
            MediaStore.Images.Media.HEIGHT
        )
        val selection = "${MediaStore.Images.Media.BUCKET_DISPLAY_NAME} != 'Screenshots'"
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            "${MediaStore.Images.Media.DATE_ADDED} DESC"
        )
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val dateAddedColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATE_ADDED)
            val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)
            val widthColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
            val heightColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val dateAdded = it.getLong(dateAddedColumn)
                val size = it.getLong(sizeColumn)
                val width = it.getInt(widthColumn)
                val height = it.getInt(heightColumn)
                photos.add(
                    PhotoEntity(
                        id = id.toString(),
                        creationDate = dateAdded,
                        sizeInBytes = size,
                        width = width,
                        height = height
                    )
                )
            }
        }
        completion(photos)
    }

    override fun getAllVideos(completion: (List<VideoEntity>) -> Unit) {
        val videos = mutableListOf<VideoEntity>()
        val projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATE_ADDED,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.DURATION
        )
        val cursor = context.contentResolver.query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            "${MediaStore.Video.Media.DATE_ADDED} DESC"
        )
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Video.Media._ID)
            val dateAddedColumn = it.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_ADDED)
            val sizeColumn = it.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE)
            val durationColumn = it.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)
            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val dateAdded = it.getLong(dateAddedColumn)
                val size = it.getLong(sizeColumn)
                val duration = it.getLong(durationColumn)
                videos.add(
                    VideoEntity(
                        id = id.toString(),
                        creationDate = dateAdded,
                        sizeInBytes = size,
                        duration = duration
                    )
                )
            }
        }
        completion(videos)
    }

    override fun getThumbnailBitmap(forId: String, isVideo: Boolean, completion: (ImageBitmap?) -> Unit) {
        val contentResolver = context.contentResolver
        val uri = if (isVideo) {
            ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, forId.toLong())
        } else {
            ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, forId.toLong())
        }
        try {
            val thumbnail = contentResolver.loadThumbnail(uri, android.util.Size(400, 400), null)
            completion(thumbnail.asImageBitmap())
        } catch (e: Exception) {
            completion(null)
        }
    }

    override fun getAhashBitmap(forId: String, completion: (ImageBitmap?) -> Unit) {
        val contentResolver = context.contentResolver
        val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, forId.toLong())
        try {
            val thumbnail = contentResolver.loadThumbnail(uri, android.util.Size(8, 8), null)
            completion(thumbnail.asImageBitmap())
        } catch (e: Exception) {
            completion(null)
        }
    }

    override fun getDhashBitmap(forId: String, completion: (ImageBitmap?) -> Unit) {
        val contentResolver = context.contentResolver
        val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, forId.toLong())
        try {
            val thumbnail = contentResolver.loadThumbnail(uri, android.util.Size(9, 8), null)
            completion(thumbnail.asImageBitmap())
        } catch (e: Exception) {
            completion(null)
        }
    }

    override fun deletePhotos(ids: List<String>, completion: (Boolean) -> Unit) {
        val contentResolver = context.contentResolver
        try {
            val selection = "${MediaStore.Images.Media._ID} IN (${ids.joinToString(separator = ",") { "?" }})"
            val selectionArgs = ids.toTypedArray()
            val deletedRows = contentResolver.delete(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                selection,
                selectionArgs
            )
            completion(deletedRows == ids.size)
        } catch (e: Exception) {
            completion(false)
        }
    }

    override fun deleteVideos(ids: List<String>, completion: (Boolean) -> Unit) {
        val contentResolver = context.contentResolver
        try {
            val selection = "${MediaStore.Video.Media._ID} IN (${ids.joinToString(separator = ",") { "?" }})"
            val selectionArgs = ids.toTypedArray()
            val deletedRows = contentResolver.delete(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                selection,
                selectionArgs
            )
            completion(deletedRows == ids.size)
        } catch (e: Exception) {
            completion(false)
        }
    }

    override fun getKeyFrames(forVideoId: String, completion: (List<ImageBitmap?>) -> Unit) {
        val retriever = MediaMetadataRetriever()
        val uri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, forVideoId.toLong())
        retriever.setDataSource(context, uri)

        val durationString = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        val duration = durationString?.toLongOrNull() ?: 0L

        val keyFrames = mutableListOf<ImageBitmap?>()
        // Extract 5 key frames, for example
        for (i in 0..4) {
            val timeUs = (duration * 1000 * i / 4)
            val frame = retriever.getFrameAtTime(timeUs, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
            keyFrames.add(frame?.asImageBitmap())
        }

        retriever.release()
        completion(keyFrames)
    }
}