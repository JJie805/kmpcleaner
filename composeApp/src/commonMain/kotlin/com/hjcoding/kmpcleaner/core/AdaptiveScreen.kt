package com.hjcoding.kmpcleaner.core

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 固定比例布局，如果只用这个内部尺寸请使用.dpp 和.spp
 * @param isPrintInfo 打印density和宽高像素信息
 * @param 是否基于屏幕宽度
 */
@Composable
fun AdaptiveScreen(isPrintInfo: Boolean = false,
                   isBaseOnWidth: Boolean = true,
                   content : @Composable () -> Unit){
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        Dimen.init(
            isPrintInfo = isPrintInfo,
            ScreenConfig(
                isBaseOnWidth = isBaseOnWidth,
                screenWidthDp = maxWidth,
                screenHeightDp = maxHeight,
                designDp = 240.dp
            )
        )
        content()
    }
}

data class ScreenConfig(
    val isBaseOnWidth: Boolean = true,
    val screenWidthDp: Dp = 0.dp,
    val screenHeightDp: Dp = 0.dp,
    val designDp: Dp
) {
    init {
        require(designDp.value > 0) { "DesignDp must be greater than 0." }
    }
}

object Dimen {
    var densityAdaptiveScale = 1.0f

    private fun calculateDensityAdaptiveScale(screenConfig: ScreenConfig): Float {
        val targetDp = if (screenConfig.isBaseOnWidth)
            screenConfig.screenWidthDp
        else
            screenConfig.screenHeightDp
        return targetDp / screenConfig.designDp
    }

    @Composable
    fun init(
        isPrintInfo: Boolean = true,
        screenConfig: ScreenConfig
    ) {
        val density = LocalDensity.current
        densityAdaptiveScale = calculateDensityAdaptiveScale(screenConfig)
        if (isPrintInfo) {
            printInfo(
                screenConfig = screenConfig,
                densityAdaptiveScale = densityAdaptiveScale,
                density = density)
        }
    }

    private fun printInfo(
                          screenConfig: ScreenConfig,
                          densityAdaptiveScale : Float,
                          density: Density) {
        println(
            "LocalDensity:$density densityAdaptiveScale:$densityAdaptiveScale screenConfig: $screenConfig " +
            "screenSizePx: (${density.run { screenConfig.screenWidthDp.roundToPx() }}, ${density.run { screenConfig.screenHeightDp.roundToPx() }})"
        )
    }
}

// 扩展属性
fun Dp.scaled(scale: Float): Dp = this * scale
fun TextUnit.scaled(scale: Float): TextUnit = TextUnit(this.value * scale, this.type)

val Int.dpp: Dp get() = this.dp.scaled(Dimen.densityAdaptiveScale)
val Float.dpp: Dp get() = this.dp.scaled(Dimen.densityAdaptiveScale)
val Double.dpp: Dp get() = this.dp.scaled(Dimen.densityAdaptiveScale)

val Int.spp: TextUnit get() = this.sp.scaled(Dimen.densityAdaptiveScale)
val Float.spp: TextUnit get() = this.sp.scaled(Dimen.densityAdaptiveScale)
val Double.spp: TextUnit get() = this.sp.scaled(Dimen.densityAdaptiveScale)
