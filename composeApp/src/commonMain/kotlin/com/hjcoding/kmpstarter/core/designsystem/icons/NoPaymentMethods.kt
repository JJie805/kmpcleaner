package com.hjcoding.kmpstarter.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoPaymentMethods: ImageVector
    get() {
        if (_NoPaymentMethods != null) {
            return _NoPaymentMethods!!
        }
        _NoPaymentMethods = ImageVector.Builder(
            name = "NoPaymentMethods",
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
                    start = Offset(143.61f, 96.03f),
                    end = Offset(143.61f, 136.56f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(85.39f, 115.56f)
                curveToRelative(10.16f, -1.65f, 14.28f, -2.89f, 24.2f, -12.55f)
                curveToRelative(9.92f, -9.65f, 19.99f, 4.43f, 34.91f, -1.22f)
                curveToRelative(14.93f, -5.65f, 16.29f, -12.5f, 39.12f, 8.47f)
                curveToRelative(10.52f, 8.91f, 18.89f, 5.38f, 24.05f, 8.91f)
                curveToRelative(3.44f, 2.35f, 6.75f, 8.15f, 9.94f, 17.39f)
                horizontalLineTo(85.39f)
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
                    start = Offset(274.01f, 126.87f),
                    end = Offset(274.01f, 156.82f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(228.96f, 141.3f)
                curveToRelative(7.87f, -1.22f, 11.05f, -2.14f, 18.73f, -9.27f)
                curveToRelative(7.68f, -7.13f, 15.47f, 3.27f, 27.01f, -0.9f)
                curveToRelative(11.55f, -4.18f, 12.6f, -9.24f, 30.27f, 6.26f)
                curveToRelative(8.14f, 6.59f, 14.62f, 3.98f, 18.61f, 6.59f)
                curveToRelative(2.66f, 1.74f, 5.23f, 6.02f, 7.69f, 12.85f)
                horizontalLineTo(228.96f)
                curveToRelative(-8.15f, -2.73f, -12.22f, -5f, -12.22f, -6.81f)
                curveToRelative(0f, -2.71f, 4.35f, -7.49f, 12.22f, -8.71f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF0F0F5),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(186.9f, 73.12f),
                    end = Offset(186.9f, 175.26f)
                )
            ) {
                moveTo(143.39f, 73.12f)
                horizontalLineToRelative(77.18f)
                arcToRelative(0.78f, 0.78f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.78f, 0.78f)
                verticalLineToRelative(90.03f)
                curveToRelative(0f, 5.74f, -4.65f, 10.39f, -10.39f, 10.39f)
                horizontalLineTo(144.17f)
                arcToRelative(0.78f, 0.78f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.78f, -0.78f)
                verticalLineTo(73.12f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFE9E9EF)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(165.29f, 146.79f)
                horizontalLineToRelative(25.69f)
                verticalLineToRelative(19.12f)
                horizontalLineToRelative(-25.22f)
                lineToRelative(-0.47f, -19.12f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEF8),
                        1f to Color(0xFFBDBDC8)
                    ),
                    start = Offset(167.67f, 172.65f),
                    end = Offset(167.67f, 149.93f)
                )
            ) {
                moveTo(200.06f, 164.97f)
                arcToRelative(9.35f, 9.35f, 0f, isMoreThanHalf = false, isPositiveArc = false, 8.84f, 9.34f)
                curveToRelative(-0.17f, 0.01f, -0.34f, 0.01f, -0.51f, 0.01f)
                horizontalLineToRelative(-71.55f)
                curveToRelative(-5.74f, 0f, -10.39f, -4.65f, -10.39f, -10.39f)
                verticalLineToRelative(-8.21f)
                horizontalLineToRelative(54.97f)
                arcToRelative(9.3f, 9.3f, 0f, isMoreThanHalf = false, isPositiveArc = true, 9.23f, -8.93f)
                lineToRelative(0.07f, -0f)
                arcToRelative(9.35f, 9.35f, 0f, isMoreThanHalf = false, isPositiveArc = true, 9.34f, 8.93f)
                horizontalLineToRelative(0.01f)
                verticalLineToRelative(9.25f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFE9E9EF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(148.97f, 146.79f),
                    end = Offset(148.97f, 236.47f)
                )
            ) {
                moveTo(124.46f, 146.79f)
                horizontalLineToRelative(56.55f)
                arcToRelative(0.78f, 0.78f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.78f, 0.78f)
                verticalLineToRelative(63.35f)
                arcToRelative(8.46f, 8.46f, 0f, isMoreThanHalf = false, isPositiveArc = true, -8.46f, 8.46f)
                horizontalLineToRelative(-56.41f)
                arcToRelative(0.78f, 0.78f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.78f, -0.78f)
                verticalLineToRelative(-63.49f)
                arcToRelative(8.31f, 8.31f, 0f, isMoreThanHalf = false, isPositiveArc = true, 8.31f, -8.31f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAFAFB),
                        1f to Color(0xFFE3E3EF)
                    ),
                    start = Offset(136.79f, 203.48f),
                    end = Offset(136.79f, 226.4f)
                )
            ) {
                moveTo(164.38f, 203.48f)
                verticalLineToRelative(8.02f)
                arcToRelative(7.88f, 7.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 7.88f, 7.88f)
                horizontalLineTo(116.17f)
                curveToRelative(-8.2f, 0f, -14.84f, -6.65f, -14.84f, -14.84f)
                verticalLineToRelative(-1.05f)
                horizontalLineToRelative(63.06f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(271.13f, 201.15f)
                curveToRelative(0.95f, 0f, 1.72f, 0.77f, 1.72f, 1.72f)
                verticalLineToRelative(14.34f)
                arcToRelative(1.72f, 1.72f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.45f, 0f)
                verticalLineToRelative(-14.34f)
                curveToRelative(0f, -0.95f, 0.77f, -1.72f, 1.72f, -1.72f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEBEBEE),
                        1f to Color(0xFFFCFCFD)
                    ),
                    start = Offset(271.59f, 175.33f),
                    end = Offset(271.59f, 209.49f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(267.6f, 179.93f)
                curveToRelative(-3.2f, 6.65f, -14.22f, 27.03f, 1.22f, 29.31f)
                curveToRelative(15.44f, 2.28f, 14.75f, -11.28f, 12.04f, -16.14f)
                curveToRelative(-2.71f, -4.86f, -5.77f, -7.57f, -5.77f, -13.17f)
                curveToRelative(0f, -5.6f, -4.3f, -6.64f, -7.5f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFF0F0F3)),
                fillAlpha = 0.9f,
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(299.01f, 194.55f)
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
                    start = Offset(299.56f, 177.97f),
                    end = Offset(299.56f, 199.43f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(296.95f, 180.86f)
                curveToRelative(-2.09f, 4.17f, -9.29f, 16.98f, 0.8f, 18.41f)
                curveToRelative(10.08f, 1.43f, 9.63f, -7.09f, 7.86f, -10.14f)
                curveToRelative(-1.77f, -3.05f, -3.77f, -4.76f, -3.77f, -8.27f)
                reflectiveCurveToRelative(-2.81f, -4.17f, -4.9f, 0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFFFFB8A3)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(228.65f, 129.35f)
                curveToRelative(-1.59f, -0.42f, -3.47f, -0.2f, -3.59f, 0.98f)
                curveToRelative(-0.08f, 0.79f, 1f, 1.01f, 3.26f, 0.67f)
                curveToRelative(3.54f, 2.72f, 6.59f, 5.14f, 9.14f, 7.24f)
                curveToRelative(3.83f, 3.16f, 4.08f, 1.31f, 2.33f, -0.33f)
                curveToRelative(-1.75f, -1.64f, 0.09f, -3.7f, -0.82f, -3.89f)
                curveToRelative(-5.82f, -2.84f, -9.26f, -4.39f, -10.32f, -4.67f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xFFFFDE9B)
                    ),
                    start = Offset(223.81f, 126.84f),
                    end = Offset(219.58f, 108.69f)
                )
            ) {
                moveToRelative(224.93f, 118.15f)
                lineToRelative(-1.28f, -0.74f)
                lineToRelative(2.7f, -0.92f)
                arcToRelative(0.65f, 0.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.42f, -0.72f)
                lineToRelative(-0.1f, -0.55f)
                arcToRelative(0.53f, 0.53f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.68f, -0.39f)
                lineToRelative(-3.4f, 1.16f)
                lineToRelative(-0.69f, -3.52f)
                arcToRelative(0.53f, 0.53f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.68f, -0.39f)
                lineToRelative(-0.52f, 0.18f)
                arcToRelative(0.65f, 0.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.42f, 0.72f)
                lineToRelative(0.55f, 2.8f)
                lineToRelative(-1.29f, -0.74f)
                curveToRelative(-0.27f, -0.16f, -0.63f, -0.05f, -0.8f, 0.24f)
                lineToRelative(-0.3f, 0.52f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(1.96f, 1.13f)
                lineToRelative(-0.6f, 1.05f)
                lineToRelative(-1.96f, -1.13f)
                curveToRelative(-0.27f, -0.16f, -0.63f, -0.05f, -0.8f, 0.24f)
                lineToRelative(-0.3f, 0.52f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(1.96f, 1.13f)
                lineToRelative(-0.9f, 1.56f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(0.49f, 0.28f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.9f, -1.56f)
                lineToRelative(1.96f, 1.13f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.3f, -0.52f)
                curveToRelative(0.17f, -0.29f, 0.08f, -0.65f, -0.19f, -0.81f)
                lineToRelative(-1.96f, -1.13f)
                lineToRelative(0.6f, -1.05f)
                lineToRelative(1.96f, 1.13f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.3f, -0.52f)
                curveToRelative(0.17f, -0.29f, 0.08f, -0.65f, -0.19f, -0.81f)
                close()
                moveTo(232.72f, 121.46f)
                curveToRelative(0.93f, -0.09f, 1.21f, -0.47f, 1.57f, -1.08f)
                lineToRelative(2.13f, -3.69f)
                curveToRelative(0.69f, -1.19f, 0.33f, -2.68f, -0.78f, -3.32f)
                lineToRelative(-17.32f, -10f)
                curveToRelative(-1.11f, -0.64f, -2.58f, -0.2f, -3.27f, 0.99f)
                lineToRelative(-2.13f, 3.69f)
                curveToRelative(-0.35f, 0.62f, -0.59f, 1.15f, -0.13f, 1.94f)
                curveToRelative(0.33f, 0.51f, 1.03f, 1.82f, 0.3f, 3.08f)
                curveToRelative(-0.83f, 1.44f, -1.91f, 1.45f, -2.75f, 1.3f)
                lineToRelative(-0.08f, -0f)
                curveToRelative(-0.94f, 0.06f, -1.44f, 0.76f, -1.61f, 1.06f)
                lineToRelative(-2.13f, 3.69f)
                curveToRelative(-0.69f, 1.19f, -0.34f, 2.68f, 0.78f, 3.33f)
                lineToRelative(17.32f, 10f)
                curveToRelative(1.11f, 0.64f, 2.58f, 0.2f, 3.27f, -0.99f)
                lineToRelative(2.13f, -3.69f)
                curveToRelative(0.46f, -0.8f, 0.42f, -1.21f, 0.13f, -1.93f)
                curveToRelative(-0.81f, -1.34f, -0.89f, -2.09f, -0.31f, -3.09f)
                curveToRelative(0.57f, -1f, 1.21f, -1.28f, 2.87f, -1.28f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveToRelative(224.94f, 118.44f)
                lineToRelative(-1.28f, -0.74f)
                lineToRelative(2.7f, -0.92f)
                arcToRelative(0.65f, 0.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.42f, -0.72f)
                lineToRelative(-0.1f, -0.55f)
                arcToRelative(0.53f, 0.53f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.68f, -0.39f)
                lineToRelative(-3.4f, 1.16f)
                lineToRelative(-0.69f, -3.52f)
                arcToRelative(0.53f, 0.53f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.68f, -0.39f)
                lineToRelative(-0.52f, 0.18f)
                arcToRelative(0.65f, 0.65f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.42f, 0.72f)
                lineToRelative(0.55f, 2.8f)
                lineToRelative(-1.29f, -0.74f)
                curveToRelative(-0.27f, -0.16f, -0.63f, -0.05f, -0.8f, 0.24f)
                lineToRelative(-0.3f, 0.52f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(1.96f, 1.13f)
                lineToRelative(-0.6f, 1.05f)
                lineToRelative(-1.96f, -1.13f)
                curveToRelative(-0.27f, -0.16f, -0.63f, -0.05f, -0.8f, 0.24f)
                lineToRelative(-0.3f, 0.52f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(1.96f, 1.13f)
                lineToRelative(-0.9f, 1.56f)
                curveToRelative(-0.17f, 0.29f, -0.08f, 0.65f, 0.19f, 0.81f)
                lineToRelative(0.49f, 0.28f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.9f, -1.56f)
                lineToRelative(1.96f, 1.13f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.3f, -0.52f)
                curveToRelative(0.17f, -0.29f, 0.08f, -0.65f, -0.19f, -0.81f)
                lineToRelative(-1.96f, -1.13f)
                lineToRelative(0.61f, -1.05f)
                lineToRelative(1.96f, 1.13f)
                curveToRelative(0.27f, 0.16f, 0.63f, 0.05f, 0.8f, -0.24f)
                lineToRelative(0.3f, -0.52f)
                curveToRelative(0.17f, -0.29f, 0.08f, -0.65f, -0.19f, -0.81f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFDFDFF),
                        1f to Color(0xFFE7E7ED)
                    ),
                    start = Offset(145.3f, 108.47f),
                    end = Offset(145.3f, 101.32f)
                )
            ) {
                moveTo(168.28f, 101.32f)
                horizontalLineToRelative(-48.46f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.88f, 0.88f)
                verticalLineToRelative(4.41f)
                curveToRelative(0f, 0.49f, 0.39f, 0.88f, 0.88f, 0.88f)
                horizontalLineToRelative(48.46f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.88f, -0.88f)
                verticalLineToRelative(-4.41f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.88f, -0.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFDFDFF),
                        1f to Color(0xFFE7E7ED)
                    ),
                    start = Offset(152.23f, 119.04f),
                    end = Offset(152.23f, 111.89f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(133.92f, 111.89f)
                horizontalLineToRelative(34.8f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.88f, 0.88f)
                verticalLineToRelative(4.41f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, 0.88f)
                horizontalLineToRelative(-34.8f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, -0.88f)
                verticalLineToRelative(-4.41f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.88f, -0.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFFFFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(131.28f, 161.23f),
                    end = Offset(131.28f, 175.33f)
                )
            ) {
                moveTo(137.45f, 161.23f)
                horizontalLineTo(125.11f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.88f, 0.88f)
                verticalLineToRelative(12.34f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.88f, 0.88f)
                horizontalLineToRelative(12.34f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.88f, -0.88f)
                verticalLineTo(162.11f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.88f, -0.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFFFFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(160.35f, 161.23f),
                    end = Offset(160.35f, 165.63f)
                )
            ) {
                moveTo(146.26f, 161.23f)
                horizontalLineToRelative(28.19f)
                curveToRelative(0.49f, 0f, 0.88f, 0.4f, 0.88f, 0.88f)
                verticalLineToRelative(2.64f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, 0.88f)
                horizontalLineToRelative(-28.19f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, -0.88f)
                verticalLineToRelative(-2.64f)
                curveToRelative(0f, -0.49f, 0.39f, -0.88f, 0.88f, -0.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFFFFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(160.35f, 170.92f),
                    end = Offset(160.35f, 175.33f)
                )
            ) {
                moveTo(146.26f, 170.92f)
                horizontalLineToRelative(28.19f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.88f, 0.88f)
                verticalLineToRelative(2.64f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, 0.88f)
                horizontalLineToRelative(-28.19f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, -0.88f)
                verticalLineToRelative(-2.64f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.88f, -0.88f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFFFFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(149.78f, 180.61f),
                    end = Offset(149.78f, 185.02f)
                )
            ) {
                moveTo(125.11f, 180.61f)
                horizontalLineToRelative(49.34f)
                curveToRelative(0.49f, 0f, 0.88f, 0.4f, 0.88f, 0.88f)
                verticalLineToRelative(2.64f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, 0.88f)
                horizontalLineTo(125.11f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.88f, -0.88f)
                verticalLineToRelative(-2.64f)
                curveToRelative(0f, -0.49f, 0.39f, -0.88f, 0.88f, -0.88f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFFE0E0EA)),
                strokeLineWidth = 1.762f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveToRelative(216.61f, 197.2f)
                lineToRelative(-13.97f, 2.36f)
                moveTo(218.76f, 183.24f)
                lineToRelative(-13.47f, 2.22f)
                moveTo(232.22f, 178.79f)
                lineToRelative(-12.84f, 2.27f)
                moveTo(234.8f, 190.3f)
                lineToRelative(-17.17f, 3.45f)
                moveTo(238.33f, 201.76f)
                lineToRelative(-22.91f, 4.41f)
                moveTo(220.7f, 169.16f)
                lineToRelative(-13.66f, 2.2f)
                moveTo(226.87f, 163.87f)
                lineToRelative(-13.66f, 2.2f)
                moveTo(229.14f, 223.37f)
                lineToRelative(-19.45f, -69.14f)
                lineToRelative(-10.57f, 66.47f)
            }
            path(
                stroke = SolidColor(Color(0xFFE0E0EA)),
                strokeLineWidth = 1.762f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveToRelative(243.67f, 218.92f)
                lineToRelative(-19.44f, -69.14f)
                lineToRelative(-10.57f, 66.47f)
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(238.76f, 126.05f),
                    end = Offset(240.38f, 133.01f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(237.6f, 123.3f)
                curveToRelative(-1.75f, 1.34f, -2.81f, 5.45f, -1.78f, 6.56f)
                curveToRelative(0.44f, 0.47f, 1.48f, 1.09f, 2.63f, 1.18f)
                curveToRelative(-0.28f, 0.51f, -0.52f, 0.94f, -0.73f, 1.29f)
                curveToRelative(-0.63f, 1.05f, -1.34f, 1.67f, -2.13f, 1.88f)
                lineToRelative(6.9f, 1.69f)
                curveToRelative(-0.87f, -0.98f, -1.32f, -1.93f, -1.36f, -2.86f)
                curveToRelative(-0.02f, -0.6f, 0.12f, -1.53f, 0.42f, -2.79f)
                curveToRelative(1.45f, -0.8f, 2.68f, -2.1f, 3.05f, -3.53f)
                curveToRelative(0.9f, -3.51f, -5.25f, -4.75f, -7f, -3.41f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF353564)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(240.96f, 131.67f)
                curveToRelative(2.4f, -2.17f, 4.43f, -4.63f, 4.6f, -5.83f)
                curveToRelative(0.11f, -0.8f, -0.15f, -1.42f, -0.8f, -1.86f)
                curveToRelative(0.18f, -1.61f, -0.77f, -2.66f, -2.86f, -3.15f)
                curveToRelative(-0.46f, -0.11f, -1.25f, 0.15f, -1.7f, -0.04f)
                curveToRelative(-0.8f, -0.35f, -1.04f, -0.52f, -1.61f, -0.66f)
                curveToRelative(-0.76f, -0.19f, -1.31f, 0.01f, -1.77f, 0.49f)
                curveToRelative(-0.56f, 0.6f, -0.56f, 1.72f, 0.09f, 2.69f)
                curveToRelative(0.59f, 0.87f, 1.51f, 0.84f, 2.01f, 1.25f)
                curveToRelative(0.33f, 0.28f, 0.6f, 1.38f, 0.81f, 3.31f)
                lineToRelative(0.3f, -0.47f)
                curveToRelative(0.66f, -0.92f, 1.2f, -1.17f, 1.64f, -0.75f)
                curveToRelative(0.43f, 0.42f, 0.4f, 0.9f, -0.1f, 1.46f)
                curveToRelative(-0.72f, 1.16f, -1.12f, 1.93f, -1.19f, 2.31f)
                curveToRelative(-0.07f, 0.38f, 0.13f, 0.8f, 0.58f, 1.25f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(230.69f, 145.2f),
                    end = Offset(214.29f, 133.73f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveToRelative(228.3f, 136.17f)
                lineToRelative(-6.55f, -0.42f)
                curveToRelative(-1.72f, -2.03f, -2.8f, -3.71f, -3.25f, -5.04f)
                curveToRelative(-0.67f, -2f, 1.3f, -3.05f, -0.97f, -4.88f)
                curveToRelative(-2.27f, -1.82f, -1.11f, 7.37f, -0.61f, 8.63f)
                curveToRelative(0.5f, 1.26f, 1.53f, 3.82f, 5.09f, 5.54f)
                curveToRelative(3.55f, 1.72f, 7.91f, -0.08f, 8.48f, -0.39f)
                lineToRelative(-2.19f, -3.44f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF3E3E6E)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(238.53f, 198.1f)
                curveToRelative(-1.72f, 0.93f, -2.89f, 1.35f, -3.52f, 1.25f)
                curveToRelative(-0.94f, -0.15f, -1.57f, 0.79f, -0.77f, 1.48f)
                curveToRelative(0.8f, 0.68f, 3.69f, 0.33f, 4.4f, 0.44f)
                curveToRelative(0.71f, 0.11f, 2.51f, 0.71f, 2.12f, -1.88f)
                curveToRelative(-0.26f, -1.73f, -0.6f, -2.5f, -1.02f, -2.32f)
                lineToRelative(-1.11f, 0.18f)
                lineToRelative(-0.11f, 0.84f)
                close()
                moveTo(225.33f, 176.86f)
                curveToRelative(-1.42f, 1.35f, -2.44f, 2.05f, -3.07f, 2.12f)
                curveToRelative(-0.94f, 0.1f, -1.31f, 1.17f, -0.36f, 1.62f)
                curveToRelative(0.95f, 0.45f, 3.65f, -0.64f, 4.36f, -0.71f)
                curveToRelative(0.72f, -0.08f, 2.61f, 0.04f, 1.56f, -2.37f)
                curveToRelative(-0.7f, -1.6f, -1.23f, -2.26f, -1.59f, -1.97f)
                lineToRelative(-1.02f, 0.46f)
                lineToRelative(0.12f, 0.84f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(226.56f, 173.83f),
                    end = Offset(232.87f, 153.83f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(246.41f, 153.9f)
                curveToRelative(1.64f, 7.24f, -0.85f, 10.22f, -7.47f, 8.94f)
                curveToRelative(-9.93f, -1.92f, -13.66f, -6.18f, -12.65f, 3.23f)
                curveToRelative(0.68f, 6.27f, 1.02f, 9.55f, 1.04f, 9.83f)
                curveToRelative(-1.93f, 0.73f, -2.89f, 0.67f, -2.89f, -0.18f)
                curveToRelative(0f, -1.28f, -7.89f, -21.92f, -1.44f, -23.51f)
                curveToRelative(4.3f, -1.06f, 12.1f, -0.5f, 23.41f, 1.69f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(241.06f, 195.4f),
                    end = Offset(244.11f, 155.15f)
                ),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(236.34f, 158.76f)
                reflectiveCurveToRelative(-0.85f, 3.48f, -0.76f, 9.97f)
                curveToRelative(0.13f, 9.84f, 1.37f, 24.6f, 2.74f, 28.78f)
                curveToRelative(0.3f, -0.04f, 1.12f, -0.04f, 2.47f, 0f)
                curveToRelative(3.47f, -18.58f, 5.4f, -29.5f, 5.78f, -32.74f)
                curveToRelative(0.57f, -4.86f, 0.63f, -10.82f, -0.63f, -11.27f)
                curveToRelative(-4.14f, -1.49f, -9.6f, 3.32f, -9.6f, 5.25f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF5B5BEA)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(236.64f, 133.32f)
                curveToRelative(1.17f, 0.47f, 1.69f, 2.74f, 5f, 0.73f)
                curveToRelative(0.41f, -0.06f, 5.81f, 1.74f, 4.82f, 6.47f)
                curveToRelative(-0.99f, 4.73f, 1.38f, 16.66f, 0f, 18.62f)
                curveToRelative(-1.38f, 1.97f, -14.07f, 2.36f, -15.22f, -2.61f)
                curveToRelative(-0.76f, -3.31f, -0.98f, -8.33f, -0.64f, -15.06f)
                curveToRelative(-2.82f, 0.68f, -4.44f, 0.93f, -4.84f, 0.77f)
                curveToRelative(-0.61f, -0.24f, -0.76f, -1.98f, -0.76f, -3f)
                curveToRelative(0f, -1.02f, -0.25f, -2.56f, 0.76f, -3.24f)
                curveToRelative(1.01f, -0.68f, 9.71f, -3.15f, 10.89f, -2.68f)
                close()
            }
        }.build()

        return _NoPaymentMethods!!
    }

@Suppress("ObjectPropertyName")
private var _NoPaymentMethods: ImageVector? = null
