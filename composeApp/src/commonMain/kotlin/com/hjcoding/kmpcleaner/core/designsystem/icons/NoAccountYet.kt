package com.hjcoding.kmpcleaner.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoAccountYet: ImageVector
    get() {
        if (_NoAccountYet != null) {
            return _NoAccountYet!!
        }
        _NoAccountYet = ImageVector.Builder(
            name = "NoAccountYet",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(103.97f, 96.91f),
                    end = Offset(103.97f, 135.68f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(103.27f, 96.91f)
                curveToRelative(7.75f, 0f, 14.4f, 4.07f, 17.2f, 9.85f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.37f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineTo(86.02f)
                curveToRelative(-7.61f, 0f, -13.78f, -6.17f, -13.78f, -13.78f)
                verticalLineToRelative(-1.37f)
                curveToRelative(0f, -7.61f, 6.17f, -13.78f, 13.78f, -13.78f)
                horizontalLineToRelative(0.05f)
                curveToRelative(2.8f, -5.78f, 9.44f, -9.85f, 17.2f, -9.85f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE2E2EA),
                        1f to Color(0xFFD9D9E8)
                    ),
                    start = Offset(215.76f, 102.87f),
                    end = Offset(159.23f, 133.64f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(130.03f, 82.19f)
                lineToRelative(72.85f, -20.97f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.05f, 2.39f)
                lineToRelative(22.53f, 52.32f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.68f, 5.73f)
                lineToRelative(-77f, 22.85f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = true, -5.21f, -2.7f)
                lineToRelative(-18.38f, -54.19f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.84f, -5.42f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE3E3EA)
                    ),
                    start = Offset(180.56f, 80.49f),
                    end = Offset(141.9f, 130.35f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(128.96f, 127.35f)
                lineToRelative(28.82f, -6.74f)
                arcToRelative(7.4f, 7.4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 4.84f, -3.71f)
                lineToRelative(2.99f, -5.6f)
                arcToRelative(7.4f, 7.4f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.51f, -3.63f)
                lineToRelative(32.04f, -9.09f)
                arcToRelative(7.4f, 7.4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.38f, -6.91f)
                lineToRelative(0.75f, -26.54f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = false, -5.32f, -4.2f)
                lineToRelative(-78.24f, 21.01f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.13f, 4.33f)
                lineToRelative(2.19f, 37.21f)
                arcToRelative(4.23f, 4.23f, 0f, isMoreThanHalf = false, isPositiveArc = false, 5.18f, 3.87f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFECECF2)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(196.05f, 104.56f)
                lineToRelative(3.74f, 3.74f)
                lineToRelative(-3.74f, 3.74f)
                lineToRelative(-3.74f, -3.74f)
                lineToRelative(3.74f, -3.74f)
                close()
                moveTo(196.05f, 123.35f)
                lineToRelative(3.74f, 3.74f)
                lineToRelative(-3.74f, 3.74f)
                lineToRelative(-3.74f, -3.74f)
                lineToRelative(3.74f, -3.74f)
                close()
                moveTo(159.02f, 125.74f)
                lineToRelative(3.74f, 3.74f)
                lineToRelative(-3.74f, 3.74f)
                lineToRelative(-3.74f, -3.74f)
                lineToRelative(3.74f, -3.74f)
                close()
                moveTo(149.11f, 149.78f)
                lineToRelative(3.74f, 3.73f)
                lineToRelative(-3.74f, 3.73f)
                lineToRelative(-3.74f, -3.73f)
                lineToRelative(3.74f, -3.73f)
                close()
                moveTo(179.14f, 118.47f)
                lineToRelative(1.5f, 1.5f)
                lineToRelative(-1.5f, 1.5f)
                lineToRelative(-1.5f, -1.5f)
                lineToRelative(1.5f, -1.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFE),
                        1f to Color(0xFFEBEBF0)
                    ),
                    start = Offset(193.75f, 208.73f),
                    end = Offset(193.75f, 235.33f)
                )
            ) {
                moveTo(249f, 209.16f)
                curveToRelative(0f, 5.05f, -20.18f, 3.82f, -25.97f, 5.07f)
                curveToRelative(-9.71f, 2.1f, 11.21f, 11.57f, -24.05f, 12.63f)
                curveToRelative(-29.5f, 0.89f, -61.26f, -3.25f, -60.46f, -13.91f)
                curveToRelative(0.8f, -10.66f, 24.26f, -16.48f, 53.97f, -16.48f)
                curveToRelative(29.71f, 0f, 56.51f, 2.07f, 56.51f, 12.69f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(178.13f, 124.91f),
                    end = Offset(189.69f, 142.89f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(190.28f, 144.37f)
                curveToRelative(-5.03f, -5.27f, -8.27f, -8.23f, -9.75f, -8.9f)
                curveToRelative(-0.61f, -0.3f, -1.94f, -3.77f, -3.98f, -10.39f)
                curveToRelative(-0.04f, -2.17f, -0.6f, -3.46f, -1.69f, -3.84f)
                curveToRelative(-0.7f, -0.22f, -1.93f, -0.23f, -2.1f, 0.86f)
                curveToRelative(-0.12f, 0.73f, 0.37f, 1.81f, 1.46f, 3.25f)
                curveToRelative(-0.13f, 6.35f, 1.21f, 11.22f, 4.01f, 14.61f)
                curveToRelative(2.8f, 3.39f, 5.96f, 6.67f, 9.47f, 9.81f)
                lineToRelative(2.6f, -4.85f)
                verticalLineToRelative(-0.57f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(225.71f, 158.52f),
                    end = Offset(211.08f, 158.35f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(211.79f, 153.57f)
                curveToRelative(1.02f, 0.22f, 4.19f, 4.49f, 5.32f, 6.07f)
                curveToRelative(-0.01f, 0.37f, 6.88f, -6.99f, 7.65f, -7.54f)
                curveToRelative(2.11f, -1.5f, 4.2f, -0.73f, 4.03f, 1.09f)
                curveToRelative(-0.16f, 1.83f, -3.36f, 0.97f, -3.56f, 1.26f)
                curveToRelative(-3.42f, 5.05f, -3.47f, 5.59f, -5.78f, 8.93f)
                curveToRelative(-1.91f, 2.91f, -6.53f, -1.61f, -11.67f, -6.02f)
                curveToRelative(-5.14f, -4.42f, 2.98f, -4.01f, 4f, -3.79f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(188.66f, 209.05f)
                curveToRelative(-2.15f, 1.57f, -3.66f, 2.35f, -4.51f, 2.35f)
                curveToRelative(-1.28f, 0f, -1.98f, 1.35f, -0.78f, 2.08f)
                curveToRelative(1.19f, 0.73f, 5.01f, -0.32f, 5.99f, -0.32f)
                curveToRelative(0.98f, 0f, 3.5f, 0.42f, 2.53f, -2.88f)
                curveToRelative(-0.64f, -2.2f, -1.23f, -3.13f, -1.77f, -2.81f)
                lineToRelative(-1.46f, 0.46f)
                verticalLineToRelative(1.12f)
                close()
                moveTo(206.55f, 209.05f)
                curveToRelative(2.15f, 1.57f, 3.66f, 2.35f, 4.51f, 2.35f)
                curveToRelative(1.28f, 0f, 1.98f, 1.35f, 0.78f, 2.08f)
                curveToRelative(-1.19f, 0.73f, -5.01f, -0.32f, -5.99f, -0.32f)
                curveToRelative(-0.98f, 0f, -3.5f, 0.42f, -2.53f, -2.88f)
                curveToRelative(0.64f, -2.2f, 1.23f, -3.13f, 1.77f, -2.81f)
                lineToRelative(1.46f, 0.46f)
                verticalLineToRelative(1.12f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(192.72f, 206.91f),
                    end = Offset(195.78f, 172.01f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(188.61f, 170.27f)
                curveToRelative(-1.25f, 9.23f, -1.62f, 18.66f, -1.1f, 28.28f)
                curveToRelative(0.73f, 10.38f, -0.03f, 10.15f, 1.1f, 10.15f)
                curveToRelative(0.43f, 0f, 2.17f, 0.23f, 2.56f, -0.45f)
                curveToRelative(0.92f, -1.63f, 2.41f, -15.35f, 1.83f, -18.11f)
                curveToRelative(-0.06f, -0.41f, 5.72f, -13.28f, 5.72f, -18.29f)
                curveToRelative(-0.22f, -0.98f, -3.58f, -1.5f, -10.11f, -1.59f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(202.31f, 206.91f),
                    end = Offset(199.25f, 172.01f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(206.43f, 170.27f)
                curveToRelative(1.25f, 9.23f, 1.62f, 18.66f, 1.1f, 28.28f)
                curveToRelative(-0.73f, 10.38f, 0.04f, 10.15f, -1.1f, 10.15f)
                curveToRelative(-0.43f, 0f, -2.17f, 0.23f, -2.56f, -0.45f)
                curveToRelative(-0.92f, -1.63f, -2.4f, -15.35f, -1.83f, -18.11f)
                curveToRelative(0.06f, -0.41f, -5.72f, -13.28f, -5.72f, -18.29f)
                curveToRelative(0.22f, -0.98f, 3.58f, -1.5f, 10.11f, -1.59f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(196.09f, 136.25f),
                    end = Offset(199.53f, 142.12f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(194.07f, 134.61f)
                curveToRelative(-0.79f, 3.95f, -0.42f, 6.28f, 1.12f, 6.98f)
                curveToRelative(2.01f, 0.84f, 0.59f, 2.57f, 0.18f, 2.78f)
                curveToRelative(-0.27f, 0.14f, -0.2f, 0.62f, 0.2f, 1.44f)
                curveToRelative(1.27f, 0.67f, 2.2f, 0.94f, 2.8f, 0.8f)
                curveToRelative(0.6f, -0.14f, 1.33f, -0.81f, 2.18f, -2.02f)
                curveToRelative(-1.6f, -1.15f, -2.16f, -2.08f, -1.67f, -2.77f)
                curveToRelative(0.49f, -0.7f, 1.23f, -1.42f, 2.22f, -2.18f)
                curveToRelative(0.96f, -0.74f, 0.93f, -1.3f, -0.11f, -1.68f)
                curveToRelative(0.25f, -0.7f, 0.34f, -1.49f, 0.28f, -2.39f)
                lineToRelative(-3.37f, -0.96f)
                lineToRelative(-3.43f, -0.75f)
                lineToRelative(-0.39f, 0.75f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(196.32f, 135.51f)
                curveToRelative(3.29f, -0.94f, 4.16f, 0.5f, 4.16f, 1.11f)
                curveToRelative(0f, 0.41f, -0.1f, 1.08f, -0.31f, 2.02f)
                curveToRelative(0.4f, -0.18f, 0.69f, -0.32f, 0.85f, -0.41f)
                curveToRelative(1.01f, -0.57f, 1.68f, -1.58f, 1.91f, -2.37f)
                curveToRelative(0.44f, -1.47f, -0.86f, -4.6f, -4.25f, -4.13f)
                curveToRelative(-1.18f, -0.22f, -1.37f, -1.96f, -3.42f, -0.89f)
                curveToRelative(-2.05f, 1.07f, -2.74f, 0.25f, -2.74f, 1.35f)
                curveToRelative(0f, 1.1f, 0.09f, 4.48f, 3.79f, 3.33f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(195.68f, 144.05f)
                curveToRelative(1.4f, 1.56f, 2.81f, 1.56f, 4.23f, 0f)
                curveToRelative(1.34f, 0.21f, 8.3f, 1.04f, 11.67f, 6.24f)
                curveToRelative(1.84f, 2.71f, 2.77f, 4.47f, 2.78f, 5.28f)
                curveToRelative(-2.6f, 3.81f, -3.9f, 5.62f, -3.9f, 5.44f)
                curveToRelative(0f, -0.18f, -1.41f, -1.49f, -4.25f, -3.92f)
                curveToRelative(2.48f, 7.49f, 3.14f, 11.88f, 1.96f, 13.18f)
                curveToRelative(-1.76f, 1.95f, -16.6f, 2.24f, -20.16f, 0.83f)
                curveToRelative(-1.03f, -0.54f, -0.55f, -15.62f, 1.15f, -20.33f)
                curveToRelative(0.05f, -0.25f, -2.55f, 1.77f, -9.89f, -7.04f)
                curveToRelative(-0.23f, -0.32f, 1.66f, -2.45f, 5.67f, -6.39f)
                curveToRelative(1.72f, 1.93f, 3.13f, 3.23f, 4.22f, 3.9f)
                curveToRelative(1.09f, 0.67f, 3.26f, 1.61f, 6.51f, 2.81f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEEE),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(84.83f, 182.19f),
                    end = Offset(84.83f, 260.01f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(79.48f, 172.19f)
                verticalLineToRelative(79.77f)
                lineToRelative(28.73f, 10.59f)
                verticalLineToRelative(-82.8f)
                lineToRelative(-28.73f, -7.55f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(121.48f, 169.81f),
                    end = Offset(121.48f, 262.42f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(108.16f, 179.63f)
                lineToRelative(26.64f, -9.82f)
                verticalLineToRelative(82.52f)
                lineToRelative(-26.64f, 10.1f)
                verticalLineToRelative(-82.8f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(107.04f, 162.11f),
                    end = Offset(107.04f, 179.69f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(79.29f, 172.11f)
                lineToRelative(27.13f, -10f)
                lineToRelative(28.36f, 7.76f)
                lineToRelative(-26.65f, 9.82f)
                lineToRelative(-28.85f, -7.59f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEEE),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(238.76f, 126.01f),
                    end = Offset(238.76f, 187.59f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(234.51f, 118.1f)
                verticalLineToRelative(63.12f)
                lineToRelative(22.8f, 8.38f)
                verticalLineToRelative(-65.52f)
                lineToRelative(-22.8f, -5.98f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(267.84f, 116.22f),
                    end = Offset(267.84f, 189.5f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(257.27f, 123.99f)
                lineToRelative(21.14f, -7.77f)
                verticalLineToRelative(65.3f)
                lineToRelative(-21.14f, 7.99f)
                verticalLineToRelative(-65.52f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(256.38f, 110.13f),
                    end = Offset(256.38f, 124.04f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(234.36f, 118.04f)
                lineToRelative(21.53f, -7.91f)
                lineToRelative(22.51f, 6.14f)
                lineToRelative(-21.15f, 7.77f)
                lineToRelative(-22.9f, -6f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(284.58f, 170.92f),
                    end = Offset(284.58f, 209.69f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(283.89f, 170.92f)
                curveToRelative(7.75f, 0f, 14.4f, 4.07f, 17.2f, 9.85f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.37f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineTo(266.64f)
                curveToRelative(-7.61f, 0f, -13.78f, -6.17f, -13.78f, -13.78f)
                verticalLineToRelative(-1.37f)
                curveToRelative(0f, -7.61f, 6.17f, -13.78f, 13.78f, -13.78f)
                horizontalLineToRelative(0.05f)
                curveToRelative(2.8f, -5.78f, 9.44f, -9.85f, 17.2f, -9.85f)
                close()
            }
        }.build()

        return _NoAccountYet!!
    }

@Suppress("ObjectPropertyName")
private var _NoAccountYet: ImageVector? = null
