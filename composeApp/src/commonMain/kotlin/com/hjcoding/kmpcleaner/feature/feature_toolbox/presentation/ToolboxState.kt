package com.hjcoding.kmpcleaner.feature.feature_toolbox.presentation

import androidx.compose.ui.graphics.vector.ImageVector

data class GaugeInfo(val label: String, val value: Int)

data class ToolItem(val name: String, val icon: ImageVector)

data class ToolboxState(
    val gaugeItems: List<GaugeInfo> = emptyList(),
    val toolItems: List<ToolItem> = emptyList()
)
