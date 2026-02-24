package com.santukis.sample.featurea.secondary.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.ui.scaffold.Action
import com.santukis.sample.featurea.secondary.FeatureASecondaryState
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState

@Suppress("UnusedParameter")
@Composable
fun FeatureASecondaryScreenTopBar(
    screenState: FeatureASecondaryState,
    uiState: FeatureASecondaryScreenUiState,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        horizontalArrangement = Arrangement.End,
    ) {
        IconButton(
            onClick = { uiState.bottomSheetState.toggle() }
        ) {
            if (uiState.bottomSheetState.isVisible()) {
                Icon(
                    imageVector = Icons.Outlined.VisibilityOff,
                    contentDescription = ""
                )
            } else {
                Icon(
                    imageVector = Icons.Outlined.Visibility,
                    contentDescription = ""
                )
            }
        }
    }
}
