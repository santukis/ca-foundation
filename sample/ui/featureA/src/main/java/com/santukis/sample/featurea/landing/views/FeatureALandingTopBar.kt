package com.santukis.sample.featurea.landing.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.santukis.ca.components.scaffold.Action
import com.santukis.ca.components.scaffold.ScreenArguments
import com.santukis.ca.components.scaffold.actions.NavigationDrawerAction
import com.santukis.sample.featurea.landing.FeatureALandingState

@Suppress("UnusedParameter")
@Composable
fun FeatureALandingTopBar(
    arguments: ScreenArguments,
    state: FeatureALandingState,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "",
            modifier = Modifier
                .clickable {
                    onAction(
                        NavigationDrawerAction.OpenDrawer()
                    )
                }
        )

        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = ""
        )
    }
}
