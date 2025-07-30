package com.hjcoding.kmpstarter.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.LoadingFailed: ImageVector
    get() {
        if (_LoadingFailed != null) {
            return _LoadingFailed!!
        }
        _LoadingFailed = ImageVector.Builder(
            name = "LoadingFailed",
            defaultWidth = 400.dp,
            defaultHeight = 300.dp,
            viewportWidth = 400f,
            viewportHeight = 300f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF8F8FB),
                        1f to Color(0xFFF1F1F5)
                    ),
                    start = Offset(145.16f, 210.05f),
                    end = Offset(254.93f, 220.81f)
                )
            ) {
                moveTo(193.39f, 229.95f)
                curveToRelative(48.9f, 0f, 88.55f, -8.68f, 88.55f, -19.38f)
                reflectiveCurveToRelative(-39.64f, -19.38f, -88.55f, -19.38f)
                curveToRelative(-48.9f, 0f, -88.55f, 8.68f, -88.55f, 19.38f)
                curveToRelative(0f, 10.7f, 39.64f, 19.38f, 88.55f, 19.38f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(274.09f, 154.18f),
                    end = Offset(274.09f, 191.42f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(219.97f, 172.12f)
                curveToRelative(9.45f, -1.52f, 13.27f, -2.66f, 22.5f, -11.53f)
                curveToRelative(9.23f, -8.87f, 18.58f, 4.07f, 32.46f, -1.12f)
                curveToRelative(13.88f, -5.2f, 15.14f, -11.48f, 36.37f, 7.78f)
                curveToRelative(9.78f, 8.19f, 17.56f, 4.95f, 22.36f, 8.19f)
                curveToRelative(3.2f, 2.16f, 6.28f, 7.49f, 9.24f, 15.98f)
                horizontalLineTo(219.97f)
                curveToRelative(-9.79f, -3.4f, -14.68f, -6.22f, -14.68f, -8.46f)
                curveToRelative(0f, -3.37f, 5.23f, -9.32f, 14.68f, -10.83f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(288.72f, 78.5f),
                    end = Offset(288.72f, 117.27f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(288.02f, 78.5f)
                curveToRelative(7.75f, 0f, 14.4f, 4.07f, 17.2f, 9.85f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.37f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineToRelative(-35.88f)
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
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(136.65f, 117.18f),
                    end = Offset(136.65f, 154.42f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(82.52f, 135.12f)
                curveToRelative(9.45f, -1.52f, 13.27f, -2.66f, 22.5f, -11.53f)
                curveToRelative(9.23f, -8.87f, 18.58f, 4.07f, 32.46f, -1.13f)
                curveToRelative(13.88f, -5.19f, 15.14f, -11.48f, 36.37f, 7.78f)
                curveToRelative(9.78f, 8.19f, 17.56f, 4.95f, 22.36f, 8.19f)
                curveToRelative(3.2f, 2.16f, 6.28f, 7.49f, 9.24f, 15.98f)
                horizontalLineTo(82.52f)
                curveToRelative(-9.79f, -3.4f, -14.68f, -6.22f, -14.68f, -8.47f)
                curveToRelative(0f, -3.37f, 5.23f, -9.31f, 14.68f, -10.83f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE3E3EA)
                    ),
                    start = Offset(168.17f, 103.67f),
                    end = Offset(138.11f, 203.03f)
                )
            ) {
                moveTo(118.06f, 85.46f)
                verticalLineTo(203.52f)
                horizontalLineToRelative(69.07f)
                lineToRelative(15.52f, -33.06f)
                lineToRelative(-18.9f, -44.41f)
                lineToRelative(18.9f, -40.6f)
                horizontalLineToRelative(-84.58f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE3E3EA)
                    ),
                    start = Offset(235.37f, 114.67f),
                    end = Offset(239.55f, 209.43f)
                )
            ) {
                moveToRelative(241.51f, 89.72f)
                lineToRelative(-29.14f, 40.01f)
                lineToRelative(11.58f, 41.36f)
                lineToRelative(-18.69f, 25.18f)
                lineToRelative(53.49f, 9.58f)
                lineToRelative(22.98f, -106.33f)
                lineToRelative(-40.22f, -9.8f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(205.09f, 125.33f),
                    end = Offset(211.25f, 132.13f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(203.92f, 124.07f)
                curveToRelative(-0.77f, 3.82f, -0.41f, 6.06f, 1.09f, 6.73f)
                curveToRelative(1.96f, 0.81f, 0.07f, 2.69f, -0.33f, 2.9f)
                curveToRelative(-0.26f, 0.14f, -0.03f, 0.53f, 0.7f, 1.17f)
                curveToRelative(1.24f, 0.65f, 2.15f, 0.91f, 2.73f, 0.77f)
                curveToRelative(0.58f, -0.13f, 1.29f, -0.78f, 2.13f, -1.95f)
                curveToRelative(-1.56f, -1.11f, -2.11f, -2f, -1.63f, -2.67f)
                curveToRelative(0.47f, -0.67f, 1.2f, -1.37f, 2.16f, -2.1f)
                curveToRelative(0.94f, -0.71f, 0.9f, -1.25f, -0.11f, -1.62f)
                curveToRelative(0.25f, -0.67f, 0.34f, -1.44f, 0.27f, -2.3f)
                lineToRelative(-3.29f, -0.93f)
                lineToRelative(-3.35f, -0.72f)
                lineToRelative(-0.38f, 0.72f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(206.46f, 124.7f)
                curveToRelative(3.31f, -0.91f, 4.19f, 0.49f, 4.19f, 1.08f)
                curveToRelative(0f, 0.4f, -0.1f, 1.05f, -0.31f, 1.96f)
                arcToRelative(11.4f, 11.4f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.86f, -0.4f)
                curveToRelative(1.02f, -0.56f, 1.69f, -1.54f, 1.93f, -2.31f)
                curveToRelative(0.45f, -1.43f, -0.87f, -4.47f, -4.28f, -4.02f)
                curveToRelative(-1.19f, -0.22f, -1.38f, -1.91f, -3.44f, -0.87f)
                reflectiveCurveToRelative(-2.76f, 0.24f, -2.76f, 1.31f)
                curveToRelative(0f, 1.07f, 0.09f, 4.36f, 3.82f, 3.24f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(199.57f, 199.53f)
                curveToRelative(-1.79f, 1.1f, -3.05f, 1.65f, -3.76f, 1.65f)
                curveToRelative(-1.07f, 0f, -1.64f, 0.95f, -0.65f, 1.46f)
                reflectiveCurveToRelative(4.17f, -0.23f, 4.99f, -0.23f)
                curveToRelative(0.81f, 0f, 2.91f, 0.29f, 2.11f, -2.02f)
                curveToRelative(-0.54f, -1.54f, -1.03f, -2.2f, -1.48f, -1.97f)
                lineToRelative(-1.21f, 0.32f)
                verticalLineToRelative(0.79f)
                close()
                moveTo(211.88f, 199.42f)
                curveToRelative(-1.24f, 1.7f, -2.18f, 2.66f, -2.83f, 2.87f)
                curveToRelative(-0.97f, 0.31f, -1.16f, 1.5f, -0.08f, 1.76f)
                curveToRelative(1.08f, 0.26f, 3.7f, -1.46f, 4.44f, -1.7f)
                curveToRelative(0.74f, -0.24f, 2.74f, -0.54f, 1.2f, -2.79f)
                curveToRelative(-1.03f, -1.5f, -1.71f, -2.06f, -2.03f, -1.68f)
                lineToRelative(-0.99f, 0.7f)
                lineToRelative(0.28f, 0.85f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(201.44f, 197.84f),
                    end = Offset(200.68f, 160.24f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(210.19f, 159.03f)
                curveToRelative(-1.17f, 7.7f, -2.81f, 13.71f, -4.94f, 18.04f)
                curveToRelative(-1.16f, 5.4f, -1.9f, 21.74f, -3.45f, 22.36f)
                curveToRelative(-1.54f, 0.62f, -2.64f, 0.25f, -2.59f, -0.54f)
                curveToRelative(0.06f, -0.79f, -2.06f, -22.7f, -1.82f, -26.1f)
                curveToRelative(0.16f, -2.27f, 0.18f, -6.78f, 0.07f, -13.52f)
                lineToRelative(12.72f, -0.24f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(212.57f, 197.67f),
                    end = Offset(207.77f, 160.36f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(215.61f, 158.15f)
                curveToRelative(0.17f, 7.39f, -0.26f, 15.32f, -1.28f, 23.79f)
                curveToRelative(-0.95f, 10.56f, 1.11f, 16.41f, -0.35f, 17.21f)
                curveToRelative(-1.46f, 0.8f, -2.59f, 0.57f, -2.63f, -0.23f)
                curveToRelative(-0.04f, -0.79f, -4.48f, -22.17f, -4.66f, -25.58f)
                curveToRelative(-0.12f, -2.27f, -0.65f, -6.75f, -1.59f, -13.42f)
                lineToRelative(10.51f, -1.77f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(192.77f, 141.61f),
                    end = Offset(195.46f, 149.08f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(198.26f, 138.61f)
                curveToRelative(-2.04f, 4.43f, -3.28f, 7.24f, -3.73f, 8.4f)
                curveToRelative(-0.21f, 0.49f, -2.9f, 1.69f, -8.08f, 3.62f)
                curveToRelative(-1.74f, 0.15f, -2.73f, 0.65f, -2.98f, 1.5f)
                curveToRelative(-0.14f, 0.55f, -0.08f, 1.49f, 0.81f, 1.57f)
                curveToRelative(0.59f, 0.05f, 1.43f, -0.38f, 2.52f, -1.29f)
                curveToRelative(5.78f, 0.2f, 9.22f, -0.74f, 10.32f, -2.81f)
                curveToRelative(1.1f, -2.08f, 2.77f, -5.3f, 5.01f, -9.65f)
                lineToRelative(-3.6f, -1.71f)
                lineToRelative(-0.27f, 0.37f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(204.67f, 133.01f)
                curveToRelative(1.74f, 1.87f, 3.34f, 1.87f, 4.8f, 0f)
                curveToRelative(0.25f, -0.17f, 5.61f, -0.43f, 9.4f, 5.67f)
                curveToRelative(0.04f, 0.23f, -1.03f, 1.49f, -3.19f, 3.78f)
                horizontalLineToRelative(-0.66f)
                curveToRelative(1.47f, 7.51f, 1.69f, 13.49f, 0.66f, 17.95f)
                curveToRelative(-0.14f, 0.46f, -6.22f, 0.72f, -18.25f, 0.78f)
                curveToRelative(-0.03f, -10.05f, 0.64f, -15.99f, 2.02f, -17.82f)
                curveToRelative(-0.17f, -0.34f, -1.42f, -1.44f, -3.74f, -3.31f)
                curveToRelative(0.73f, -1.56f, 1.84f, -3.06f, 3.31f, -4.5f)
                curveToRelative(1.47f, -1.44f, 3.36f, -2.29f, 5.67f, -2.54f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(216.95f, 138.81f),
                    end = Offset(219.19f, 150.94f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(214.2f, 141.75f)
                curveToRelative(0.11f, 0.85f, 3.42f, 3.76f, 4.66f, 4.8f)
                curveToRelative(0.31f, 0.01f, -6.3f, 5.13f, -6.81f, 5.73f)
                curveToRelative(-1.4f, 1.62f, -0.91f, 3.39f, 0.62f, 3.39f)
                curveToRelative(1.53f, 0f, 1.05f, -2.68f, 1.3f, -2.83f)
                curveToRelative(4.44f, -2.44f, 4.89f, -2.44f, 7.83f, -4.09f)
                curveToRelative(2.56f, -1.36f, -0.86f, -5.47f, -4.16f, -10f)
                curveToRelative(-3.3f, -4.53f, -3.54f, 2.16f, -3.44f, 3.01f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(212.96f, 133.53f)
                curveToRelative(0.91f, 0.43f, 1.54f, 0.75f, 1.89f, 0.96f)
                curveToRelative(0.93f, 0.55f, 1.57f, 1.1f, 1.97f, 1.43f)
                curveToRelative(1.27f, 1.02f, 1.91f, 2.06f, 2.28f, 2.84f)
                curveToRelative(0.31f, 0.54f, -2.95f, 5.45f, -6.14f, 4.89f)
                curveToRelative(-0.44f, -0.02f, -1.13f, -1.03f, -2.08f, -3.04f)
                lineToRelative(2.08f, -7.08f)
                close()
            }
        }.build()

        return _LoadingFailed!!
    }

@Suppress("ObjectPropertyName")
private var _LoadingFailed: ImageVector? = null
