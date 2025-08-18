package com.hjcoding.kmpcleaner.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.EmptyPage: ImageVector
    get() {
        if (_EmptyPage != null) {
            return _EmptyPage!!
        }
        _EmptyPage = ImageVector.Builder(
            name = "EmptyPage",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x00FCFCFE),
                        1f to Color(0xFFFAFAFA)
                    ),
                    start = Offset(199.56f, 230.27f),
                    end = Offset(199.56f, 166.5f)
                )
            ) {
                moveTo(199.56f, 222.9f)
                curveToRelative(70.8f, 0f, 128.19f, -13.81f, 128.19f, -30.84f)
                reflectiveCurveToRelative(-57.39f, -30.84f, -128.19f, -30.84f)
                curveToRelative(-70.8f, 0f, -128.19f, 13.81f, -128.19f, 30.84f)
                reflectiveCurveToRelative(57.39f, 30.84f, 128.19f, 30.84f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(98.47f, 93.03f),
                    end = Offset(94.6f, 148.4f)
                ),
                fillAlpha = 0.182f,
                strokeAlpha = 0.182f
            ) {
                moveTo(97.49f, 92.96f)
                curveToRelative(11.06f, 0.77f, 20.14f, 7.24f, 23.56f, 15.78f)
                lineToRelative(2.03f, 0.14f)
                curveToRelative(10.87f, 0.76f, 19.06f, 10.19f, 18.3f, 21.05f)
                lineToRelative(-0.14f, 1.96f)
                curveToRelative(-0.76f, 10.87f, -10.19f, 19.06f, -21.05f, 18.3f)
                lineToRelative(-51.17f, -3.58f)
                curveToRelative(-10.87f, -0.76f, -19.06f, -10.19f, -18.3f, -21.05f)
                lineToRelative(0.14f, -1.96f)
                curveToRelative(0.76f, -10.87f, 10.19f, -19.06f, 21.05f, -18.3f)
                lineToRelative(0.05f, 0f)
                curveToRelative(4.57f, -7.98f, 14.46f, -13.12f, 25.53f, -12.35f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(303f, 160.35f)
                horizontalLineToRelative(1.06f)
                curveToRelative(0.44f, 0f, 0.79f, 0.35f, 0.79f, 0.79f)
                verticalLineToRelative(10.75f)
                arcToRelative(0.79f, 0.79f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.79f, 0.79f)
                horizontalLineToRelative(-1.06f)
                arcToRelative(0.79f, 0.79f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.79f, -0.79f)
                verticalLineToRelative(-10.75f)
                curveToRelative(0f, -0.44f, 0.35f, -0.79f, 0.79f, -0.79f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(304.4f, 142.73f),
                    end = Offset(304.4f, 165.63f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(301.64f, 145.81f)
                curveToRelative(-2.22f, 4.45f, -9.87f, 18.12f, 0.85f, 19.65f)
                curveToRelative(10.71f, 1.53f, 10.24f, -7.57f, 8.36f, -10.82f)
                curveToRelative(-1.88f, -3.26f, -4f, -5.08f, -4f, -8.83f)
                curveToRelative(0f, -3.75f, -2.98f, -4.46f, -5.2f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(94.22f, 191.08f)
                horizontalLineToRelative(1.36f)
                curveToRelative(0.57f, 0f, 1.03f, 0.46f, 1.03f, 1.03f)
                verticalLineToRelative(13.9f)
                arcToRelative(1.03f, 1.03f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.03f, 1.03f)
                horizontalLineToRelative(-1.36f)
                arcToRelative(1.03f, 1.03f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.03f, -1.03f)
                verticalLineToRelative(-13.9f)
                curveToRelative(0f, -0.57f, 0.46f, -1.03f, 1.03f, -1.03f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(96.03f, 168.28f),
                    end = Offset(96.03f, 197.92f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(92.45f, 172.27f)
                curveToRelative(-2.87f, 5.77f, -12.77f, 23.45f, 1.1f, 25.43f)
                curveToRelative(13.86f, 1.98f, 13.25f, -9.79f, 10.81f, -14f)
                curveToRelative(-2.43f, -4.21f, -5.18f, -6.57f, -5.18f, -11.43f)
                curveToRelative(0f, -4.86f, -3.86f, -5.77f, -6.73f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(310.17f, 93.1f),
                    end = Offset(308.32f, 119.55f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(311.08f, 93.17f)
                curveToRelative(5.5f, 0.38f, 9.98f, 3.72f, 11.47f, 8.06f)
                curveToRelative(4.59f, 1.03f, 7.87f, 5.29f, 7.53f, 10.13f)
                curveToRelative(-0.37f, 5.34f, -5.01f, 9.36f, -10.35f, 8.99f)
                lineToRelative(-22.85f, -1.6f)
                curveToRelative(-5.34f, -0.37f, -9.37f, -5.01f, -8.99f, -10.34f)
                curveToRelative(0.37f, -5.34f, 5f, -9.37f, 10.34f, -8.99f)
                lineToRelative(0.41f, 0.03f)
                curveToRelative(2.11f, -4.03f, 6.97f, -6.66f, 12.43f, -6.28f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFDDDDE7)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(188.22f, 83.7f)
                verticalLineToRelative(81.3f)
                lineToRelative(80.58f, 10.88f)
                verticalLineToRelative(-72.79f)
                lineToRelative(-80.58f, -19.4f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFECECF4)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(128.11f, 103.09f)
                lineToRelative(60.11f, -19.4f)
                verticalLineToRelative(71.25f)
                lineToRelative(-60.11f, 21.9f)
                verticalLineToRelative(-73.75f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF6F6F9),
                        1f to Color(0xFFE4E4EB)
                    ),
                    start = Offset(147.78f, 152.27f),
                    end = Offset(199f, 167.68f)
                )
            ) {
                moveTo(128.11f, 103.09f)
                verticalLineToRelative(73.75f)
                lineToRelative(81.71f, 24.62f)
                verticalLineToRelative(-77.65f)
                lineToRelative(-81.71f, -20.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEF3),
                        1f to Color(0xFFDDDDE5)
                    ),
                    start = Offset(239.31f, 189.83f),
                    end = Offset(239.31f, 128.36f)
                )
            ) {
                moveTo(209.82f, 123.8f)
                verticalLineToRelative(77.65f)
                lineToRelative(58.98f, -25.58f)
                verticalLineToRelative(-72.79f)
                lineToRelative(-58.98f, 20.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE3E3EA)
                    ),
                    start = Offset(140.18f, 124.01f),
                    end = Offset(160.64f, 147.1f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(128.11f, 103.09f)
                lineToRelative(-19.74f, 29.24f)
                lineToRelative(78.04f, 22.61f)
                lineToRelative(23.42f, -31.14f)
                lineToRelative(-81.71f, -20.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFECECF1),
                        1f to Color(0xFFEBEDF3)
                    ),
                    start = Offset(264.79f, 121.77f),
                    end = Offset(245.78f, 150.44f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(209.82f, 123.8f)
                lineToRelative(19.56f, 33.81f)
                lineToRelative(61.25f, -26.84f)
                lineToRelative(-21.83f, -27.68f)
                lineToRelative(-58.98f, 20.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(258.6f, 148.29f),
                    end = Offset(261.8f, 132.7f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(263.84f, 133.13f)
                curveToRelative(-4.15f, 4.54f, -6.64f, 7.35f, -7.47f, 8.42f)
                curveToRelative(-0.33f, 0.47f, 1.03f, 1.78f, 4.08f, 3.94f)
                curveToRelative(4.22f, -0.27f, 6f, -0.05f, 5.35f, 0.66f)
                curveToRelative(-0.43f, 0.44f, -2.05f, 1.74f, -2.61f, 1f)
                curveToRelative(-0.38f, -0.49f, -1.9f, -0.81f, -4.57f, -0.95f)
                curveToRelative(-5.22f, -0.18f, -6.9f, -2.23f, -5.04f, -6.14f)
                curveToRelative(1.86f, -3.92f, 3.93f, -7.22f, 6.21f, -9.92f)
                lineToRelative(3.83f, 2.58f)
                lineToRelative(0.22f, 0.42f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(265.7f, 120.01f),
                    end = Offset(270.95f, 125.92f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(264.62f, 118.91f)
                curveToRelative(-0.66f, 3.32f, -0.35f, 5.28f, 0.93f, 5.86f)
                curveToRelative(1.67f, 0.7f, 0.06f, 2.35f, -0.28f, 2.53f)
                curveToRelative(-0.22f, 0.12f, -0.03f, 0.46f, 0.6f, 1.02f)
                curveToRelative(1.06f, 0.56f, 1.84f, 0.79f, 2.34f, 0.68f)
                curveToRelative(0.5f, -0.12f, 1.11f, -0.68f, 1.82f, -1.7f)
                curveToRelative(-1.33f, -0.97f, -1.8f, -1.75f, -1.39f, -2.33f)
                curveToRelative(0.41f, -0.58f, 1.02f, -1.2f, 1.85f, -1.83f)
                curveToRelative(0.8f, -0.62f, 0.77f, -1.09f, -0.09f, -1.41f)
                curveToRelative(0.21f, -0.59f, 0.29f, -1.26f, 0.23f, -2.01f)
                lineToRelative(-2.81f, -0.81f)
                lineToRelative(-2.86f, -0.63f)
                lineToRelative(-0.32f, 0.63f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(266.41f, 119.66f)
                curveToRelative(2.74f, -0.79f, 3.47f, 0.42f, 3.47f, 0.94f)
                curveToRelative(0f, 0.34f, -0.09f, 0.91f, -0.26f, 1.7f)
                arcToRelative(9.12f, 9.12f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.71f, -0.34f)
                curveToRelative(0.84f, -0.48f, 1.4f, -1.33f, 1.6f, -1.99f)
                curveToRelative(0.37f, -1.24f, -0.72f, -3.87f, -3.54f, -3.47f)
                curveToRelative(-0.98f, -0.19f, -1.14f, -1.65f, -2.85f, -0.75f)
                curveToRelative(-1.71f, 0.9f, -2.29f, 0.21f, -2.29f, 1.13f)
                curveToRelative(0f, 0.92f, 0.07f, 3.77f, 3.16f, 2.8f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(260.22f, 194.58f)
                curveToRelative(-1.8f, 1.12f, -3.06f, 1.67f, -3.78f, 1.67f)
                curveToRelative(-1.07f, 0f, -1.65f, 0.96f, -0.66f, 1.48f)
                curveToRelative(1f, 0.52f, 4.2f, -0.23f, 5.02f, -0.23f)
                reflectiveCurveToRelative(2.93f, 0.3f, 2.12f, -2.05f)
                curveToRelative(-0.54f, -1.57f, -1.03f, -2.23f, -1.48f, -2f)
                lineToRelative(-1.22f, 0.33f)
                verticalLineToRelative(0.8f)
                close()
                moveTo(272.6f, 194.47f)
                curveToRelative(-1.25f, 1.73f, -2.19f, 2.7f, -2.84f, 2.91f)
                curveToRelative(-0.97f, 0.32f, -1.17f, 1.52f, -0.08f, 1.78f)
                curveToRelative(1.09f, 0.26f, 3.73f, -1.49f, 4.47f, -1.73f)
                curveToRelative(0.74f, -0.24f, 2.76f, -0.55f, 1.21f, -2.83f)
                curveToRelative(-1.03f, -1.52f, -1.71f, -2.09f, -2.04f, -1.71f)
                lineToRelative(-0.99f, 0.71f)
                lineToRelative(0.28f, 0.86f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(262.07f, 192.86f),
                    end = Offset(261.32f, 154.66f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(270.9f, 153.42f)
                curveToRelative(-1.17f, 7.82f, -2.83f, 13.93f, -4.96f, 18.33f)
                curveToRelative(-1.17f, 5.49f, -1.92f, 22.09f, -3.47f, 22.72f)
                curveToRelative(-1.55f, 0.63f, -2.66f, 0.25f, -2.6f, -0.55f)
                curveToRelative(0.06f, -0.8f, -2.07f, -23.06f, -1.83f, -26.52f)
                curveToRelative(0.16f, -2.31f, 0.18f, -6.89f, 0.07f, -13.73f)
                lineToRelative(12.79f, -0.24f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(273.31f, 192.69f),
                    end = Offset(268.46f, 154.77f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(276.35f, 152.53f)
                curveToRelative(0.17f, 7.51f, -0.26f, 15.57f, -1.29f, 24.18f)
                curveToRelative(-0.96f, 10.73f, 1.11f, 16.68f, -0.35f, 17.49f)
                curveToRelative(-1.46f, 0.81f, -2.61f, 0.57f, -2.65f, -0.23f)
                curveToRelative(-0.04f, -0.81f, -4.5f, -22.53f, -4.68f, -25.99f)
                curveToRelative(-0.12f, -2.31f, -0.65f, -6.86f, -1.6f, -13.64f)
                lineToRelative(10.57f, -1.8f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(265.35f, 126.99f)
                curveToRelative(1.75f, 1.9f, 3.36f, 1.9f, 4.82f, 0f)
                curveToRelative(0.25f, -0.17f, 5.64f, -0.44f, 9.45f, 5.76f)
                curveToRelative(0.04f, 0.24f, -1.03f, 1.51f, -3.21f, 3.84f)
                horizontalLineToRelative(-0.67f)
                curveToRelative(1.48f, 7.63f, 1.7f, 13.71f, 0.67f, 18.24f)
                curveToRelative(-0.14f, 0.47f, -6.25f, 0.74f, -18.35f, 0.79f)
                curveToRelative(-0.03f, -10.21f, 0.64f, -16.25f, 2.03f, -18.11f)
                curveToRelative(-0.17f, -0.34f, -1.42f, -1.46f, -3.77f, -3.36f)
                curveToRelative(0.74f, -1.59f, 1.85f, -3.11f, 3.33f, -4.58f)
                curveToRelative(1.48f, -1.46f, 3.38f, -2.32f, 5.7f, -2.58f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEFAB23))) {
                moveTo(240.17f, 120.88f)
                arcToRelative(1.72f, 1.72f, 0f, isMoreThanHalf = true, isPositiveArc = false, -2.43f, 2.43f)
                lineToRelative(27.25f, 27.25f)
                arcToRelative(1.72f, 1.72f, 0f, isMoreThanHalf = true, isPositiveArc = false, 2.43f, -2.43f)
                lineToRelative(-27.25f, -27.25f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xFFFFDE9B)
                    ),
                    start = Offset(256.58f, 127.76f),
                    end = Offset(232.33f, 125.59f)
                )
            ) {
                moveTo(253.96f, 135.17f)
                curveToRelative(5.27f, -5.27f, 5.27f, -13.81f, 0f, -19.08f)
                reflectiveCurveToRelative(-13.81f, -5.27f, -19.08f, 0f)
                curveToRelative(-5.27f, 5.27f, -5.27f, 13.81f, 0f, 19.08f)
                curveToRelative(5.27f, 5.27f, 13.81f, 5.27f, 19.08f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(236.47f, 117.68f),
                    end = Offset(252.37f, 133.58f)
                )
            ) {
                moveTo(252.37f, 133.58f)
                curveToRelative(4.39f, -4.39f, 4.39f, -11.51f, 0f, -15.9f)
                reflectiveCurveToRelative(-11.51f, -4.39f, -15.9f, 0f)
                curveToRelative(-4.39f, 4.39f, -4.39f, 11.51f, 0f, 15.9f)
                curveToRelative(4.39f, 4.39f, 11.51f, 4.39f, 15.9f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(274.65f, 148.46f),
                    end = Offset(278.91f, 136.99f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(274.95f, 136.11f)
                curveToRelative(-0.14f, 0.86f, 2.26f, 4.62f, 3.16f, 5.98f)
                curveToRelative(0.29f, 0.1f, -7.53f, 3.27f, -8.19f, 3.7f)
                curveToRelative(-1.81f, 1.2f, -1.83f, 3.06f, -0.35f, 3.48f)
                curveToRelative(1.48f, 0.42f, 1.77f, -2.33f, 2.05f, -2.4f)
                curveToRelative(4.98f, -1.15f, 5.41f, -1.03f, 8.72f, -1.83f)
                curveToRelative(2.85f, -0.62f, 0.7f, -5.58f, -1.22f, -10.92f)
                curveToRelative(-1.92f, -5.34f, -4.03f, 1.13f, -4.16f, 1.99f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(273.69f, 127.52f)
                curveToRelative(0.91f, 0.44f, 1.54f, 0.76f, 1.9f, 0.98f)
                curveToRelative(0.94f, 0.56f, 1.57f, 1.12f, 1.99f, 1.45f)
                curveToRelative(1.28f, 1.03f, 1.92f, 2.09f, 2.29f, 2.89f)
                curveToRelative(0.31f, 0.55f, -2.97f, 5.53f, -6.18f, 4.97f)
                curveToRelative(-0.44f, -0.02f, -1.14f, -1.05f, -2.1f, -3.09f)
                lineToRelative(2.1f, -7.2f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFCEBF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(260.02f, 146.14f)
                curveToRelative(1.1f, -0.36f, 1.84f, -1.37f, 1.66f, -1.92f)
                curveToRelative(-0.18f, -0.55f, -1.21f, -0.87f, -1.86f, -0f)
                curveToRelative(-0.19f, 0.25f, -0.1f, 1.47f, -1.95f, 0.63f)
                curveToRelative(-0.5f, -0.22f, -0.63f, 0.04f, -0.52f, 0.38f)
                curveToRelative(0.1f, 0.32f, -0.06f, 0.84f, 1.15f, 0.96f)
                curveToRelative(0.46f, 0.04f, 1.06f, 0.1f, 1.51f, -0.04f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFCEBF))) {
                moveTo(258.81f, 145.27f)
                curveToRelative(0.47f, -0.34f, 0.71f, -0.81f, 0.54f, -1.04f)
                curveToRelative(-0.17f, -0.23f, -0.69f, -0.15f, -1.15f, 0.19f)
                curveToRelative(-0.47f, 0.34f, -0.71f, 0.8f, -0.54f, 1.04f)
                curveToRelative(0.17f, 0.23f, 0.69f, 0.15f, 1.15f, -0.19f)
                close()
            }
        }.build()

        return _EmptyPage!!
    }

@Suppress("ObjectPropertyName")
private var _EmptyPage: ImageVector? = null
