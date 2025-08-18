package com.hjcoding.kmpcleaner.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.EmptyList: ImageVector
    get() {
        if (_EmptyList != null) {
            return _EmptyList!!
        }
        _EmptyList = ImageVector.Builder(
            name = "EmptyList",
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
                    start = Offset(188.11f, 170.04f),
                    end = Offset(188.11f, 236.12f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(188.11f, 236.12f)
                curveToRelative(55.72f, 0f, 100.88f, -14.79f, 100.88f, -33.04f)
                curveToRelative(0f, -18.25f, -45.17f, -33.04f, -100.88f, -33.04f)
                reflectiveCurveTo(87.22f, 184.83f, 87.22f, 203.08f)
                curveToRelative(0f, 18.25f, 45.17f, 33.04f, 100.88f, 33.04f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(137.44f, 96.03f),
                    end = Offset(137.44f, 136.56f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(79.23f, 115.56f)
                curveToRelative(10.16f, -1.65f, 14.28f, -2.89f, 24.2f, -12.55f)
                curveToRelative(9.93f, -9.65f, 19.99f, 4.43f, 34.91f, -1.22f)
                curveToRelative(14.92f, -5.65f, 16.29f, -12.5f, 39.12f, 8.47f)
                curveToRelative(10.52f, 8.91f, 18.89f, 5.38f, 24.05f, 8.91f)
                curveToRelative(3.44f, 2.35f, 6.75f, 8.15f, 9.94f, 17.39f)
                horizontalLineTo(79.23f)
                curveToRelative(-10.53f, -3.7f, -15.79f, -6.77f, -15.79f, -9.21f)
                curveToRelative(0f, -3.67f, 5.63f, -10.14f, 15.79f, -11.79f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(267.84f, 126.87f),
                    end = Offset(267.84f, 156.82f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(222.79f, 141.3f)
                curveToRelative(7.86f, -1.22f, 11.05f, -2.14f, 18.73f, -9.27f)
                curveToRelative(7.68f, -7.13f, 15.47f, 3.27f, 27.02f, -0.9f)
                curveToRelative(11.55f, -4.18f, 12.6f, -9.24f, 30.27f, 6.26f)
                curveToRelative(8.14f, 6.59f, 14.62f, 3.98f, 18.61f, 6.59f)
                curveToRelative(2.66f, 1.74f, 5.22f, 6.02f, 7.69f, 12.85f)
                horizontalLineTo(222.79f)
                curveToRelative(-8.15f, -2.73f, -12.22f, -5f, -12.22f, -6.81f)
                curveToRelative(0f, -2.71f, 4.35f, -7.49f, 12.22f, -8.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFD8D8E4),
                        0.23f to Color(0xFFE2E2EA),
                        0.93f to Color(0xFFF2F2F9),
                        1f to Color(0xFFE6E6EB)
                    ),
                    start = Offset(206.1f, 202.64f),
                    end = Offset(205.64f, 82.81f)
                )
            ) {
                moveTo(247.54f, 82.82f)
                curveToRelative(6.83f, 0f, 12.37f, 5.54f, 12.37f, 12.37f)
                verticalLineToRelative(1.22f)
                horizontalLineToRelative(-21.95f)
                verticalLineToRelative(93.87f)
                curveToRelative(0f, 6.83f, -5.54f, 12.37f, -12.37f, 12.37f)
                horizontalLineToRelative(-79.29f)
                arcToRelative(0.93f, 0.93f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.93f, -0.93f)
                verticalLineToRelative(-109f)
                curveToRelative(0f, -5.47f, 4.43f, -9.9f, 9.9f, -9.9f)
                horizontalLineToRelative(92.27f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8F8FB),
                        1f to Color(0xFFFAFAFE)
                    ),
                    start = Offset(190.31f, 88.98f),
                    end = Offset(190.31f, 187.82f)
                ),
                fillAlpha = 0.712f,
                strokeAlpha = 0.712f
            ) {
                moveTo(225.27f, 88.98f)
                horizontalLineToRelative(-69.92f)
                arcToRelative(3.81f, 3.81f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.81f, 3.81f)
                verticalLineToRelative(99.88f)
                arcToRelative(3.81f, 3.81f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.81f, 3.81f)
                horizontalLineToRelative(69.92f)
                arcToRelative(3.81f, 3.81f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.81f, -3.81f)
                verticalLineTo(92.79f)
                arcToRelative(3.81f, 3.81f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.81f, -3.81f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAFAFF),
                        1f to Color(0xFFDADADE)
                    ),
                    start = Offset(182.71f, 180.61f),
                    end = Offset(182.71f, 202.64f)
                )
            ) {
                moveTo(215.19f, 180.61f)
                verticalLineToRelative(10.89f)
                curveToRelative(0f, 6.15f, 4.98f, 11.13f, 11.13f, 11.13f)
                horizontalLineToRelative(-86.2f)
                curveToRelative(-6.83f, 0f, -12.37f, -5.54f, -12.37f, -12.37f)
                verticalLineToRelative(-9.66f)
                horizontalLineToRelative(87.44f)
                close()
                moveTo(237.67f, 191.63f)
                curveToRelative(0f, 6.08f, -4.93f, 11.01f, -11.01f, 11.01f)
                horizontalLineToRelative(-0.12f)
                curveToRelative(6.15f, 0f, 11.13f, -4.99f, 11.13f, -11.13f)
                lineToRelative(-0f, 0.06f)
                lineToRelative(0f, 0.06f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEF8),
                        1f to Color(0xFFBDBDC8)
                    ),
                    start = Offset(248.9f, 101.85f),
                    end = Offset(248.9f, 85.26f)
                )
            ) {
                moveTo(248.9f, 82.82f)
                curveToRelative(6.08f, 0f, 11.01f, 4.93f, 11.01f, 11.01f)
                lineToRelative(-0f, 9.25f)
                horizontalLineToRelative(-22.03f)
                verticalLineToRelative(-9.25f)
                curveToRelative(0f, -6.08f, 4.93f, -11.01f, 11.01f, -11.01f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x40FFD685),
                        1f to Color(0xFFFFB829)
                    ),
                    start = Offset(254.63f, 124.07f),
                    end = Offset(174.65f, 146.95f)
                ),
                fillAlpha = 0.398f,
                strokeAlpha = 0.398f,
                strokeLineWidth = 0.881f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(254.63f, 104.84f)
                curveToRelative(-1.19f, 14.42f, -7.48f, 21.23f, -13.77f, 25.03f)
                curveToRelative(-10.01f, 6.05f, -21.59f, 3.04f, -24.45f, 0f)
                curveToRelative(-4.66f, -4.95f, 4.01f, -12.49f, 12.61f, -6.86f)
                curveToRelative(8.59f, 5.63f, -15.1f, 25.46f, -39.86f, 21.95f)
                curveToRelative(-16.5f, -2.34f, -31.39f, -6.71f, -44.66f, -13.11f)
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(96.7f, 175.6f)
                horizontalLineToRelative(1.73f)
                curveToRelative(0.47f, 0f, 0.86f, 0.38f, 0.86f, 0.86f)
                verticalLineToRelative(16.07f)
                arcToRelative(0.86f, 0.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.86f, 0.86f)
                horizontalLineToRelative(-1.73f)
                arcToRelative(0.86f, 0.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.86f, -0.86f)
                verticalLineToRelative(-16.07f)
                curveToRelative(0f, -0.47f, 0.38f, -0.86f, 0.86f, -0.86f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(98.02f, 149.78f),
                    end = Offset(98.02f, 183.94f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(94.03f, 154.38f)
                curveToRelative(-3.2f, 6.64f, -14.22f, 27.03f, 1.22f, 29.31f)
                curveToRelative(15.44f, 2.28f, 14.75f, -11.28f, 12.04f, -16.14f)
                curveToRelative(-2.71f, -4.86f, -5.76f, -7.57f, -5.76f, -13.17f)
                curveToRelative(0f, -5.6f, -4.3f, -6.65f, -7.5f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(292.84f, 194.55f)
                horizontalLineToRelative(0.17f)
                curveToRelative(0.47f, 0f, 0.86f, 0.38f, 0.86f, 0.86f)
                verticalLineToRelative(9.02f)
                arcToRelative(0.86f, 0.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.86f, 0.86f)
                horizontalLineToRelative(-0.17f)
                arcToRelative(0.86f, 0.86f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.86f, -0.86f)
                verticalLineToRelative(-9.02f)
                curveToRelative(0f, -0.47f, 0.38f, -0.86f, 0.86f, -0.86f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(293.39f, 177.97f),
                    end = Offset(293.39f, 199.43f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(290.79f, 180.86f)
                curveToRelative(-2.09f, 4.17f, -9.29f, 16.98f, 0.8f, 18.41f)
                curveToRelative(10.08f, 1.43f, 9.63f, -7.09f, 7.87f, -10.14f)
                curveToRelative(-1.77f, -3.05f, -3.77f, -4.76f, -3.77f, -8.27f)
                reflectiveCurveToRelative(-2.81f, -4.17f, -4.9f, 0f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEF8),
                        1f to Color(0xFFD6D6DC)
                    ),
                    start = Offset(262.56f, 171.8f),
                    end = Offset(262.56f, 198.23f)
                )
            ) {
                moveTo(244.93f, 171.8f)
                horizontalLineToRelative(35.24f)
                curveToRelative(0.97f, 0f, 1.76f, 0.79f, 1.76f, 1.76f)
                verticalLineToRelative(22.91f)
                curveToRelative(0f, 0.97f, -0.79f, 1.76f, -1.76f, 1.76f)
                horizontalLineToRelative(-35.24f)
                arcToRelative(1.76f, 1.76f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.76f, -1.76f)
                verticalLineToRelative(-22.91f)
                curveToRelative(0f, -0.97f, 0.79f, -1.76f, 1.76f, -1.76f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFBCA8))) {
                moveToRelative(244.94f, 195.94f)
                lineToRelative(-2.49f, 1.31f)
                lineToRelative(-5.94f, -8.44f)
                lineToRelative(3.38f, -1.15f)
                lineToRelative(5.05f, 8.28f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(242.17f, 196.58f)
                arcToRelative(0.26f, 0.26f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.15f, 0.06f)
                curveToRelative(-0.67f, 0.62f, -1.16f, 1.26f, -1.52f, 1.59f)
                curveToRelative(-0.6f, 0.54f, -1.12f, 1.08f, -1.52f, 1.39f)
                curveToRelative(-0.39f, 0.31f, -1.14f, 0.77f, -1.45f, 1.17f)
                arcToRelative(1.08f, 1.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.19f, 1f)
                curveToRelative(0.04f, 0.14f, 0.04f, 0.4f, 0.2f, 0.71f)
                curveToRelative(0.06f, 0.12f, 0.17f, 0.23f, 0.27f, 0.2f)
                curveToRelative(1.93f, -0.54f, 3.84f, -1.5f, 4.91f, -2.03f)
                curveToRelative(1.05f, -0.53f, 2.66f, -1.29f, 4.05f, -1.98f)
                curveToRelative(0.14f, -0.07f, 0.18f, -0.28f, 0.1f, -0.44f)
                curveToRelative(-0.45f, -0.95f, -0.7f, -1.46f, -0.96f, -1.81f)
                curveToRelative(-0.25f, -0.33f, -0.5f, -0.75f, -0.96f, -1.1f)
                curveToRelative(-0.08f, -0.06f, -0.19f, -0.12f, -0.24f, -0.04f)
                lineToRelative(-0.48f, 0.63f)
                curveToRelative(-0.29f, 0.38f, -0.89f, 0.56f, -1.15f, 0.62f)
                curveToRelative(-0.17f, 0.04f, -0.47f, 0.05f, -0.9f, 0.02f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFBCA8))) {
                moveToRelative(235.99f, 198.48f)
                lineToRelative(-3f, -0.38f)
                lineToRelative(3.96f, -6.8f)
                lineToRelative(3.96f, 1.32f)
                lineToRelative(-4.93f, 5.86f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(255f, 192.12f),
                    end = Offset(246.67f, 166.43f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(249.48f, 162.99f)
                lineToRelative(-0.41f, 1.58f)
                lineToRelative(-2.78f, 0.17f)
                lineToRelative(-3.19f, 0.9f)
                reflectiveCurveToRelative(-8.9f, 2.96f, -14.07f, 7f)
                curveToRelative(-2.71f, 2.11f, -2.48f, 4.21f, -1.66f, 5.74f)
                lineToRelative(-0.02f, 0.01f)
                reflectiveCurveToRelative(5.37f, 8.71f, 8.54f, 13.06f)
                curveToRelative(-0.93f, 1.83f, -1.58f, 3.16f, -1.56f, 3.3f)
                curveToRelative(0.07f, 0.45f, 3.34f, 1.59f, 4.94f, 1.58f)
                curveToRelative(1.59f, -0.01f, 6.46f, -9.66f, 8.47f, -11.29f)
                curveToRelative(2.01f, -1.63f, 13.28f, -6.32f, 14.82f, -13.08f)
                curveToRelative(1.03f, -4.51f, 1.15f, -6.39f, 0.39f, -5.64f)
                lineToRelative(-6.87f, -2.92f)
                lineToRelative(-6.59f, -0.38f)
                close()
                moveTo(242.58f, 176.27f)
                lineTo(242f, 179.65f)
                curveToRelative(-0.02f, 0.1f, -1.07f, 2.12f, -2.39f, 4.64f)
                arcToRelative(146.42f, 146.42f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.52f, -5.5f)
                lineToRelative(-0.01f, -0.01f)
                lineToRelative(-0.81f, -1.22f)
                curveToRelative(0.07f, -0.03f, 0.12f, -0.05f, 0.15f, -0.06f)
                curveToRelative(0.61f, -0.18f, 7.15f, -1.23f, 7.15f, -1.23f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(254.21f, 129.74f),
                    end = Offset(259.68f, 136.53f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(252.72f, 128.47f)
                curveToRelative(-0.69f, 3.82f, -0.36f, 6.06f, 0.97f, 6.73f)
                curveToRelative(1.74f, 0.81f, 0.06f, 2.69f, -0.29f, 2.9f)
                curveToRelative(-0.23f, 0.14f, -0.03f, 0.53f, 0.62f, 1.17f)
                curveToRelative(1.1f, 0.65f, 1.91f, 0.91f, 2.43f, 0.77f)
                curveToRelative(0.52f, -0.13f, 1.15f, -0.78f, 1.89f, -1.95f)
                curveToRelative(-1.39f, -1.11f, -1.87f, -2f, -1.45f, -2.67f)
                curveToRelative(0.42f, -0.67f, 1.06f, -1.37f, 1.92f, -2.1f)
                curveToRelative(0.83f, -0.71f, 0.8f, -1.25f, -0.1f, -1.62f)
                curveToRelative(0.22f, -0.67f, 0.3f, -1.44f, 0.24f, -2.3f)
                lineToRelative(-2.93f, -0.93f)
                lineToRelative(-2.98f, -0.72f)
                lineToRelative(-0.34f, 0.72f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(254.43f, 129.45f)
                curveToRelative(3.31f, -0.81f, 4.19f, 0.44f, 4.19f, 0.96f)
                curveToRelative(0f, 0.35f, -0.1f, 0.93f, -0.31f, 1.75f)
                curveToRelative(0.41f, -0.16f, 0.69f, -0.27f, 0.86f, -0.35f)
                curveToRelative(1.02f, -0.49f, 1.69f, -1.37f, 1.93f, -2.05f)
                curveToRelative(0.45f, -1.27f, -0.87f, -3.98f, -4.28f, -3.57f)
                curveToRelative(-1.19f, -0.19f, -1.38f, -1.7f, -3.44f, -0.77f)
                curveToRelative(-2.07f, 0.93f, -2.76f, 0.21f, -2.76f, 1.16f)
                curveToRelative(0f, 0.95f, 0.09f, 3.87f, 3.82f, 2.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(240.03f, 147.38f),
                    end = Offset(243.11f, 155.99f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(246.24f, 144.03f)
                curveToRelative(-2.3f, 5.05f, -3.71f, 8.24f, -4.21f, 9.57f)
                curveToRelative(-0.24f, 0.55f, -3.28f, 1.92f, -9.13f, 4.12f)
                curveToRelative(-1.96f, 0.17f, -3.08f, 0.74f, -3.37f, 1.71f)
                curveToRelative(-0.16f, 0.63f, -0.09f, 1.7f, 0.91f, 1.78f)
                curveToRelative(0.67f, 0.06f, 1.62f, -0.43f, 2.85f, -1.47f)
                curveToRelative(6.54f, 0.23f, 10.43f, -0.84f, 11.66f, -3.2f)
                curveToRelative(1.24f, -2.37f, 3.13f, -6.03f, 5.66f, -10.99f)
                lineToRelative(-4.07f, -1.95f)
                lineToRelative(-0.3f, 0.43f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(252.92f, 137.51f)
                curveToRelative(1.98f, 2.1f, 3.81f, 2.1f, 5.47f, 0f)
                curveToRelative(0.29f, -0.19f, 6.39f, -0.49f, 10.72f, 6.37f)
                curveToRelative(0.04f, 0.26f, -1.17f, 1.67f, -3.64f, 4.24f)
                horizontalLineToRelative(-0.76f)
                curveToRelative(-0f, 9.89f, -0.59f, 17.34f, -1.77f, 22.34f)
                curveToRelative(-0.15f, 0.52f, -6.22f, -1.08f, -18.21f, -4.8f)
                curveToRelative(0.67f, -8.48f, 1.4f, -13.99f, 2.21f, -16.52f)
                curveToRelative(-0.19f, -0.38f, -1.62f, -1.62f, -4.27f, -3.72f)
                curveToRelative(0.84f, -1.75f, 2.09f, -3.44f, 3.77f, -5.06f)
                curveToRelative(1.68f, -1.62f, 3.83f, -2.57f, 6.47f, -2.86f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(267.35f, 143.71f),
                    end = Offset(269.76f, 157.6f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(264.39f, 147.07f)
                curveToRelative(0.11f, 0.97f, 3.68f, 4.3f, 5.01f, 5.49f)
                curveToRelative(0.33f, 0.02f, -6.77f, 5.87f, -7.32f, 6.55f)
                curveToRelative(-1.5f, 1.86f, -0.98f, 3.87f, 0.66f, 3.87f)
                reflectiveCurveToRelative(1.13f, -3.07f, 1.4f, -3.23f)
                curveToRelative(4.78f, -2.79f, 5.26f, -2.79f, 8.42f, -4.69f)
                curveToRelative(2.75f, -1.55f, -0.93f, -6.26f, -4.47f, -11.44f)
                curveToRelative(-3.54f, -5.19f, -3.81f, 2.47f, -3.7f, 3.44f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(264.71f, 140.08f)
                curveToRelative(0.77f, 0.37f, 1.3f, 0.64f, 1.61f, 0.82f)
                curveToRelative(0.79f, 0.47f, 1.33f, 0.94f, 1.67f, 1.22f)
                curveToRelative(1.08f, 0.87f, 1.62f, 1.76f, 1.93f, 2.43f)
                curveToRelative(0.26f, 0.46f, -2.5f, 4.65f, -5.21f, 4.18f)
                curveToRelative(-0.37f, -0.01f, -0.96f, -0.88f, -1.76f, -2.59f)
                lineToRelative(1.76f, -6.05f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(233.55f, 197.41f)
                arcToRelative(0.25f, 0.25f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.15f, -0.05f)
                curveToRelative(-0.91f, 0.07f, -1.69f, 0.28f, -2.18f, 0.31f)
                curveToRelative(-0.81f, 0.05f, -1.55f, 0.16f, -2.05f, 0.16f)
                curveToRelative(-0.5f, 0.01f, -1.38f, -0.1f, -1.87f, 0.04f)
                arcToRelative(1.08f, 1.08f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.76f, 0.67f)
                curveToRelative(-0.05f, 0.13f, -0.21f, 0.34f, -0.28f, 0.68f)
                curveToRelative(-0.03f, 0.13f, -0.01f, 0.29f, 0.09f, 0.33f)
                curveToRelative(1.86f, 0.76f, 3.95f, 1.19f, 5.12f, 1.42f)
                curveToRelative(1.16f, 0.23f, 2.89f, 0.62f, 4.4f, 0.93f)
                curveToRelative(0.16f, 0.03f, 0.31f, -0.11f, 0.35f, -0.28f)
                curveToRelative(0.23f, -1.03f, 0.35f, -1.59f, 0.35f, -2.02f)
                curveToRelative(0.01f, -0.41f, 0.07f, -0.9f, -0.08f, -1.46f)
                curveToRelative(-0.03f, -0.09f, -0.08f, -0.21f, -0.17f, -0.18f)
                lineToRelative(-0.77f, 0.21f)
                curveToRelative(-0.46f, 0.12f, -1.05f, -0.11f, -1.29f, -0.22f)
                curveToRelative(-0.16f, -0.08f, -0.4f, -0.25f, -0.72f, -0.54f)
                close()
            }
            path(fill = SolidColor(Color(0xFFDB9710))) {
                moveToRelative(119f, 117f)
                lineToRelative(27.89f, 13.96f)
                lineToRelative(-5.66f, 7.64f)
                lineTo(119f, 117f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFC552),
                        1f to Color(0xFFF5B32F)
                    ),
                    start = Offset(120.01f, 119.51f),
                    end = Offset(139.73f, 137.39f)
                )
            ) {
                moveToRelative(119f, 117f)
                lineToRelative(22.23f, 21.6f)
                lineToRelative(1.75f, -8.95f)
                lineTo(119f, 117f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFED686),
                        1f to Color(0xFFFFD786)
                    ),
                    start = Offset(122.06f, 122.03f),
                    end = Offset(134.75f, 129.84f)
                )
            ) {
                moveToRelative(119f, 117f)
                lineToRelative(13.67f, 10.65f)
                lineToRelative(10.31f, 2f)
                lineTo(119f, 117f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFD580))) {
                moveToRelative(122.8f, 118.9f)
                lineToRelative(32.35f, 12.26f)
                lineToRelative(-8.26f, -0.2f)
                lineToRelative(-24.08f, -12.06f)
                close()
            }
        }.build()

        return _EmptyList!!
    }

@Suppress("ObjectPropertyName")
private var _EmptyList: ImageVector? = null
