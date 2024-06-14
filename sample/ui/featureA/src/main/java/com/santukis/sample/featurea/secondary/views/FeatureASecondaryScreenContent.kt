package com.santukis.sample.featurea.secondary.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.santukis.ca.components.scaffold.Action
import com.santukis.sample.featurea.secondary.FeatureASecondaryNavigationAction.GoBack
import com.santukis.sample.featurea.secondary.FeatureASecondaryState
import com.santukis.sample.featurea.secondary.states.FeatureASecondaryScreenUiState

private const val ItemCount = 100

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("UnusedParameter")
@Composable
fun FeatureASecondaryScreenContent(
    screenState: FeatureASecondaryState,
    uiState: FeatureASecondaryScreenUiState,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Feature A Secondary Screen")
        Button(onClick = { onAction(GoBack()) }) {
            Text(text = "Navigate to Landing")
        }
    }

    if (uiState.bottomSheetState.isVisible()) {
        ModalBottomSheet(
            onDismissRequest = {

            },
            sheetState = uiState.bottomSheetState.sheetState
        ) {
            LazyColumn(
                state = uiState.lazyListState
            ) {
                items(ItemCount) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = it.toString()
                        )
                    }
                }
            }
        }
    }
}
