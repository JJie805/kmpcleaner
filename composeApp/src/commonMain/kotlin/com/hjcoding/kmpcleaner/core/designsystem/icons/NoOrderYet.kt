package com.hjcoding.kmpcleaner.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoOrderYet: ImageVector
    get() {
        if (_NoOrderYet != null) {
            return _NoOrderYet!!
        }
        _NoOrderYet = ImageVector.Builder(
            name = "NoOrderYet",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF6F6F7),
                        1f to Color(0x11FCFCFF)
                    ),
                    start = Offset(115.25f, 102.31f),
                    end = Offset(115.25f, 136.27f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(61.17f, 116.84f)
                curveToRelative(9.44f, -1.53f, 13.26f, -2.68f, 22.48f, -11.61f)
                curveToRelative(9.22f, -8.93f, 18.57f, 4.1f, 32.43f, -1.13f)
                curveToRelative(13.86f, -5.23f, 15.13f, -11.56f, 36.34f, 7.84f)
                curveToRelative(9.77f, 8.24f, 17.55f, 4.98f, 22.34f, 8.24f)
                curveToRelative(3.19f, 2.18f, 6.27f, 7.54f, 9.24f, 16.09f)
                horizontalLineTo(61.17f)
                curveToRelative(-9.78f, -3.42f, -14.67f, -6.26f, -14.67f, -8.52f)
                curveToRelative(0f, -3.39f, 5.23f, -9.38f, 14.67f, -10.91f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF6F6F7),
                        1f to Color(0x11FCFCFF)
                    ),
                    start = Offset(302.92f, 129.94f),
                    end = Offset(298.24f, 138.97f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(208.17f, 130.34f)
                curveToRelative(9.44f, -1.53f, 13.26f, -2.68f, 22.48f, -11.61f)
                curveToRelative(9.22f, -8.93f, 18.57f, 4.1f, 32.43f, -1.13f)
                curveToRelative(13.86f, -5.23f, 15.13f, -11.56f, 36.34f, 7.84f)
                curveToRelative(9.77f, 8.24f, 17.55f, 4.98f, 22.34f, 8.24f)
                curveToRelative(3.19f, 2.18f, 6.27f, 7.54f, 9.24f, 16.09f)
                horizontalLineTo(208.17f)
                curveToRelative(-9.78f, -3.42f, -14.67f, -6.26f, -14.67f, -8.52f)
                curveToRelative(0f, -3.39f, 5.23f, -9.38f, 14.67f, -10.91f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE2E3E9)
                    ),
                    start = Offset(166.09f, 131.24f),
                    end = Offset(142.07f, 232.04f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(113.02f, 125.93f)
                lineToRelative(79.23f, -15.43f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.88f, 1.26f)
                lineToRelative(18.36f, 94.65f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.26f, 1.88f)
                lineToRelative(-79.24f, 15.43f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.88f, -1.26f)
                lineToRelative(0f, -0f)
                lineToRelative(-18.36f, -94.65f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.27f, -1.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE2E2E9)
                    ),
                    start = Offset(232.49f, 131.05f),
                    end = Offset(249.43f, 233.29f)
                ),
                fillAlpha = 0.4f,
                strokeAlpha = 0.4f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(285.81f, 129.46f)
                lineToRelative(-77.97f, -20.93f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.96f, 1.13f)
                lineTo(180.97f, 202.8f)
                curveToRelative(-0.23f, 0.85f, 0.28f, 1.73f, 1.13f, 1.96f)
                lineToRelative(77.97f, 20.93f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.96f, -1.13f)
                lineToRelative(-0f, -0f)
                lineToRelative(24.91f, -93.14f)
                arcToRelative(1.61f, 1.61f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.13f, -1.96f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        0.98f to Color(0xFFE3E3EA),
                        1f to Color(0xFFE2E2E9)
                    ),
                    start = Offset(207.34f, 103.36f),
                    end = Offset(157.34f, 230.87f)
                )
            ) {
                moveTo(245.95f, 82.3f)
                horizontalLineToRelative(-96.23f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.6f, 1.6f)
                verticalLineToRelative(133.32f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.6f, 1.6f)
                horizontalLineToRelative(96.23f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.6f, -1.6f)
                verticalLineTo(83.9f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.6f, -1.6f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xAFFFE7D6)
                    ),
                    start = Offset(162.34f, 107.39f),
                    end = Offset(167.92f, 117.4f)
                )
            ) {
                moveTo(167.66f, 106.1f)
                horizontalLineToRelative(-4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, 3.2f)
                verticalLineToRelative(4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, 3.2f)
                horizontalLineToRelative(4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, -3.2f)
                verticalLineToRelative(-4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, -3.2f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(206.84f, 106.1f),
                    end = Offset(206.84f, 117.41f)
                )
            ) {
                moveTo(234.95f, 106.1f)
                horizontalLineToRelative(-56.22f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, 0.8f)
                verticalLineToRelative(9.7f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.8f, 0.8f)
                horizontalLineToRelative(56.22f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.8f, -0.8f)
                verticalLineToRelative(-9.7f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, -0.8f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xAFFFE7D6)
                    ),
                    start = Offset(162.34f, 130f),
                    end = Offset(167.92f, 140.01f)
                )
            ) {
                moveTo(167.66f, 128.71f)
                horizontalLineToRelative(-4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, 3.2f)
                verticalLineToRelative(4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, 3.2f)
                horizontalLineToRelative(4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, -3.2f)
                verticalLineToRelative(-4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, -3.2f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(206.83f, 128.71f),
                    end = Offset(206.83f, 140.02f)
                )
            ) {
                moveTo(234.94f, 128.71f)
                horizontalLineToRelative(-56.22f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, 0.8f)
                verticalLineToRelative(9.7f)
                curveToRelative(0f, 0.44f, 0.36f, 0.8f, 0.8f, 0.8f)
                horizontalLineToRelative(56.22f)
                curveToRelative(0.44f, 0f, 0.8f, -0.36f, 0.8f, -0.8f)
                verticalLineToRelative(-9.7f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, -0.8f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xAFFFE7D6)
                    ),
                    start = Offset(162.34f, 152.31f),
                    end = Offset(167.92f, 162.32f)
                )
            ) {
                moveTo(167.66f, 151.02f)
                horizontalLineToRelative(-4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, 3.2f)
                verticalLineToRelative(4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, 3.2f)
                horizontalLineToRelative(4.88f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, 3.2f, -3.2f)
                verticalLineToRelative(-4.9f)
                arcToRelative(3.2f, 3.2f, 0f, isMoreThanHalf = false, isPositiveArc = false, -3.2f, -3.2f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(206.83f, 151.02f),
                    end = Offset(206.83f, 162.33f)
                )
            ) {
                moveTo(234.94f, 151.02f)
                horizontalLineToRelative(-56.22f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, 0.8f)
                verticalLineToRelative(9.7f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.8f, 0.8f)
                horizontalLineToRelative(56.22f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.8f, -0.8f)
                verticalLineToRelative(-9.7f)
                arcToRelative(0.8f, 0.8f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.8f, -0.8f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEF),
                        1f to Color(0xFFDFDFE5)
                    ),
                    start = Offset(198.19f, 90.11f),
                    end = Offset(198.19f, 75.27f)
                )
            ) {
                moveTo(218.45f, 75.27f)
                horizontalLineToRelative(-40.52f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.6f, 1.6f)
                verticalLineToRelative(11.64f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.6f, 1.6f)
                horizontalLineToRelative(40.52f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1.6f, -1.6f)
                verticalLineTo(76.87f)
                arcToRelative(1.6f, 1.6f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1.6f, -1.6f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEDEDF2),
                        1f to Color(0xE0F9F9FC)
                    ),
                    start = Offset(140.13f, 224.2f),
                    end = Offset(273.58f, 235.14f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(206.01f, 238.77f)
                curveToRelative(89.65f, 0f, 40.87f, -4.97f, 57.96f, -8.1f)
                curveToRelative(15.37f, -2.82f, 37.53f, -3.59f, 37.53f, -7.38f)
                curveToRelative(0f, -8.01f, -40.25f, -13.52f, -95.49f, -13.52f)
                curveToRelative(-55.23f, 0f, -100.01f, 6.49f, -100.01f, 14.5f)
                reflectiveCurveToRelative(44.78f, 14.5f, 100.01f, 14.5f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(254.02f, 182.42f),
                    end = Offset(257.25f, 187.78f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(252.08f, 180.21f)
                curveToRelative(-0.75f, 3.78f, -0.4f, 6f, 1.06f, 6.66f)
                curveToRelative(1.9f, 0.8f, 0.11f, 2.83f, -0.28f, 3.03f)
                curveToRelative(-0.26f, 0.14f, -0.04f, 0.47f, 0.64f, 1f)
                curveToRelative(1.2f, 0.64f, 2.09f, 0.9f, 2.65f, 0.77f)
                curveToRelative(0.56f, -0.13f, 1.25f, -0.77f, 2.07f, -1.93f)
                curveToRelative(-1.51f, -1.1f, -2.04f, -1.98f, -1.58f, -2.65f)
                curveToRelative(0.46f, -0.67f, 1.16f, -1.36f, 2.1f, -2.08f)
                curveToRelative(0.91f, -0.7f, 0.88f, -1.24f, -0.1f, -1.61f)
                curveToRelative(0.24f, -0.67f, 0.32f, -1.43f, 0.26f, -2.28f)
                lineToRelative(-3.19f, -0.92f)
                lineToRelative(-3.25f, -0.72f)
                lineToRelative(-0.37f, 0.72f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(240.77f, 226.12f)
                curveToRelative(-1.72f, 1.24f, -2.93f, 1.9f, -3.65f, 1.96f)
                curveToRelative(-1.08f, 0.09f, -1.58f, 1.08f, -0.53f, 1.5f)
                curveToRelative(1.05f, 0.42f, 4.2f, -0.59f, 5.02f, -0.67f)
                curveToRelative(0.82f, -0.07f, 2.97f, 0.03f, 1.96f, -2.18f)
                curveToRelative(-0.68f, -1.48f, -1.23f, -2.08f, -1.66f, -1.81f)
                lineToRelative(-1.2f, 0.43f)
                lineToRelative(0.07f, 0.78f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(245.15f, 227.99f)
                curveToRelative(-1.76f, 1.18f, -3f, 1.79f, -3.72f, 1.83f)
                curveToRelative(-1.08f, 0.06f, -1.62f, 1.02f, -0.58f, 1.48f)
                curveToRelative(1.03f, 0.45f, 4.22f, -0.44f, 5.04f, -0.49f)
                curveToRelative(0.82f, -0.04f, 2.96f, 0.13f, 2.03f, -2.11f)
                curveToRelative(-0.62f, -1.5f, -1.15f, -2.12f, -1.6f, -1.87f)
                lineToRelative(-0.83f, -0.21f)
                lineToRelative(-0.34f, 1.37f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(254.22f, 181.07f)
                curveToRelative(3.11f, -0.89f, 3.94f, 0.48f, 3.94f, 1.06f)
                curveToRelative(0f, 0.39f, -0.1f, 1.03f, -0.29f, 1.93f)
                curveToRelative(0.38f, -0.17f, 0.65f, -0.3f, 0.81f, -0.39f)
                curveToRelative(0.95f, -0.55f, 1.59f, -1.51f, 1.81f, -2.27f)
                curveToRelative(0.42f, -1.41f, -0.81f, -4.39f, -4.02f, -3.95f)
                curveToRelative(-1.12f, -0.21f, -1.29f, -1.88f, -3.23f, -0.85f)
                curveToRelative(-1.94f, 1.02f, -2.6f, 0.24f, -2.6f, 1.28f)
                reflectiveCurveToRelative(0.08f, 4.28f, 3.59f, 3.18f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFC5B3)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(243.99f, 196.74f)
                curveToRelative(-6.34f, 7.55f, -6.63f, 12.59f, -0.9f, 15.13f)
                curveToRelative(5.35f, 2.36f, 8.61f, 1.16f, 8.61f, 0f)
                curveToRelative(0f, -1.17f, -3.2f, -2.23f, -6.35f, -4.11f)
                curveToRelative(-2.1f, -1.25f, -0.81f, -4.24f, 3.87f, -8.96f)
                lineToRelative(-5.23f, -2.06f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5C5CBB)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(244.57f, 226.95f)
                curveToRelative(3.85f, -19.49f, 7.82f, -27.65f, 11.89f, -24.49f)
                curveToRelative(4.07f, 3.17f, 6.66f, 7.99f, 7.77f, 14.47f)
                curveToRelative(0.05f, 0.2f, 1f, 0.07f, 2.88f, -0.38f)
                curveToRelative(1.88f, -0.45f, 2.93f, -0.32f, 3.18f, 0.38f)
                curveToRelative(0f, 5.7f, -2.57f, 8.76f, -7.72f, 9.18f)
                curveToRelative(-11.93f, 0.98f, -7.02f, -5.85f, -7.02f, -12.89f)
                curveToRelative(0f, 5.62f, -7.68f, 13.02f, -7.68f, 14.34f)
                curveToRelative(-1.86f, 0.32f, -2.96f, 0.11f, -3.29f, -0.63f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF6E6EE9),
                        1f to Color(0xFF5B5BEA)
                    ),
                    start = Offset(266.79f, 217.43f),
                    end = Offset(256.82f, 193.11f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(252.81f, 189.74f)
                curveToRelative(1.07f, 0f, 1.6f, 2.14f, 5.41f, 0f)
                curveToRelative(1.17f, -0.07f, 5.49f, 1.79f, 9.32f, 7.46f)
                curveToRelative(2.56f, 3.78f, 3.69f, 10.35f, 3.4f, 19.73f)
                curveToRelative(-0.53f, 0.88f, -2.57f, 1.32f, -6.11f, 1.32f)
                curveToRelative(-3.55f, 0f, -5.75f, -3.98f, -6.61f, -11.95f)
                curveToRelative(-5.29f, -2.37f, -8.92f, -4.06f, -10.89f, -5.09f)
                curveToRelative(-2.96f, -1.54f, -5.01f, -2.59f, -5.62f, -3.53f)
                curveToRelative(-0.61f, -0.94f, 1.79f, -2.75f, 4.41f, -4.85f)
                curveToRelative(2.63f, -2.11f, 6.21f, -3.09f, 6.68f, -3.09f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5C5CBB)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(248.22f, 213.49f)
                curveToRelative(1.76f, -8.66f, 4.07f, -12.56f, 6.91f, -11.7f)
                curveToRelative(4.26f, 1.29f, 5.06f, 16.33f, 4.66f, 17f)
                curveToRelative(-0.27f, 0.44f, -4.13f, -1.32f, -11.56f, -5.3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5C5CBB)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(255f, 209.92f)
                curveToRelative(-3.91f, -8.98f, -7.16f, -11.23f, -9.75f, -6.74f)
                curveToRelative(-2.59f, 4.49f, -4.31f, 12.11f, -5.16f, 22.85f)
                horizontalLineToRelative(4.29f)
                lineToRelative(3.16f, -12.4f)
                curveToRelative(0.91f, 9.49f, 6.07f, 13.63f, 15.48f, 12.4f)
                curveToRelative(2.88f, -1.56f, 0.2f, -6.93f, -8.03f, -16.12f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(233.28f, 207.59f),
                    end = Offset(258.37f, 217.61f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(260.19f, 201.79f)
                curveToRelative(-2.19f, 6.57f, -3.73f, 9.86f, -4.64f, 9.86f)
                curveToRelative(-1.07f, 0f, -6.97f, -0.95f, -10.19f, -2.48f)
                curveToRelative(-0.9f, -0.43f, -0.82f, -1.76f, -2.25f, -2.46f)
                curveToRelative(-1.35f, -0.66f, -6.45f, 0.27f, -1.84f, 3.65f)
                curveToRelative(4.61f, 3.39f, 13.04f, 6.66f, 16.17f, 6.13f)
                curveToRelative(3.13f, -0.54f, 7.23f, -6.94f, 8.08f, -12.06f)
                curveToRelative(0.3f, -1.32f, -1.35f, -1.68f, -4.95f, -1.1f)
                lineToRelative(-0.37f, -1.54f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x004949E2),
                        1f to Color(0xFF4949E2)
                    ),
                    start = Offset(262.76f, 195.1f),
                    end = Offset(262.76f, 202.01f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(259.96f, 194.42f)
                curveToRelative(-1.22f, 5.94f, -1.72f, 9.08f, -1.51f, 9.4f)
                curveToRelative(0.32f, 0.49f, 6.81f, 2.72f, 7.49f, 2.45f)
                curveToRelative(1.25f, -0.47f, 1.41f, -6.06f, 0.85f, -9.54f)
                curveToRelative(-0.37f, -2.32f, -2.65f, -3.09f, -6.84f, -2.31f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(109.42f, 208.01f)
                horizontalLineToRelative(1.41f)
                arcToRelative(0.9f, 0.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.9f, 0.9f)
                verticalLineToRelative(14.55f)
                arcToRelative(0.9f, 0.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.9f, 0.9f)
                horizontalLineToRelative(-1.41f)
                arcToRelative(0.9f, 0.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.9f, -0.9f)
                verticalLineToRelative(-14.55f)
                arcToRelative(0.9f, 0.9f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.9f, -0.9f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(110.55f, 184.27f),
                    end = Offset(110.55f, 215.68f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(106.83f, 188.5f)
                curveToRelative(-2.98f, 6.11f, -13.23f, 24.85f, 1.14f, 26.95f)
                curveToRelative(14.37f, 2.1f, 13.73f, -10.37f, 11.21f, -14.84f)
                curveToRelative(-2.52f, -4.46f, -5.37f, -6.96f, -5.37f, -12.11f)
                curveToRelative(0f, -5.14f, -4f, -6.11f, -6.98f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(287.37f, 206.97f)
                horizontalLineToRelative(0.87f)
                arcToRelative(0.45f, 0.45f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.45f, 0.45f)
                verticalLineToRelative(7.9f)
                arcToRelative(0.45f, 0.45f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.45f, 0.45f)
                horizontalLineToRelative(-0.87f)
                arcToRelative(0.45f, 0.45f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.45f, -0.45f)
                verticalLineToRelative(-7.9f)
                arcToRelative(0.45f, 0.45f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.45f, -0.45f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(288.25f, 193.77f),
                    end = Offset(288.25f, 211.37f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(286.13f, 196.14f)
                curveToRelative(-1.71f, 3.42f, -7.58f, 13.92f, 0.65f, 15.1f)
                curveToRelative(8.23f, 1.18f, 7.86f, -5.81f, 6.42f, -8.31f)
                curveToRelative(-1.44f, -2.5f, -3.07f, -3.9f, -3.07f, -6.78f)
                curveToRelative(0f, -2.88f, -2.29f, -3.42f, -3.99f, 0f)
                close()
            }
        }.build()

        return _NoOrderYet!!
    }

@Suppress("ObjectPropertyName")
private var _NoOrderYet: ImageVector? = null
