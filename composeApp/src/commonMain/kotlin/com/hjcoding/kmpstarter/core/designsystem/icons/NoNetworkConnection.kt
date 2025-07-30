package com.hjcoding.kmpstarter.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoNetworkConnection: ImageVector
    get() {
        if (_NoNetworkConnection != null) {
            return _NoNetworkConnection!!
        }
        _NoNetworkConnection = ImageVector.Builder(
            name = "NoNetworkConnection",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0f)
                    horizontalLineToRelative(400f)
                    verticalLineToRelative(300f)
                    horizontalLineTo(0f)
                    close()
                }
            ) {
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFF6F6F7),
                            1f to Color(0x00FCFCFF)
                        ),
                        start = Offset(295.24f, 57.41f),
                        end = Offset(295.24f, 108.48f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(212.83f, 79.26f)
                    curveToRelative(14.39f, -2.3f, 20.21f, -4.03f, 34.26f, -17.45f)
                    curveToRelative(14.05f, -13.43f, 28.29f, 6.16f, 49.42f, -1.7f)
                    curveToRelative(21.13f, -7.86f, 23.06f, -17.39f, 55.37f, 11.78f)
                    curveToRelative(14.9f, 12.4f, 26.74f, 7.49f, 34.04f, 12.4f)
                    curveToRelative(4.87f, 3.27f, 9.56f, 11.34f, 14.07f, 24.19f)
                    horizontalLineTo(212.83f)
                    curveToRelative(-14.9f, -5.14f, -22.35f, -9.41f, -22.35f, -12.81f)
                    curveToRelative(0f, -5.1f, 7.97f, -14.1f, 22.35f, -16.4f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFF5F5F7),
                            1f to Color(0xFFEBEBEF)
                        ),
                        start = Offset(197.87f, 53.3f),
                        end = Offset(199.47f, 66.41f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(188.13f, 48.48f)
                    curveToRelative(5.41f, -0.22f, 11.21f, 1.05f, 17.41f, 3.81f)
                    curveToRelative(5.15f, 2.29f, 9.98f, 5.76f, 14.48f, 10.39f)
                    lineToRelative(-15.29f, 34.33f)
                    lineToRelative(-31.89f, -14.19f)
                    lineToRelative(15.29f, -34.33f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFAF5F5F7),
                            1f to Color(0xFFEBEBEF)
                        ),
                        start = Offset(61.54f, 105.7f),
                        end = Offset(67.92f, 117.3f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(66.49f, 96.06f)
                    curveToRelative(-4.47f, 3.02f, -8.4f, 7.47f, -11.76f, 13.37f)
                    curveToRelative(-2.8f, 4.91f, -4.66f, 10.57f, -5.57f, 16.98f)
                    lineToRelative(32.33f, 18.87f)
                    lineToRelative(17.33f, -30.35f)
                    lineTo(66.49f, 96.06f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFAFAFB)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(49.08f, 126.39f)
                    curveToRelative(1.91f, 1.12f, 7.12f, -4.35f, 11.9f, -12.73f)
                    curveToRelative(4.79f, -8.38f, 7.41f, -16.48f, 5.5f, -17.59f)
                    curveToRelative(-1.91f, -1.12f, -7.64f, 5.17f, -12.43f, 13.55f)
                    curveToRelative(-4.79f, 8.38f, -6.89f, 15.66f, -4.98f, 16.78f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFE5E5EC)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(50.6f, 121.46f)
                    curveToRelative(1.27f, 0.74f, 5.12f, -3.56f, 8.8f, -10f)
                    curveToRelative(3.68f, -6.44f, 5.85f, -12.58f, 4.58f, -13.32f)
                    curveToRelative(-1.28f, -0.74f, -5.52f, 4.18f, -9.2f, 10.63f)
                    curveToRelative(-3.68f, 6.44f, -5.45f, 11.95f, -4.18f, 12.69f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFF9F9FC),
                            1f to Color(0xFFEDEDF2)
                        ),
                        start = Offset(134.19f, 217.37f),
                        end = Offset(316.18f, 252.48f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(209.82f, 251.71f)
                    curveToRelative(147.79f, 0f, 67.38f, -11.5f, 95.55f, -18.74f)
                    curveToRelative(25.34f, -6.51f, 61.87f, -8.3f, 61.87f, -17.06f)
                    curveToRelative(0f, -18.51f, -66.36f, -31.25f, -157.41f, -31.25f)
                    curveToRelative(-91.06f, 0f, -164.87f, 15.01f, -164.87f, 33.52f)
                    curveToRelative(0f, 18.51f, 73.82f, 33.52f, 164.87f, 33.52f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFFD2C4),
                            1f to Color(0xFFFFB8A3)
                        ),
                        start = Offset(208.48f, 134.18f),
                        end = Offset(231.19f, 113.03f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(231.04f, 110.85f)
                    curveToRelative(-3.68f, 8.36f, -5.93f, 13.64f, -6.74f, 15.84f)
                    curveToRelative(-0.38f, 0.91f, -5.25f, 3.19f, -14.61f, 6.82f)
                    curveToRelative(-3.14f, 0.28f, -4.93f, 1.22f, -5.39f, 2.84f)
                    curveToRelative(-0.26f, 1.03f, -0.14f, 2.81f, 1.46f, 2.95f)
                    curveToRelative(1.07f, 0.1f, 2.58f, -0.71f, 4.55f, -2.44f)
                    curveToRelative(10.46f, 0.38f, 16.68f, -1.39f, 18.67f, -5.3f)
                    curveToRelative(1.98f, -3.92f, 5f, -9.98f, 9.06f, -18.19f)
                    lineToRelative(-6.51f, -3.22f)
                    lineToRelative(-0.49f, 0.7f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFFD2C4),
                            1f to Color(0xFFFFB8A3)
                        ),
                        start = Offset(266.38f, 82.93f),
                        end = Offset(271.56f, 100.14f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(265.41f, 98.43f)
                    curveToRelative(0f, -1.51f, 6.02f, -6.69f, 7.93f, -8.77f)
                    curveToRelative(0.53f, -0.09f, -9.59f, -1.9f, -16.49f, -6.14f)
                    curveToRelative(-4.6f, -2.82f, -4.95f, -3.75f, -1.07f, -2.78f)
                    curveToRelative(9.81f, 1.85f, 17.12f, 3.49f, 21.94f, 4.91f)
                    curveToRelative(4.75f, 2.17f, -0.09f, 9.28f, -4.81f, 17.91f)
                    reflectiveCurveToRelative(-7.49f, -3.63f, -7.49f, -5.14f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF3E3E6E)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(238.41f, 199.45f)
                    curveToRelative(-3.1f, 2.28f, -5.27f, 3.42f, -6.5f, 3.42f)
                    curveToRelative(-1.85f, 0f, -2.85f, 1.97f, -1.13f, 3.03f)
                    curveToRelative(1.72f, 1.06f, 7.22f, -0.47f, 8.63f, -0.47f)
                    curveToRelative(1.41f, 0f, 5.04f, 0.61f, 3.65f, -4.2f)
                    curveToRelative(-0.93f, -3.2f, -1.78f, -4.57f, -2.55f, -4.09f)
                    lineToRelative(-2.1f, 0.68f)
                    verticalLineToRelative(1.63f)
                    close()
                    moveTo(264.18f, 199.45f)
                    curveToRelative(3.1f, 2.28f, 5.27f, 3.42f, 6.5f, 3.42f)
                    curveToRelative(1.85f, 0f, 2.85f, 1.97f, 1.13f, 3.03f)
                    curveToRelative(-1.72f, 1.06f, -7.22f, -0.47f, -8.63f, -0.47f)
                    curveToRelative(-1.41f, 0f, -5.04f, 0.61f, -3.65f, -4.2f)
                    curveToRelative(0.93f, -3.2f, 1.78f, -4.57f, 2.55f, -4.09f)
                    lineToRelative(2.1f, 0.68f)
                    verticalLineToRelative(1.63f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF7878C3),
                            1f to Color(0xFF5C5CBB)
                        ),
                        start = Offset(244.24f, 194.9f),
                        end = Offset(254.96f, 152.34f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(238.33f, 142.94f)
                    curveToRelative(-1.8f, 13.46f, -2.33f, 27.2f, -1.58f, 41.22f)
                    curveToRelative(1.05f, 15.13f, -0.05f, 14.79f, 1.58f, 14.79f)
                    curveToRelative(0.62f, 0f, 3.13f, 0.34f, 3.68f, -0.66f)
                    curveToRelative(1.33f, -2.38f, 3.47f, -22.37f, 2.64f, -26.39f)
                    curveToRelative(-0.08f, -0.6f, 8.24f, -19.36f, 8.24f, -26.66f)
                    curveToRelative(-0.31f, -1.42f, -5.16f, -2.19f, -14.57f, -2.31f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFF7878C3),
                            1f to Color(0xFF5C5CBB)
                        ),
                        start = Offset(258.07f, 196.34f),
                        end = Offset(253.66f, 145.46f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(264.01f, 142.94f)
                    curveToRelative(1.81f, 13.46f, 2.33f, 27.2f, 1.59f, 41.22f)
                    curveToRelative(-1.05f, 15.13f, 0.05f, 14.79f, -1.59f, 14.79f)
                    curveToRelative(-0.62f, 0f, -3.13f, 0.34f, -3.68f, -0.66f)
                    curveToRelative(-1.33f, -2.38f, -3.47f, -22.37f, -2.64f, -26.39f)
                    curveToRelative(0.08f, -0.6f, -8.24f, -19.36f, -8.24f, -26.66f)
                    curveToRelative(0.31f, -1.42f, 5.16f, -2.19f, 14.56f, -2.31f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFFD2C4),
                            1f to Color(0xFFFFB8A3)
                        ),
                        start = Offset(248.66f, 83.64f),
                        end = Offset(257.74f, 93.89f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(246.77f, 81.73f)
                    curveToRelative(-1.14f, 5.76f, -0.6f, 9.15f, 1.61f, 10.17f)
                    curveToRelative(2.9f, 1.22f, 0.85f, 3.74f, 0.26f, 4.05f)
                    curveToRelative(-0.39f, 0.21f, -0.29f, 0.91f, 0.29f, 2.1f)
                    curveToRelative(1.83f, 0.98f, 3.18f, 1.37f, 4.04f, 1.17f)
                    curveToRelative(0.86f, -0.2f, 1.91f, -1.18f, 3.15f, -2.94f)
                    curveToRelative(-2.31f, -1.68f, -3.11f, -3.03f, -2.41f, -4.04f)
                    curveToRelative(0.7f, -1.01f, 1.76f, -2.07f, 3.19f, -3.17f)
                    curveToRelative(1.39f, -1.08f, 1.33f, -1.89f, -0.16f, -2.45f)
                    curveToRelative(0.36f, -1.02f, 0.5f, -2.18f, 0.4f, -3.48f)
                    lineToRelative(-4.86f, -1.4f)
                    lineToRelative(-4.95f, -1.09f)
                    lineToRelative(-0.56f, 1.09f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF5B5BEA)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(249.07f, 95.48f)
                    curveToRelative(-9.18f, 0.19f, -15.57f, 5.35f, -19.17f, 15.47f)
                    curveToRelative(0.48f, 0.18f, 7.19f, 3.44f, 7.19f, 5.56f)
                    curveToRelative(0f, 2.12f, -3.72f, 23.25f, -3.26f, 27.66f)
                    curveToRelative(0.46f, 4.41f, 18.26f, 8.56f, 35.69f, 2.75f)
                    curveToRelative(1.19f, -1.16f, 0.07f, -26.7f, -2.99f, -33.48f)
                    curveToRelative(-0.16f, -0.28f, 7.5f, -7.39f, 6.97f, -9.95f)
                    curveToRelative(-0.54f, -2.56f, -5.29f, -7.08f, -7.89f, -7.08f)
                    reflectiveCurveToRelative(-8.9f, 0.41f, -10.36f, -0.92f)
                    curveToRelative(-0.62f, -0.56f, -0f, 1.82f, -3.21f, 1.82f)
                    curveToRelative(-1.28f, 0f, -2.27f, -0.61f, -2.96f, -1.82f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF353564)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(250.02f, 83.04f)
                    curveToRelative(4.74f, -1.37f, 5.99f, 0.73f, 5.99f, 1.62f)
                    curveToRelative(0f, 0.59f, -0.15f, 1.57f, -0.45f, 2.94f)
                    curveToRelative(0.58f, -0.26f, 0.99f, -0.46f, 1.23f, -0.6f)
                    curveToRelative(1.45f, -0.83f, 2.41f, -2.31f, 2.76f, -3.46f)
                    curveToRelative(0.64f, -2.15f, -1.24f, -6.7f, -6.12f, -6.03f)
                    curveToRelative(-1.7f, -0.33f, -1.97f, -2.86f, -4.93f, -1.3f)
                    curveToRelative(-2.95f, 1.56f, -3.95f, 0.36f, -3.95f, 1.96f)
                    reflectiveCurveToRelative(0.12f, 6.53f, 5.46f, 4.86f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFF0F0F3)),
                    fillAlpha = 0.9f,
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(316.83f, 168.27f)
                    horizontalLineToRelative(2.14f)
                    curveToRelative(0.76f, 0f, 1.37f, 0.61f, 1.37f, 1.37f)
                    verticalLineToRelative(22.18f)
                    arcToRelative(1.37f, 1.37f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.37f, 1.37f)
                    horizontalLineToRelative(-2.14f)
                    arcToRelative(1.37f, 1.37f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.37f, -1.37f)
                    verticalLineToRelative(-22.18f)
                    curveToRelative(0f, -0.76f, 0.61f, -1.37f, 1.37f, -1.37f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFEBEBEE),
                            1f to Color(0xFFFCFCFD)
                        ),
                        start = Offset(318.55f, 132.09f),
                        end = Offset(318.55f, 179.96f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(312.89f, 138.54f)
                    curveToRelative(-4.54f, 9.31f, -20.17f, 37.86f, 1.73f, 41.06f)
                    curveToRelative(21.9f, 3.2f, 20.92f, -15.81f, 17.08f, -22.61f)
                    curveToRelative(-3.84f, -6.8f, -8.18f, -10.61f, -8.18f, -18.45f)
                    curveToRelative(0f, -7.84f, -6.1f, -9.31f, -10.64f, 0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFFFBFBFE)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(194.97f, 218.95f)
                    horizontalLineToRelative(1.68f)
                    curveToRelative(0.38f, 0f, 0.69f, 0.31f, 0.69f, 0.69f)
                    verticalLineToRelative(12.34f)
                    arcToRelative(0.69f, 0.69f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.69f, 0.69f)
                    horizontalLineToRelative(-1.68f)
                    arcToRelative(0.69f, 0.69f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.69f, -0.69f)
                    verticalLineToRelative(-12.34f)
                    curveToRelative(0f, -0.38f, 0.31f, -0.69f, 0.69f, -0.69f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFEBEBEE),
                            1f to Color(0xFFFCFCFD)
                        ),
                        start = Offset(196.19f, 197.62f),
                        end = Offset(196.19f, 224.29f)
                    ),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(193.24f, 201.21f)
                    curveToRelative(-2.37f, 5.19f, -10.54f, 21.09f, 0.9f, 22.88f)
                    curveToRelative(11.44f, 1.78f, 10.94f, -8.81f, 8.93f, -12.6f)
                    curveToRelative(-2.01f, -3.79f, -4.27f, -5.91f, -4.27f, -10.28f)
                    reflectiveCurveToRelative(-3.19f, -5.19f, -5.56f, 0f)
                    close()
                }
                path(
                    fill = Brush.linearGradient(
                        colorStops = arrayOf(
                            0f to Color(0xFFFAC251),
                            1f to Color(0xFFF5A067)
                        ),
                        start = Offset(32.94f, 94.7f),
                        end = Offset(44.32f, 106.41f)
                    )
                ) {
                    moveTo(40.62f, 107.4f)
                    arcToRelative(8.05f, 8.05f, 0f, isMoreThanHalf = true, isPositiveArc = false, -4.17f, -15.56f)
                    arcToRelative(8.05f, 8.05f, 0f, isMoreThanHalf = true, isPositiveArc = false, 4.17f, 15.56f)
                    close()
                }
                path(
                    fillAlpha = 0.7f,
                    stroke = SolidColor(Color(0xFFE6B24A)),
                    strokeAlpha = 0.7f,
                    strokeLineWidth = 2.286f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(32.78f, 78.76f)
                    curveToRelative(-11.46f, 3.07f, -18.34f, 14.56f, -15.36f, 25.66f)
                }
                path(
                    fillAlpha = 0.3f,
                    stroke = SolidColor(Color(0xFFE4B14C)),
                    strokeAlpha = 0.3f,
                    strokeLineWidth = 2.286f,
                    strokeLineCap = StrokeCap.Round
                ) {
                    moveTo(28.71f, 65.28f)
                    curveTo(9.37f, 70.46f, -2.18f, 90.04f, 2.9f, 109.02f)
                }
            }
        }.build()

        return _NoNetworkConnection!!
    }

@Suppress("ObjectPropertyName")
private var _NoNetworkConnection: ImageVector? = null
