package com.hjcoding.kmpcleaner.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.InProgress: ImageVector
    get() {
        if (_InProgress != null) {
            return _InProgress!!
        }
        _InProgress = ImageVector.Builder(
            name = "InProgress",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFE),
                        1f to Color(0xFFEBEBF0)
                    ),
                    start = Offset(195.31f, 198.78f),
                    end = Offset(195.31f, 231.33f)
                )
            ) {
                moveTo(285.8f, 212.32f)
                curveToRelative(0f, 5.39f, -33.06f, 4.07f, -42.54f, 5.41f)
                curveToRelative(-15.9f, 2.24f, 18.36f, 12.35f, -39.4f, 13.48f)
                curveToRelative(-48.31f, 0.94f, -100.33f, -3.46f, -99.02f, -14.84f)
                curveToRelative(1.31f, -11.38f, 39.74f, -17.58f, 88.39f, -17.58f)
                curveToRelative(48.66f, 0f, 92.56f, 2.21f, 92.56f, 13.54f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(311.89f, 107.31f),
                    end = Offset(311.89f, 146.01f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(311.2f, 107.31f)
                curveToRelative(7.75f, 0f, 14.4f, 4.06f, 17.2f, 9.83f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.32f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineToRelative(-35.88f)
                curveToRelative(-7.61f, 0f, -13.78f, -6.17f, -13.78f, -13.78f)
                verticalLineToRelative(-1.32f)
                curveToRelative(0f, -7.61f, 6.17f, -13.78f, 13.78f, -13.78f)
                horizontalLineToRelative(0.05f)
                curveToRelative(2.8f, -5.77f, 9.44f, -9.83f, 17.2f, -9.83f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x54FCFCFC),
                        1f to Color(0xFFEEEEF6)
                    ),
                    start = Offset(129.03f, 195.49f),
                    end = Offset(129.03f, 103.87f)
                )
            ) {
                moveTo(143.39f, 103.87f)
                horizontalLineToRelative(-28.72f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(89.61f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(28.72f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-89.61f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(159.17f, 208.25f),
                    end = Offset(159.17f, 125.37f)
                )
            ) {
                moveTo(184.1f, 130.2f)
                horizontalLineToRelative(-49.86f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.5f, 1.5f)
                verticalLineToRelative(79.14f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.5f, 1.5f)
                horizontalLineToRelative(49.86f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.5f, -1.5f)
                verticalLineTo(131.7f)
                arcToRelative(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.5f, -1.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(172.25f, 159.85f),
                    end = Offset(172.25f, 76.97f)
                )
            ) {
                moveTo(181.88f, 81.8f)
                horizontalLineToRelative(-19.26f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(81.14f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(19.26f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineTo(82.3f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(114.2f, 210.94f),
                    end = Offset(114.2f, 118.5f)
                )
            ) {
                moveTo(124.83f, 123.88f)
                horizontalLineToRelative(-21.24f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(90.61f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(21.24f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-90.61f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(249.25f, 172.15f),
                    end = Offset(249.25f, 73.93f)
                )
            ) {
                moveTo(274.67f, 79.65f)
                horizontalLineToRelative(-50.84f)
                verticalLineToRelative(97.34f)
                horizontalLineToRelative(50.84f)
                verticalLineTo(79.65f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00FBFBFF),
                        1f to Color(0xFFFDFDFF)
                    ),
                    start = Offset(249.75f, 196.54f),
                    end = Offset(249.75f, 88.59f)
                )
            ) {
                moveTo(238.16f, 90.18f)
                horizontalLineToRelative(-5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineTo(196.04f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineTo(90.68f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00FBFBFF),
                        1f to Color(0xFFFDFDFF)
                    ),
                    start = Offset(263.52f, 196.54f),
                    end = Offset(263.52f, 88.59f)
                )
            ) {
                moveTo(251.93f, 90.18f)
                horizontalLineToRelative(-5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineTo(196.04f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineTo(90.68f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00FBFBFF),
                        1f to Color(0xFFFDFDFF)
                    ),
                    start = Offset(277.29f, 196.54f),
                    end = Offset(277.29f, 88.59f)
                )
            ) {
                moveTo(265.7f, 90.18f)
                horizontalLineToRelative(-5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineTo(196.04f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(5.36f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineTo(90.68f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(195.23f, 191.21f),
                    end = Offset(195.23f, 61.57f)
                )
            ) {
                moveTo(211.12f, 69.12f)
                horizontalLineToRelative(-31.78f)
                verticalLineToRelative(128.47f)
                horizontalLineToRelative(31.78f)
                verticalLineTo(69.12f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(219.06f, 210.94f),
                    end = Offset(219.06f, 118.5f)
                )
            ) {
                moveTo(230.19f, 123.88f)
                horizontalLineToRelative(-22.24f)
                verticalLineToRelative(91.61f)
                horizontalLineToRelative(22.24f)
                verticalLineToRelative(-91.61f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.23f, 77.55f),
                    end = Offset(195.23f, 80.19f)
                )
            ) {
                moveTo(204.77f, 77.55f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.23f, 86.2f),
                    end = Offset(195.23f, 88.83f)
                )
            ) {
                moveTo(204.77f, 86.2f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.44f, 94.99f),
                    end = Offset(195.44f, 97.63f)
                )
            ) {
                moveTo(204.97f, 94.99f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.23f, 102.03f),
                    end = Offset(195.23f, 104.67f)
                )
            ) {
                moveTo(204.77f, 102.03f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.23f, 110.68f),
                    end = Offset(195.23f, 113.31f)
                )
            ) {
                moveTo(204.77f, 110.68f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(195.44f, 119.47f),
                    end = Offset(195.44f, 122.11f)
                )
            ) {
                moveTo(204.97f, 119.47f)
                horizontalLineToRelative(-19.07f)
                verticalLineToRelative(2.64f)
                horizontalLineToRelative(19.07f)
                verticalLineToRelative(-2.64f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00EEEEF7),
                        1f to Color(0xFFF0F0F5)
                    ),
                    start = Offset(195.23f, 72.97f),
                    end = Offset(195.23f, 65.53f)
                )
            ) {
                moveTo(201.59f, 65.96f)
                horizontalLineToRelative(-12.71f)
                verticalLineToRelative(7.37f)
                horizontalLineToRelative(12.71f)
                verticalLineToRelative(-7.37f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(212.91f, 202.05f),
                    end = Offset(216.69f, 193.13f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(210.89f, 194.56f)
                horizontalLineToRelative(4.17f)
                lineToRelative(10.28f, -4.17f)
                reflectiveCurveToRelative(7.3f, -3.09f, 6.7f, 2.78f)
                curveToRelative(-0.6f, 5.87f, -1.64f, 13.75f, -1.64f, 13.75f)
                reflectiveCurveToRelative(-3.28f, -1.54f, -5.06f, -1.08f)
                curveToRelative(-1.79f, 0.46f, -0.6f, -9.42f, -0.6f, -9.42f)
                reflectiveCurveToRelative(-14.6f, 7.26f, -15.94f, 6.33f)
                curveToRelative(-1.34f, -0.93f, -1.64f, -7.41f, -1.64f, -7.41f)
                lineToRelative(3.72f, -0.77f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(213.38f, 164.93f),
                    end = Offset(213.53f, 170.63f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(210.77f, 174.3f)
                curveToRelative(0.26f, -1.58f, 0.91f, -2.15f, 1.96f, -1.72f)
                curveToRelative(1.65f, 0.68f, 3.18f, -1.51f, 3.89f, -3.76f)
                curveToRelative(1.46f, -4.56f, 1.37f, -5.86f, -0.71f, -6.71f)
                curveToRelative(-2.08f, -0.85f, -4.31f, -1.64f, -5.7f, 0.67f)
                curveToRelative(-1.39f, 2.31f, -2.09f, 3.74f, -2.25f, 5.64f)
                curveToRelative(-0.16f, 1.91f, -1.65f, 3.56f, -2.35f, 3.81f)
                curveToRelative(-0.47f, 0.17f, 1.25f, 0.86f, 5.15f, 2.07f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(207.6f, 169.94f)
                curveToRelative(1f, -3.75f, -0.63f, -7.17f, 0.44f, -8.94f)
                curveToRelative(0.72f, -1.18f, 1.52f, -1.56f, 2.4f, -1.14f)
                curveToRelative(1.57f, -2.11f, 3.4f, -2.3f, 5.47f, -0.57f)
                curveToRelative(0.52f, 0.43f, 0.98f, 0.77f, 1.61f, 0.94f)
                curveToRelative(1.14f, 0.3f, 1.04f, 0.33f, 1.77f, 0.65f)
                curveToRelative(0.97f, 0.43f, 1.39f, 1.06f, 1.47f, 1.89f)
                curveToRelative(0.1f, 1.02f, -1.03f, 2.3f, -2.14f, 2.3f)
                curveToRelative(-1.41f, 0f, -1.59f, -0.5f, -2.47f, -0.5f)
                curveToRelative(-0.59f, 0f, -1.8f, 0.85f, -3.63f, 2.53f)
                lineToRelative(0.08f, -0.69f)
                curveToRelative(0.07f, -1.41f, -0.3f, -2.08f, -1.11f, -2.03f)
                curveToRelative(-0.81f, 0.05f, -1.2f, 0.63f, -1.16f, 1.73f)
                curveToRelative(-0.03f, 1.33f, -0.23f, 2.31f, -0.61f, 2.96f)
                curveToRelative(-0.37f, 0.64f, -1.09f, 0.93f, -2.14f, 0.87f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFAF94))) {
                moveToRelative(217.43f, 181.45f)
                lineToRelative(5.08f, 7.17f)
                curveToRelative(1.46f, 0.8f, 2.78f, 0.76f, 3.95f, -0.12f)
                curveToRelative(1.76f, -1.33f, 2.82f, -5.47f, 4.29f, -5.47f)
                curveToRelative(1.47f, 0f, 2.07f, 2.22f, 2.07f, 2.22f)
                curveToRelative(-0.39f, 0f, -3.32f, 7.28f, -5.94f, 7.04f)
                curveToRelative(-3.2f, -0.29f, -7.58f, -1.49f, -7.83f, -1.9f)
                curveToRelative(-0.45f, -0.74f, -5.4f, -7.66f, -5.4f, -7.66f)
                lineToRelative(3.77f, -1.28f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5555E7))) {
                moveTo(209.34f, 173.32f)
                curveToRelative(2.91f, 1.58f, 4.83f, 2.82f, 5.76f, 3.74f)
                curveToRelative(1f, 0.98f, 1.97f, 2.59f, 2.9f, 4.81f)
                curveToRelative(0f, 0f, -0.79f, 3.07f, -2.05f, 3.36f)
                curveToRelative(-1.26f, 0.29f, -6.62f, -3.8f, -6.62f, -3.8f)
                verticalLineToRelative(-8.1f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(235.06f, 181.19f)
                lineToRelative(-5.59f, 4.21f)
                curveToRelative(0.87f, 1.49f, 1.43f, 2.18f, 1.69f, 2.06f)
                curveToRelative(0.39f, -0.18f, 6.76f, -4.03f, 6.76f, -4.03f)
                lineToRelative(-2.85f, -2.24f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF9F9F9)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(234.83f, 181.74f)
                curveToRelative(-0.09f, 0.02f, -1.7f, 1.22f, -4.82f, 3.61f)
                curveToRelative(0.68f, 0.98f, 1.04f, 1.51f, 1.07f, 1.6f)
                curveToRelative(0.05f, 0.13f, 5.98f, -3.55f, 5.98f, -3.55f)
                curveToRelative(0f, 0f, -2.09f, -1.68f, -2.22f, -1.65f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB8A3))) {
                moveToRelative(217.53f, 184.16f)
                lineToRelative(2.88f, 6.26f)
                curveToRelative(2.38f, 0.21f, 4.27f, 0.03f, 5.67f, -0.53f)
                curveToRelative(2.1f, -0.84f, 3.33f, -5.57f, 5.56f, -3.95f)
                reflectiveCurveToRelative(-4.88f, 7.47f, -6.26f, 7.93f)
                curveToRelative(-1.38f, 0.46f, -4.81f, 2.67f, -7.92f, -0.72f)
                curveToRelative(-3.11f, -3.39f, -7.05f, -7.6f, -7.05f, -7.6f)
                lineToRelative(7.12f, -1.38f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7575CE),
                        1f to Color(0xFF7171D8)
                    ),
                    start = Offset(203.78f, 204.98f),
                    end = Offset(207.93f, 198.83f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(209.06f, 197.02f)
                lineToRelative(1.79f, 2.86f)
                lineToRelative(10.67f, -3.38f)
                arcToRelative(8.33f, 8.33f, 0f, isMoreThanHalf = false, isPositiveArc = true, 6.99f, 0.85f)
                curveToRelative(1.86f, 1.18f, 3.06f, 3.06f, 0.37f, 5.84f)
                curveToRelative(-5.36f, 5.56f, -8.94f, 2.55f, -8.94f, 2.55f)
                reflectiveCurveToRelative(-18.03f, 8.56f, -21.01f, 4.36f)
                curveToRelative(-2.98f, -4.21f, -3.13f, -6.31f, -3.13f, -6.31f)
                reflectiveCurveToRelative(11.48f, -7.21f, 13.27f, -6.76f)
                close()
            }
            path(fill = SolidColor(Color(0xFFCDCDE1))) {
                moveTo(231.3f, 207.18f)
                reflectiveCurveToRelative(4.72f, 3.13f, -0.88f, 4.62f)
                curveToRelative(-5.6f, 1.49f, -9.72f, -0.6f, -9.72f, -0.6f)
                reflectiveCurveToRelative(-4.86f, 0f, -4.86f, -2.54f)
                curveToRelative(0f, -2.54f, 1.62f, -2.83f, 1.62f, -2.83f)
                lineToRelative(5.01f, 0.75f)
                reflectiveCurveToRelative(6.04f, -1.64f, 8.84f, 0.6f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(205.4f, 171.76f)
                arcToRelative(1.74f, 1.74f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.91f, 0f)
                curveToRelative(0.94f, 0.25f, 3.06f, 0.93f, 3.51f, 1.96f)
                curveToRelative(0.59f, 1.33f, 2.65f, 3.4f, 2.65f, 3.4f)
                reflectiveCurveToRelative(2.79f, 2.81f, 2.2f, 4.74f)
                curveToRelative(-0.59f, 1.92f, -2.79f, 4.14f, -2.79f, 4.14f)
                reflectiveCurveToRelative(0.18f, 9.26f, -1.76f, 11.97f)
                curveToRelative(-1.95f, 2.71f, -12.38f, 7.92f, -14.11f, 7.27f)
                curveToRelative(-1.73f, -0.65f, -2.01f, -4.56f, -1.73f, -8.32f)
                curveToRelative(0.27f, -3.76f, 0.99f, -22.4f, 11.13f, -25.16f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6464F0)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(210.06f, 175.36f)
                reflectiveCurveToRelative(9.44f, 6.99f, 7.73f, 9.95f)
                curveToRelative(0f, 0f, -5.72f, 2.8f, -6.96f, 2.64f)
                curveToRelative(-1.24f, -0.16f, -6.03f, -5.6f, -7.27f, -6.06f)
                curveToRelative(-1.24f, -0.47f, -1.86f, -8.86f, 6.5f, -6.53f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFAF94))) {
                moveTo(229.85f, 185.32f)
                curveToRelative(0.57f, -0.74f, 0.86f, -1.47f, 0.65f, -1.64f)
                curveToRelative(-0.22f, -0.17f, -0.86f, 0.29f, -1.43f, 1.02f)
                curveToRelative(-0.57f, 0.74f, -0.86f, 1.47f, -0.65f, 1.64f)
                curveToRelative(0.22f, 0.17f, 0.86f, -0.29f, 1.43f, -1.02f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEFAB23))) {
                moveTo(155.09f, 180.42f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.76f, 0f)
                verticalLineToRelative(26.39f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.76f, 0f)
                verticalLineToRelative(-26.39f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8B837),
                        1f to Color(0xFFFFDE9B)
                    ),
                    center = Offset(144.21f, 147.54f),
                    radius = 14.49f
                )
            ) {
                moveTo(154.28f, 166.34f)
                curveToRelative(6.32f, 0f, 2.53f, 9.83f, 0.74f, 12.98f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.05f, 0.01f)
                curveToRelative(4.38f, 0.32f, 14.89f, 2.37f, 11.79f, 7.3f)
                curveToRelative(-3.19f, 5.08f, -10.1f, -2.53f, -12.65f, -5.84f)
                lineToRelative(-0.06f, 0.08f)
                curveToRelative(-2.6f, 3.35f, -9.42f, 10.79f, -12.59f, 5.75f)
                curveToRelative(-3.1f, -4.93f, 7.41f, -6.98f, 11.79f, -7.3f)
                curveToRelative(0.08f, -0.02f, 0.19f, -0.03f, 0.35f, -0.04f)
                curveToRelative(-1.69f, -3.19f, -5.95f, -12.95f, 0.58f, -12.95f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEFAB23))) {
                moveTo(265.63f, 193.1f)
                arcToRelative(0.34f, 0.34f, 0f, isMoreThanHalf = true, isPositiveArc = false, -0.68f, 0f)
                verticalLineToRelative(10.46f)
                arcToRelative(0.34f, 0.34f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.68f, 0f)
                verticalLineToRelative(-10.46f)
                close()
            }
            path(
                fill = Brush.radialGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8B837),
                        1f to Color(0xFFFFDE9B)
                    ),
                    center = Offset(261.4f, 180.46f),
                    radius = 5.61f
                )
            ) {
                moveTo(265.31f, 187.54f)
                curveToRelative(2.45f, 0f, 0.98f, 3.89f, 0.29f, 5.14f)
                lineToRelative(0.02f, 0f)
                curveToRelative(1.7f, 0.13f, 5.76f, 0.94f, 4.57f, 2.89f)
                curveToRelative(-1.24f, 2.01f, -3.91f, -1f, -4.9f, -2.31f)
                curveToRelative(-0.99f, 1.31f, -3.66f, 4.32f, -4.9f, 2.31f)
                curveToRelative(-1.19f, -1.94f, 2.82f, -2.75f, 4.53f, -2.89f)
                lineToRelative(0.03f, -0f)
                arcToRelative(0.71f, 0.71f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.13f, -0.02f)
                curveToRelative(-0.65f, -1.26f, -2.3f, -5.13f, 0.22f, -5.13f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(111.01f, 76.52f),
                    end = Offset(111.01f, 115.22f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(110.32f, 76.52f)
                curveToRelative(7.75f, 0f, 14.4f, 4.06f, 17.2f, 9.83f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.32f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineTo(93.07f)
                curveToRelative(-7.61f, 0f, -13.78f, -6.17f, -13.78f, -13.78f)
                verticalLineToRelative(-1.32f)
                curveToRelative(0f, -7.61f, 6.17f, -13.78f, 13.78f, -13.78f)
                horizontalLineToRelative(0.05f)
                curveToRelative(2.8f, -5.77f, 9.44f, -9.83f, 17.2f, -9.83f)
                close()
            }
        }.build()

        return _InProgress!!
    }

@Suppress("ObjectPropertyName")
private var _InProgress: ImageVector? = null
