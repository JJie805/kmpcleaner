package com.hjcoding.kmpcleaner.core.util

import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.decodeToImageBitmap

fun byteArraytoImageBitmap(byteArray : ByteArray): ImageBitmap {
    return byteArray.decodeToImageBitmap()
}