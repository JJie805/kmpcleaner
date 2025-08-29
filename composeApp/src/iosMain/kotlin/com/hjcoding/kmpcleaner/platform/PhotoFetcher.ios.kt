package com.hjcoding.kmpcleaner.platform

import com.hjcoding.kmpcleaner.feature.feature_cleaner.domain.model.Media
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.CoreGraphics.CGSizeMake
import platform.Foundation.NSData
import platform.Photos.PHAsset
import platform.Photos.PHImageContentMode
import platform.Photos.PHImageManager
import platform.Photos.PHImageRequestOptions
import platform.Photos.PHImageRequestOptionsDeliveryMode
import platform.Photos.PHImageRequestOptionsResizeMode
import platform.UIKit.UIImage
import platform.UIKit.UIImageJPEGRepresentation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlinx.cinterop.memcpy

actual suspend fun getMediaThumbnailData(media: Media): ByteArray? {
    return suspendCoroutine { continuation ->
        val imageManager = PHImageManager.defaultManager()
        val options = PHImageRequestOptions().apply {
            resizeMode = PHImageRequestOptionsResizeMode.PHImageRequestOptionsResizeModeFast
            deliveryMode = PHImageRequestOptionsDeliveryMode.PHImageRequestOptionsDeliveryModeHighQualityFormat
            isNetworkAccessAllowed = true
        }

        val asset = PHAsset.fetchAssetsWithLocalIdentifiers(listOf(media.id), null).firstObject as? PHAsset
        if (asset == null) {
            continuation.resume(null)
            return@suspendCoroutine
        }

        imageManager.requestImageForAsset(
            asset,
            CGSizeMake(256.0, 256.0),
            PHImageContentMode.PHImageContentModeAspectFill,
            options
        ) { image, _ ->
            if (image is UIImage) {
                val jpegData = UIImageJPEGRepresentation(image, 0.8)
                continuation.resume(jpegData?.toByteArray())
            } else {
                continuation.resume(null)
            }
        }
    }
}

private fun NSData.toByteArray(): ByteArray = ByteArray(this.length.toInt()).apply {
    usePinned { pinned ->
        memcpy(pinned.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
    }
}