package com.hjcoding.kmpstarter.core.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import com.hjcoding.kmpstarter.core.designsystem.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hjcoding.kmpstarter.core.designsystem.icons.NoNetworkConnection

@Composable
fun NoNetworkConnectionPage(modifier: Modifier = Modifier,
                            content : @Composable BoxScope.() -> Unit){
    Box(modifier = modifier){
        content()
    }
}

@Composable
fun CommonNoNetworkConnectionPage(modifier: Modifier = Modifier.fillMaxSize()){
    NoNetworkConnectionPage(modifier = modifier,
        content = {
            Image(modifier = Modifier.align(Alignment.Center),
                imageVector = Icons.NoNetworkConnection,
                contentDescription = null)
        })
}