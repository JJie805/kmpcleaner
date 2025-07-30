package com.hjcoding.kmpstarter.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoAccess: ImageVector
    get() {
        if (_NoAccess != null) {
            return _NoAccess!!
        }
        _NoAccess = ImageVector.Builder(
            name = "NoAccess",
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
                    start = Offset(135.76f, 94.27f),
                    end = Offset(135.76f, 130.98f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(81.64f, 112.21f)
                curveToRelative(9.45f, -1.52f, 13.27f, -2.66f, 22.5f, -11.53f)
                curveToRelative(9.23f, -8.87f, 18.58f, 4.07f, 32.46f, -1.12f)
                curveToRelative(13.88f, -5.19f, 15.14f, -11.48f, 36.37f, 7.78f)
                curveToRelative(9.78f, 8.19f, 17.56f, 4.95f, 22.36f, 8.19f)
                curveToRelative(3.2f, 2.16f, 6.28f, 7.49f, 9.24f, 15.98f)
                horizontalLineTo(81.64f)
                curveToRelative(-9.79f, -3.4f, -14.68f, -6.22f, -14.68f, -8.46f)
                curveToRelative(0f, -3.37f, 5.23f, -9.32f, 14.68f, -10.83f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEDEDF2),
                        1f to Color(0xE0F9F9FC)
                    ),
                    start = Offset(132.03f, 202.07f),
                    end = Offset(255.2f, 214.33f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(281.42f, 199.46f)
                curveToRelative(0f, 5.4f, -33.06f, 4.08f, -42.54f, 5.42f)
                curveToRelative(-15.9f, 2.24f, 18.36f, 12.37f, -39.4f, 13.5f)
                curveToRelative(-48.31f, 0.95f, -100.33f, -3.47f, -99.02f, -14.87f)
                curveToRelative(1.31f, -11.4f, 39.74f, -17.61f, 88.39f, -17.61f)
                curveToRelative(48.66f, 0f, 92.56f, 2.21f, 92.56f, 13.56f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEEE),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(71.36f, 165.66f),
                    end = Offset(71.36f, 227.24f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(67.11f, 157.75f)
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
                    start = Offset(100.44f, 155.87f),
                    end = Offset(100.44f, 229.15f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(89.87f, 163.63f)
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
                    start = Offset(88.98f, 149.78f),
                    end = Offset(88.98f, 163.69f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(66.96f, 157.69f)
                lineToRelative(21.53f, -7.91f)
                lineToRelative(22.51f, 6.14f)
                lineToRelative(-21.15f, 7.77f)
                lineToRelative(-22.9f, -6f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(191.47f, 84.64f),
                    end = Offset(191.47f, 189.85f)
                )
            ) {
                moveTo(259.31f, 84.64f)
                horizontalLineTo(123.64f)
                arcToRelative(2.02f, 2.02f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.02f, 2.02f)
                verticalLineToRelative(101.17f)
                curveToRelative(0f, 1.11f, 0.9f, 2.02f, 2.02f, 2.02f)
                horizontalLineToRelative(135.67f)
                arcToRelative(2.02f, 2.02f, 0f, isMoreThanHalf = false, isPositiveArc = false, 2.02f, -2.02f)
                verticalLineTo(86.66f)
                arcToRelative(2.02f, 2.02f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.02f, -2.02f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEBEBF2))) {
                moveTo(169.2f, 155.33f)
                horizontalLineToRelative(-29.11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(29.11f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
                moveTo(153.64f, 164.47f)
                horizontalLineToRelative(-13.56f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(13.56f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
                moveTo(190.58f, 155.33f)
                horizontalLineToRelative(-14.53f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(14.53f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
                moveTo(241.14f, 155.33f)
                horizontalLineToRelative(-45.64f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(45.64f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
                moveTo(233.56f, 164.47f)
                horizontalLineToRelative(-57.5f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, 1f)
                verticalLineToRelative(3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 1f)
                horizontalLineToRelative(57.5f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, -1f)
                verticalLineToRelative(-3.14f)
                arcToRelative(1f, 1f, 0f, isMoreThanHalf = false, isPositiveArc = false, -1f, -1f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBF2),
                        1f to Color(0xFFF8F8FA)
                    ),
                    start = Offset(193.83f, 110.16f),
                    end = Offset(193.83f, 143.61f)
                )
            ) {
                moveTo(193.83f, 144.49f)
                curveToRelative(9.73f, 0f, 17.62f, -7.89f, 17.62f, -17.62f)
                reflectiveCurveToRelative(-7.89f, -17.62f, -17.62f, -17.62f)
                curveToRelative(-9.73f, 0f, -17.62f, 7.89f, -17.62f, 17.62f)
                reflectiveCurveToRelative(7.89f, 17.62f, 17.62f, 17.62f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFF3F3F7)
                    ),
                    start = Offset(261.27f, 99.21f),
                    end = Offset(252.62f, 122.67f)
                )
            ) {
                moveTo(285.97f, 90.77f)
                horizontalLineToRelative(-49.11f)
                arcToRelative(0.73f, 0.73f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.73f, 0.73f)
                verticalLineToRelative(36.72f)
                curveToRelative(0f, 0.4f, 0.32f, 0.73f, 0.73f, 0.73f)
                horizontalLineToRelative(49.11f)
                arcToRelative(0.73f, 0.73f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.73f, -0.73f)
                verticalLineTo(91.5f)
                arcToRelative(0.73f, 0.73f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.73f, -0.73f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEBEBF2))) {
                moveTo(253.22f, 115.01f)
                horizontalLineToRelative(-10.26f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(10.26f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
                moveTo(247.59f, 118.33f)
                horizontalLineToRelative(-4.63f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(0.86f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(4.63f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-0.86f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
                moveTo(260.96f, 115.01f)
                horizontalLineToRelative(-4.98f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(4.98f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
                moveTo(279.25f, 115.01f)
                horizontalLineToRelative(-16.24f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(16.24f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-0.87f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
                moveTo(279.25f, 118.33f)
                horizontalLineToRelative(-23.28f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, 0.5f)
                verticalLineToRelative(0.86f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, 0.5f)
                horizontalLineToRelative(23.28f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.5f, -0.5f)
                verticalLineToRelative(-0.86f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.5f, -0.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFE2E2EA)),
                strokeLineWidth = 3.877f
            ) {
                moveTo(268.44f, 159.8f)
                arcToRelative(7.21f, 7.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.21f, -7.21f)
                arcToRelative(7.21f, 7.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, -7.21f, 7.21f)
                verticalLineToRelative(11.59f)
                arcToRelative(7.21f, 7.21f, 0f, isMoreThanHalf = false, isPositiveArc = false, 14.42f, 0f)
                verticalLineToRelative(-11.59f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF4F4F9),
                        1f to Color(0xFFE2E2E9)
                    ),
                    start = Offset(268.69f, 169.96f),
                    end = Offset(268.69f, 201.76f)
                )
            ) {
                moveTo(280.97f, 164.15f)
                horizontalLineToRelative(-39.47f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.97f, 0.97f)
                verticalLineToRelative(35.67f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.97f, 0.97f)
                horizontalLineToRelative(39.47f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.97f, -0.97f)
                verticalLineToRelative(-35.67f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.97f, -0.97f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF5B942),
                        1f to Color(0xFFFFD278)
                    ),
                    start = Offset(261.23f, 188.32f),
                    end = Offset(258.07f, 178.3f)
                )
            ) {
                moveTo(261.23f, 174.76f)
                arcToRelative(5.3f, 5.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.3f, 5.3f)
                arcToRelative(5.3f, 5.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.89f, 4.72f)
                verticalLineToRelative(5.39f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.97f, 0.97f)
                horizontalLineToRelative(-2.88f)
                arcToRelative(0.97f, 0.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.97f, -0.97f)
                verticalLineToRelative(-5.39f)
                arcToRelative(5.3f, 5.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, -2.89f, -4.72f)
                arcToRelative(5.3f, 5.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.3f, -5.3f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(106.37f, 196.66f)
                curveToRelative(-0.22f, 2.11f, -0.15f, 3.46f, 0.2f, 4.07f)
                curveToRelative(0.53f, 0.91f, -0.14f, 1.9f, -1.14f, 1.33f)
                curveToRelative(-1.01f, -0.57f, -1.84f, -3.67f, -2.24f, -4.36f)
                curveToRelative(-0.4f, -0.69f, -1.74f, -2.32f, 0.99f, -2.87f)
                curveToRelative(1.82f, -0.36f, 2.72f, -0.29f, 2.71f, 0.21f)
                lineToRelative(0.27f, 1.2f)
                lineToRelative(-0.79f, 0.42f)
                close()
                moveTo(151.53f, 198.77f)
                curveToRelative(2.09f, 0.6f, 3.5f, 0.82f, 4.22f, 0.64f)
                curveToRelative(1.09f, -0.27f, 1.9f, 0.5f, 1.02f, 1.24f)
                curveToRelative(-0.89f, 0.74f, -4.3f, 0.83f, -5.13f, 1.03f)
                curveToRelative(-0.83f, 0.2f, -2.89f, 1.01f, -2.64f, -1.41f)
                curveToRelative(0.17f, -1.62f, 0.51f, -2.37f, 1.03f, -2.26f)
                lineToRelative(1.31f, 0.01f)
                lineToRelative(0.19f, 0.76f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(135.19f, 126.1f),
                    end = Offset(132.31f, 131.34f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(137.06f, 123.91f)
                curveToRelative(1.21f, 1.75f, 1f, 5.92f, -0.24f, 6.67f)
                curveToRelative(-0.53f, 0.32f, -1.64f, 0.6f, -2.71f, 0.37f)
                curveToRelative(0.11f, 0.55f, 0.2f, 1.03f, 0.3f, 1.42f)
                curveToRelative(0.27f, 1.16f, 0.74f, 1.95f, 1.4f, 2.37f)
                lineToRelative(-6.71f, -0.36f)
                curveToRelative(1.06f, -0.67f, 1.74f, -1.45f, 2.03f, -2.31f)
                curveToRelative(0.19f, -0.56f, 0.32f, -1.48f, 0.41f, -2.75f)
                curveToRelative(-1.09f, -1.16f, -1.83f, -2.73f, -1.76f, -4.18f)
                curveToRelative(0.17f, -3.56f, 6.07f, -2.98f, 7.28f, -1.23f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(131.6f, 130.49f)
                curveToRelative(-0.79f, -2.36f, -2.95f, -5.15f, -2.78f, -6.22f)
                curveToRelative(0.12f, -0.71f, 0.54f, -1.16f, 1.27f, -1.36f)
                curveToRelative(0.27f, -1.41f, 1.47f, -2.04f, 3.6f, -1.89f)
                curveToRelative(0.47f, 0.03f, 1.16f, 0.47f, 1.64f, 0.43f)
                curveToRelative(0.86f, -0.08f, 1.13f, -0.16f, 1.73f, -0.12f)
                curveToRelative(0.78f, 0.05f, 1.25f, 0.37f, 1.55f, 0.9f)
                curveToRelative(0.37f, 0.66f, 0.06f, 1.62f, -0.83f, 2.26f)
                curveToRelative(-0.8f, 0.57f, -1.68f, 0.29f, -2.27f, 0.51f)
                curveToRelative(-0.4f, 0.15f, -0.96f, 1.01f, -1.68f, 2.59f)
                lineToRelative(-0.15f, -0.48f)
                curveToRelative(-0.38f, -0.96f, -0.83f, -1.32f, -1.36f, -1.09f)
                curveToRelative(-0.53f, 0.24f, -0.63f, 0.66f, -0.31f, 1.27f)
                curveToRelative(0.37f, 1.18f, 0.54f, 1.95f, 0.5f, 2.29f)
                curveToRelative(-0.04f, 0.34f, -0.34f, 0.64f, -0.91f, 0.9f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(111.61f, 160.97f),
                    end = Offset(119.41f, 139.59f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(127.9f, 140.92f)
                curveToRelative(-5.34f, 3.57f, -8.58f, 8.36f, -9.72f, 14.37f)
                curveToRelative(-0.02f, 1.44f, 1.96f, 3.02f, 0.3f, 3.61f)
                curveToRelative(-1.66f, 0.58f, -2f, -1f, -2.04f, -3.01f)
                curveToRelative(-0.04f, -2.01f, -1f, -8.59f, 1.18f, -11.91f)
                curveToRelative(1.46f, -2.21f, 3.84f, -4.66f, 7.14f, -7.35f)
                lineToRelative(3.14f, 4.29f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(131.19f, 141.43f),
                    end = Offset(152.5f, 151.34f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(136.69f, 140.68f)
                curveToRelative(0.77f, 2f, 2.62f, 4.37f, 5.54f, 7.13f)
                curveToRelative(2.73f, 1.72f, 6.43f, 0.03f, 12.5f, -0.83f)
                curveToRelative(3.64f, 0.08f, 5.08f, -2.33f, 4.02f, -2.91f)
                curveToRelative(-1.06f, -0.58f, -3.26f, 0.07f, -3.74f, 0.96f)
                curveToRelative(-0.32f, 0.6f, -3.85f, 0.24f, -10.58f, -1.08f)
                lineToRelative(-2.64f, -4.58f)
                lineToRelative(-5.1f, 1.31f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(138.28f, 146.69f)
                curveToRelative(4.15f, -2.61f, 6.15f, -4.13f, 6f, -4.57f)
                curveToRelative(-0.22f, -0.66f, -2.66f, -4.5f, -4.01f, -5.65f)
                curveToRelative(-1.35f, -1.15f, -3.95f, -3.75f, -4.93f, 0f)
                curveToRelative(-0.65f, 2.5f, 0.33f, 5.91f, 2.94f, 10.22f)
                close()
                moveTo(120.04f, 139.7f)
                curveToRelative(3.05f, 2.43f, 4.75f, 3.51f, 5.11f, 3.25f)
                curveToRelative(0.54f, -0.39f, 6.68f, -3.63f, 7.33f, -5.16f)
                curveToRelative(0.65f, -1.53f, 0.65f, -4.7f, -2.02f, -5.13f)
                curveToRelative(-1.78f, -0.29f, -5.25f, 2.06f, -10.42f, 7.04f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(134.63f, 196.68f),
                    end = Offset(141.73f, 163.06f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(148.8f, 198.47f)
                lineToRelative(3.01f, -0.35f)
                curveToRelative(-0.64f, -5.08f, -2.06f, -11.14f, -4.24f, -18.18f)
                curveToRelative(-2.18f, -7.04f, -4.8f, -13.39f, -7.85f, -19.06f)
                horizontalLineToRelative(-14.83f)
                curveToRelative(3.15f, 4.9f, 5.78f, 8.71f, 7.87f, 11.41f)
                curveToRelative(2.89f, 3.73f, 6.44f, 8.57f, 8.45f, 11.95f)
                curveToRelative(4.2f, 7.04f, 6.73f, 11.79f, 7.58f, 14.23f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(115.66f, 195.08f),
                    end = Offset(123.42f, 160.81f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(105.64f, 194.15f)
                lineToRelative(1f, 2.76f)
                curveToRelative(11.54f, -1.15f, 18.09f, -7.93f, 20.62f, -10.35f)
                curveToRelative(2.52f, -2.42f, 4.54f, -10.94f, 7.77f, -26.58f)
                lineToRelative(-12.38f, -1.36f)
                curveToRelative(-2.04f, 12.81f, -1.58f, 23.67f, -1.82f, 24.21f)
                curveToRelative(-0.24f, 0.54f, -6.24f, 8.08f, -15.17f, 11.31f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(139.98f, 137.86f)
                curveToRelative(0.29f, -1.13f, 0.33f, 2.51f, 0.11f, 10.91f)
                curveToRelative(-0.1f, 3.83f, 2.23f, 11.11f, -0.02f, 12.74f)
                curveToRelative(-3.08f, 2.23f, -19.28f, 2.07f, -19.28f, 0.62f)
                curveToRelative(0f, -4.96f, 1.39f, -12.42f, 4.1f, -18.65f)
                curveToRelative(2.16f, -4.98f, 1.98f, -10.05f, 5.33f, -10.79f)
                curveToRelative(0.83f, -0.19f, 1.82f, 0.75f, 3.19f, 1.02f)
                curveToRelative(1.15f, 0.23f, 1.84f, -0.29f, 2.71f, 0f)
                curveToRelative(2.14f, 0.72f, 3.43f, 2.11f, 3.86f, 4.15f)
                close()
            }
        }.build()

        return _NoAccess!!
    }

@Suppress("ObjectPropertyName")
private var _NoAccess: ImageVector? = null
