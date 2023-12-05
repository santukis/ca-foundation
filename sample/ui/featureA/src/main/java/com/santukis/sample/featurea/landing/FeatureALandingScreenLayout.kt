package com.santukis.sample.featurea.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.screenlayouts.NavigationDrawerScreenLayout
import com.santukis.ca.components.scaffold.screenlayouts.ScreenLayout
import com.santukis.ca.components.scaffold.states.ScreenConfigurationState

class FeatureALandingScreenLayout : NavigationDrawerScreenLayout<FeatureALandingState>() {

    @Composable
    override fun DrawerContent(
        arguments: ScreenArguments,
        state: FeatureALandingState,
        onAction: (Action) -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(fraction = NavigationViewWidth)
                .fillMaxHeight()
                .background(Color.Gray)
        ) {
            Text(text = "Header")
            Text(text = "Body")
        }
    }

    @Composable
    override fun rememberContentLayout(
        screenConfiguration: ScreenConfigurationState
    ): ScreenLayout<FeatureALandingState> =
        remember {
            FeatureALandingContentScreenLayout()
        }

    private companion object {
        const val NavigationViewWidth = 0.4f
    }
}
