package com.hjcoding.kmpstarter.core.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.NoSearchResults: ImageVector
    get() {
        if (_NoSearchResults != null) {
            return _NoSearchResults!!
        }
        _NoSearchResults = ImageVector.Builder(
            name = "NoSearchResults",
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
                    start = Offset(191.38f, 202.43f),
                    end = Offset(191.38f, 250.62f)
                )
            ) {
                moveTo(225.64f, 181.18f)
                curveToRelative(-8.14f, -0.66f, -78.57f, -2.68f, -98.24f, 8.7f)
                curveToRelative(-19.67f, 11.39f, -18.12f, 24.77f, -3.55f, 32.92f)
                curveToRelative(10.78f, 6.03f, 22.48f, 8.79f, 41.26f, 10.71f)
                curveToRelative(27.18f, 2.78f, 59.84f, 0.85f, 70.28f, -1.03f)
                curveToRelative(17.65f, -3.17f, 19.57f, -9.71f, 19.57f, -14.48f)
                curveToRelative(0f, -4.78f, 11.28f, -8.31f, 14.28f, -16.73f)
                curveToRelative(3.01f, -8.42f, -2.9f, -12.94f, -24.94f, -17.81f)
                curveToRelative(-1.57f, -0.31f, -10.53f, -1.63f, -18.66f, -2.29f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEF8),
                        1f to Color(0xFFBDBDC8)
                    ),
                    start = Offset(147.19f, 194.32f),
                    end = Offset(147.19f, 218.04f)
                )
            ) {
                moveToRelative(157.19f, 194.32f)
                lineToRelative(-20.85f, 5.7f)
                curveToRelative(-0.44f, 4.62f, -0.09f, 8.55f, 1.04f, 11.79f)
                curveToRelative(1.09f, 3.12f, 3.51f, 5.43f, 8.26f, 6.23f)
                curveToRelative(0.12f, 0.02f, 0.48f, -0.05f, 1.06f, -0.19f)
                arcToRelative(0.67f, 0.67f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.23f, -0.03f)
                curveToRelative(4.76f, -1.79f, 8.02f, -5.69f, 9.79f, -11.7f)
                curveToRelative(1.8f, -6.11f, 1.96f, -10.05f, 0.46f, -11.79f)
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
                    start = Offset(197.42f, 197.04f),
                    end = Offset(160.28f, 72.31f)
                )
            ) {
                moveTo(146.73f, 82.27f)
                curveToRelative(0.19f, -0.02f, 0.41f, -0.05f, 0.65f, -0.08f)
                curveToRelative(0.36f, -0.05f, 0.84f, -0.03f, 1.03f, 0.03f)
                curveToRelative(6.31f, 2.08f, 8.93f, 7.43f, 8.93f, 13.19f)
                verticalLineTo(197.27f)
                curveToRelative(-0.2f, 5.61f, -0.83f, 9.52f, -1.89f, 11.71f)
                curveToRelative(-1.88f, 3.89f, -5.67f, 7.1f, -9.78f, 9.06f)
                curveToRelative(0.24f, 0.03f, 0.59f, 0.05f, 1.06f, 0.08f)
                horizontalLineToRelative(0.65f)
                curveToRelative(2.74f, 0f, 6.24f, 0.09f, 12.81f, -1.6f)
                curveToRelative(19.75f, -5.05f, 52.73f, -16.38f, 57.68f, -18.34f)
                curveToRelative(7.02f, -2.78f, 13.93f, -10.07f, 13.93f, -17.78f)
                curveToRelative(0f, -5.14f, 0.34f, -37.63f, 1.02f, -97.46f)
                curveToRelative(0.14f, -6.1f, -1.09f, -10.76f, -3.68f, -13.98f)
                curveToRelative(-3.89f, -4.84f, -9.59f, -3.94f, -12.18f, -3.64f)
                curveToRelative(-1.72f, 0.2f, -24.71f, 5.67f, -68.97f, 16.41f)
                curveToRelative(-0.2f, 0.06f, -0.4f, 0.13f, -0.61f, 0.22f)
                arcToRelative(5.41f, 5.41f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.65f, 0.32f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFCED0D6),
                        1f to Color(0xFFF6F8FC)
                    ),
                    start = Offset(146.34f, 84.37f),
                    end = Offset(149.5f, 91.14f)
                )
            ) {
                moveTo(142.1f, 92.52f)
                curveToRelative(-0.12f, -3.84f, 0.29f, -6.4f, 1.22f, -7.68f)
                curveToRelative(1.4f, -1.92f, 2.48f, -2.24f, 3.18f, -2.5f)
                curveToRelative(0.7f, -0.26f, 1.53f, -0.22f, 1.83f, -0.18f)
                arcToRelative(6.97f, 6.97f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.22f, 0.72f)
                curveToRelative(0.76f, 0.4f, 1.79f, 1.22f, 2.41f, 1.79f)
                arcToRelative(12.83f, 12.83f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.62f, 3.37f)
                lineToRelative(-13.48f, 4.47f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEBEBF2))) {
                moveToRelative(171.43f, 115.16f)
                lineToRelative(47.82f, -11.92f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.09f, 0.85f)
                verticalLineToRelative(3.3f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.67f, 0.86f)
                lineToRelative(-47.82f, 11.92f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.1f, -0.86f)
                verticalLineToRelative(-3.3f)
                curveToRelative(0f, -0.41f, 0.28f, -0.76f, 0.67f, -0.86f)
                close()
                moveTo(171.17f, 102.67f)
                lineToRelative(28.05f, -6.99f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1.09f, 0.77f)
                lineToRelative(0.31f, 3.22f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.66f, 0.94f)
                lineToRelative(-28.05f, 6.99f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, -1.09f, -0.77f)
                lineToRelative(-0.31f, -3.22f)
                arcToRelative(0.88f, 0.88f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0.66f, -0.94f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB8A3))) {
                moveToRelative(223.56f, 203.36f)
                lineToRelative(-0.13f, 1.77f)
                lineToRelative(-1.36f, 0.52f)
                lineToRelative(-1.26f, -0.19f)
                lineToRelative(-0.21f, -2.42f)
                lineToRelative(2.96f, 0.32f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3E3E6E))) {
                moveTo(220.59f, 204.88f)
                arcToRelative(0.27f, 0.27f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.16f, -0.01f)
                curveToRelative(-0.9f, 0.29f, -1.65f, 0.69f, -2.14f, 0.83f)
                curveToRelative(-0.81f, 0.24f, -1.54f, 0.52f, -2.05f, 0.65f)
                reflectiveCurveToRelative(-1.42f, 0.22f, -1.89f, 0.47f)
                curveToRelative(-0.47f, 0.25f, -0.58f, 0.62f, -0.62f, 0.86f)
                curveToRelative(-0.02f, 0.15f, -0.13f, 0.39f, -0.13f, 0.76f)
                curveToRelative(0f, 0.14f, 0.05f, 0.29f, 0.17f, 0.31f)
                curveToRelative(2.07f, 0.34f, 4.29f, 0.28f, 5.54f, 0.24f)
                curveToRelative(1.23f, -0.04f, 3.08f, -0.05f, 4.7f, -0.09f)
                curveToRelative(0.17f, -0f, 0.29f, -0.18f, 0.29f, -0.37f)
                curveToRelative(-0.01f, -1.1f, -0.02f, -1.69f, -0.11f, -2.13f)
                curveToRelative(-0.09f, -0.42f, -0.14f, -0.93f, -0.42f, -1.47f)
                curveToRelative(-0.05f, -0.09f, -0.13f, -0.19f, -0.21f, -0.15f)
                lineToRelative(-0.73f, 0.39f)
                curveToRelative(-0.44f, 0.23f, -1.09f, 0.14f, -1.36f, 0.08f)
                curveToRelative(-0.18f, -0.04f, -0.47f, -0.16f, -0.86f, -0.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB8A3))) {
                moveToRelative(235.16f, 200.08f)
                lineToRelative(0.23f, 2.34f)
                lineToRelative(-2.68f, 0.02f)
                lineToRelative(-0.15f, -2.5f)
                lineToRelative(2.6f, 0.14f)
                close()
            }
            path(fill = SolidColor(Color(0xFF3E3E6E))) {
                moveTo(232.65f, 201.6f)
                arcToRelative(0.26f, 0.26f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.15f, -0.03f)
                curveToRelative(-0.87f, 0.17f, -1.36f, 0.18f, -1.95f, 0.27f)
                curveToRelative(-0.58f, 0.09f, -0.73f, 0.01f, -1.08f, 0.05f)
                arcToRelative(2.63f, 2.63f, 0f, isMoreThanHalf = false, isPositiveArc = false, -0.86f, 0.21f)
                curveToRelative(-0.37f, 0.14f, -0.69f, 0.48f, -0.76f, 0.7f)
                curveToRelative(-0.06f, 0.22f, -0.09f, 0.37f, -0.13f, 0.71f)
                curveToRelative(-0.01f, 0.13f, 0.16f, 0.34f, 0.27f, 0.37f)
                curveToRelative(1.83f, 0.43f, 2.3f, 0.46f, 3.29f, 0.62f)
                curveToRelative(0.99f, 0.17f, 2.7f, 0.44f, 4.21f, 0.58f)
                curveToRelative(0.16f, 0.01f, 0.29f, -0.14f, 0.31f, -0.31f)
                curveToRelative(0.13f, -1.01f, 0.04f, -0.97f, 0f, -1.39f)
                curveToRelative(-0.04f, -0.4f, -0.02f, -0.87f, -0.22f, -1.39f)
                curveToRelative(-0.03f, -0.09f, -0.09f, -0.19f, -0.18f, -0.16f)
                lineToRelative(-0.73f, 0.28f)
                curveToRelative(-0.44f, 0.17f, -1.03f, 0.01f, -1.28f, -0.07f)
                curveToRelative(-0.16f, -0.05f, -0.41f, -0.2f, -0.75f, -0.44f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFD2C4),
                        1f to Color(0xFFFFB8A3)
                    ),
                    start = Offset(222.87f, 133.25f),
                    end = Offset(225.22f, 138.7f)
                )
            ) {
                moveTo(223.16f, 140.7f)
                curveToRelative(0.32f, -1.44f, -0.05f, -2.15f, -1.09f, -2.15f)
                curveToRelative(-1.64f, 0f, -2.23f, -2.08f, -2.08f, -4.24f)
                curveToRelative(0.31f, -4.4f, 1.89f, -5.94f, 3.96f, -5.94f)
                reflectiveCurveToRelative(3.21f, 0.24f, 3.61f, 2.7f)
                curveToRelative(0.4f, 2.45f, 0.51f, 3.92f, 0f, 5.6f)
                curveToRelative(-0.51f, 1.68f, -0.51f, 2.71f, 0f, 3.17f)
                curveToRelative(0.34f, 0.31f, -1.13f, 0.59f, -4.4f, 0.87f)
                close()
            }
            path(fill = SolidColor(Color(0xFF353564))) {
                moveTo(227.43f, 137.16f)
                curveToRelative(0.75f, -3.12f, 3.09f, -4.24f, 2.71f, -6.39f)
                curveToRelative(-0.25f, -1.43f, -0.69f, -1.96f, -1.31f, -1.58f)
                curveToRelative(-0.26f, -1.56f, -1.5f, -2.35f, -3.74f, -2.37f)
                curveToRelative(-0.5f, -0f, -1.22f, 0.41f, -1.72f, 0.32f)
                curveToRelative(-0.9f, -0.16f, -1.18f, -0.27f, -1.8f, -0.28f)
                curveToRelative(-0.82f, -0.02f, -1.32f, 0.29f, -1.64f, 0.84f)
                curveToRelative(-0.4f, 0.68f, -0.09f, 1.75f, 0.83f, 2.52f)
                curveToRelative(0.83f, 0.69f, 1.75f, 0.47f, 2.36f, 0.76f)
                curveToRelative(0.41f, 0.19f, 0.98f, 1.18f, 1.72f, 2.95f)
                lineToRelative(0.17f, -0.51f)
                curveToRelative(0.41f, -1.01f, 0.89f, -1.36f, 1.44f, -1.06f)
                curveToRelative(0.55f, 0.3f, 0.65f, 0.77f, 0.3f, 1.4f)
                curveToRelative(-0.41f, 1.25f, -0.6f, 2.06f, -0.56f, 2.43f)
                curveToRelative(0.04f, 0.38f, 0.45f, 0.7f, 1.25f, 0.97f)
                close()
            }
            path(fill = SolidColor(Color(0xFFEFAB23))) {
                moveTo(214.12f, 152.25f)
                curveToRelative(-1.07f, 0.68f, -1.95f, -0.06f, -2.3f, -0.65f)
                curveToRelative(-0.23f, -0.39f, -1.79f, -3.16f, -4.69f, -8.31f)
                lineToRelative(2.51f, -1.25f)
                lineToRelative(4.87f, 8.21f)
                reflectiveCurveToRelative(0.68f, 1.31f, -0.39f, 1.99f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFFB8A3),
                        1f to Color(0xFFEDA48E)
                    ),
                    start = Offset(210.81f, 145.86f),
                    end = Offset(215.45f, 149.71f)
                )
            ) {
                moveTo(215.33f, 148.02f)
                curveToRelative(-0.29f, -0.06f, -0.68f, -0.32f, -1.15f, -0.79f)
                curveToRelative(-0.71f, -0.7f, -1.08f, -1.54f, -1.67f, -1.64f)
                curveToRelative(-0.59f, -0.1f, -1.38f, 0.07f, -1.72f, 0.27f)
                curveToRelative(-0.34f, 0.2f, -0.43f, 0.85f, 0.04f, 0.85f)
                curveToRelative(0.47f, 0f, 0.33f, -0f, 1f, -0.19f)
                curveToRelative(0.67f, -0.18f, 0.75f, 0.52f, 0.75f, 1.07f)
                curveToRelative(0f, 0.54f, 0.28f, 1.15f, 0.52f, 1.38f)
                curveToRelative(0.23f, 0.23f, 0.32f, 0.4f, 0.91f, 0.46f)
                curveToRelative(0.27f, 0.03f, 0.78f, 0.72f, 0.97f, 0.71f)
                curveToRelative(0.26f, -0.02f, 0.05f, 0.28f, 0.2f, 0.2f)
                curveToRelative(0.17f, -0.08f, -0.31f, -1f, 0.15f, -2.18f)
                arcToRelative(0.27f, 0.27f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0f, -0.13f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB8A3))) {
                moveTo(210.21f, 147.07f)
                curveToRelative(-0.71f, -0.34f, -0.74f, 0.17f, -0.86f, 0.56f)
                arcToRelative(1.84f, 1.84f, 0f, isMoreThanHalf = false, isPositiveArc = false, 0.26f, 1.61f)
                curveToRelative(0.35f, 0.5f, 1.11f, 1.2f, 1.59f, 1.24f)
                curveToRelative(0.1f, 0.01f, 0.01f, -0.09f, -0.06f, -0.22f)
                curveToRelative(-0.19f, -0.36f, -0.35f, -0.5f, -0.17f, -1.02f)
                curveToRelative(0.1f, -0.3f, 0.18f, -0.47f, 0.11f, -0.91f)
                curveToRelative(-0.06f, -0.38f, -0.54f, -1.11f, -0.87f, -1.26f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCFCFF),
                        1f to Color(0xFFFAFAFC)
                    ),
                    start = Offset(203.28f, 120.31f),
                    end = Offset(203.28f, 142.81f)
                )
            ) {
                moveTo(203.27f, 142.81f)
                curveToRelative(6.35f, 0f, 11.5f, -5.04f, 11.5f, -11.25f)
                reflectiveCurveToRelative(-5.15f, -11.25f, -11.5f, -11.25f)
                reflectiveCurveToRelative(-11.5f, 5.04f, -11.5f, 11.25f)
                reflectiveCurveToRelative(5.15f, 11.25f, 11.5f, 11.25f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFAC251),
                        1f to Color(0xFFFFDE9B)
                    ),
                    start = Offset(209.45f, 141.29f),
                    end = Offset(194.91f, 123.89f)
                )
            ) {
                moveTo(202.84f, 119.31f)
                curveToRelative(6.94f, 0f, 12.57f, 5.63f, 12.57f, 12.57f)
                curveToRelative(0f, 6.94f, -5.63f, 12.57f, -12.57f, 12.57f)
                curveToRelative(-6.94f, 0f, -12.57f, -5.63f, -12.57f, -12.57f)
                curveToRelative(0f, -6.94f, 5.63f, -12.57f, 12.57f, -12.57f)
                close()
                moveTo(202.84f, 121.43f)
                curveToRelative(-5.77f, 0f, -10.45f, 4.68f, -10.45f, 10.45f)
                reflectiveCurveToRelative(4.68f, 10.45f, 10.45f, 10.45f)
                reflectiveCurveToRelative(10.45f, -4.68f, 10.45f, -10.45f)
                reflectiveCurveToRelative(-4.68f, -10.45f, -10.45f, -10.45f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFB8A3))) {
                moveTo(216.2f, 147.81f)
                arcToRelative(256.62f, 256.62f, 0f, isMoreThanHalf = false, isPositiveArc = false, -2.46f, 4.09f)
                curveToRelative(-0.83f, 1.43f, -1.82f, 3.91f, -2.55f, 3.91f)
                curveToRelative(-0.73f, 0f, -4.92f, -1.65f, -6.81f, -2.43f)
                curveToRelative(-1.26f, -0.52f, -2.71f, -1.02f, -4.37f, -1.48f)
                curveToRelative(-0.61f, -1.33f, -1.14f, -2.16f, -1.6f, -2.5f)
                curveToRelative(-0.69f, -0.51f, -3.39f, 0f, -3.39f, 0f)
                reflectiveCurveToRelative(-0.85f, 1.02f, 1.54f, 2.5f)
                curveToRelative(2.39f, 1.48f, 6.53f, 4.43f, 8.76f, 6.16f)
                curveToRelative(2.23f, 1.73f, 5.57f, 3.39f, 7.55f, 3.39f)
                curveToRelative(1.98f, 0f, 1.73f, -0.41f, 2.58f, -1.45f)
                curveToRelative(0.57f, -0.69f, 2.47f, -3.6f, 5.69f, -8.72f)
                lineToRelative(-4.95f, -3.46f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7878C3),
                        1f to Color(0xFF5C5CBB)
                    ),
                    start = Offset(224.79f, 201.58f),
                    end = Offset(236.44f, 176.66f)
                )
            ) {
                moveTo(217.45f, 169.55f)
                curveToRelative(-0.78f, 6.06f, -0.89f, 11.86f, -0.35f, 17.42f)
                curveToRelative(0.81f, 8.33f, 2.93f, 17.11f, 3.31f, 17.11f)
                curveToRelative(0.38f, 0f, 2.47f, 0.21f, 3.15f, 0f)
                curveToRelative(0.68f, -0.21f, 0.98f, -6.82f, 0.6f, -9.31f)
                curveToRelative(-0.38f, -2.5f, -0.12f, -5.89f, 0f, -7.33f)
                curveToRelative(0.12f, -1.43f, 2.83f, -9.22f, 3.37f, -9.22f)
                reflectiveCurveToRelative(1.1f, 5.88f, 1.1f, 7.7f)
                curveToRelative(0f, 1.81f, 1.81f, 5.74f, 2.27f, 7.67f)
                curveToRelative(0.46f, 1.94f, 1.3f, 6.3f, 1.3f, 6.95f)
                curveToRelative(0f, 0.43f, 1.08f, 0.52f, 3.22f, 0.27f)
                curveToRelative(0.13f, -4.15f, 0.13f, -6.84f, 0f, -8.08f)
                curveToRelative(-0.19f, -1.86f, -1.05f, -5.62f, -1.31f, -7.02f)
                curveToRelative(-0.26f, -1.4f, 0f, -3.62f, 0.56f, -7.08f)
                curveToRelative(0.37f, -2.3f, 0.87f, -5.63f, 1.48f, -9.98f)
                lineToRelative(-18.7f, 0.89f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0x005360B8),
                        1f to Color(0x91223196)
                    ),
                    start = Offset(231.94f, 177.58f),
                    end = Offset(230.73f, 177.18f)
                ),
                fillAlpha = 0.303f,
                strokeAlpha = 0.303f
            ) {
                moveTo(231.01f, 170.86f)
                arcToRelative(40.19f, 40.19f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.9f, 2.81f)
                curveToRelative(-0.86f, 2.31f, -2.64f, 4.41f, -2.64f, 4.59f)
                curveToRelative(0f, 0f, 0.06f, -0.06f, 0.12f, 0f)
                curveToRelative(0.06f, 0.06f, 0.17f, 0.26f, 0.24f, 0.51f)
                curveToRelative(0.26f, 0.95f, 0.55f, 3.61f, 0.88f, 7.96f)
                lineToRelative(6.26f, -10.35f)
                curveToRelative(0.6f, -4.5f, 0.6f, -7.11f, 0f, -7.84f)
                curveToRelative(-0.29f, -0.35f, -0.7f, 1.24f, -1.17f, 1.08f)
                curveToRelative(-1.94f, -0.66f, -2.87f, -0.24f, -2.8f, 1.25f)
                close()
            }
            path(fill = SolidColor(Color(0xFF5B5BEA))) {
                moveTo(222.33f, 139.54f)
                curveToRelative(-2.5f, 1.81f, -4.35f, 3.64f, -5.53f, 5.5f)
                curveToRelative(-1.19f, 1.86f, -2.06f, 3.35f, -2.61f, 4.45f)
                lineToRelative(5.51f, 3.85f)
                lineToRelative(-1.05f, 1.9f)
                arcToRelative(357.66f, 357.66f, 0f, isMoreThanHalf = false, isPositiveArc = true, -0.6f, 8.26f)
                curveToRelative(-0.35f, 4.09f, -2.47f, 7.45f, -1.71f, 7.94f)
                curveToRelative(0.76f, 0.5f, 6.38f, 0.43f, 11.57f, 0f)
                curveToRelative(3.46f, -0.29f, 6.4f, -1.14f, 8.82f, -2.57f)
                curveToRelative(0.12f, -2.02f, 0.12f, -4.28f, 0f, -6.77f)
                curveToRelative(-0.19f, -3.74f, -0.46f, -5.99f, -0.71f, -7.49f)
                curveToRelative(-0.3f, -1.85f, -1.46f, -7.49f, -1.64f, -8.08f)
                curveToRelative(-0.18f, -0.59f, -1.15f, -3.49f, -2.83f, -5.28f)
                curveToRelative(-1.12f, -1.2f, -2.55f, -1.77f, -4.3f, -1.73f)
                curveToRelative(-1.33f, 0.32f, -2.26f, 0.47f, -2.77f, 0.47f)
                curveToRelative(-0.52f, 0f, -1.23f, -0.16f, -2.15f, -0.47f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFEEEEEE),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(71.62f, 172.34f),
                    end = Offset(71.62f, 250.16f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(66.26f, 162.34f)
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
                    start = Offset(108.26f, 159.96f),
                    end = Offset(108.26f, 252.57f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(94.94f, 169.78f)
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
                    start = Offset(93.83f, 152.26f),
                    end = Offset(93.83f, 169.84f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(66.08f, 162.26f)
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
                    start = Offset(260.78f, 136.28f),
                    end = Offset(260.78f, 197.86f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(256.53f, 128.37f)
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
                    start = Offset(289.87f, 126.48f),
                    end = Offset(289.87f, 199.77f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(279.3f, 134.25f)
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
                    start = Offset(278.41f, 120.39f),
                    end = Offset(278.41f, 134.31f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveToRelative(256.39f, 128.3f)
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
                    start = Offset(306.61f, 156.82f),
                    end = Offset(306.61f, 195.59f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(305.91f, 156.82f)
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
                curveToRelative(2.8f, -5.78f, 9.45f, -9.85f, 17.2f, -9.85f)
                close()
            }
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFDCDCE4),
                        1f to Color(0x00DEDEE6)
                    ),
                    start = Offset(109.25f, 88.1f),
                    end = Offset(109.25f, 126.87f)
                ),
                fillAlpha = 0.302f,
                strokeAlpha = 0.302f
            ) {
                moveTo(108.56f, 88.1f)
                curveToRelative(7.75f, 0f, 14.4f, 4.07f, 17.2f, 9.85f)
                horizontalLineToRelative(1.44f)
                curveToRelative(7.61f, 0f, 13.78f, 6.17f, 13.78f, 13.78f)
                verticalLineToRelative(1.37f)
                curveToRelative(0f, 7.61f, -6.17f, 13.78f, -13.78f, 13.78f)
                horizontalLineTo(91.31f)
                curveToRelative(-7.61f, 0f, -13.78f, -6.17f, -13.78f, -13.78f)
                verticalLineToRelative(-1.37f)
                curveToRelative(0f, -7.61f, 6.17f, -13.78f, 13.78f, -13.78f)
                horizontalLineToRelative(0.05f)
                curveToRelative(2.8f, -5.78f, 9.44f, -9.85f, 17.2f, -9.85f)
                close()
            }
        }.build()

        return _NoSearchResults!!
    }

@Suppress("ObjectPropertyName")
private var _NoSearchResults: ImageVector? = null
