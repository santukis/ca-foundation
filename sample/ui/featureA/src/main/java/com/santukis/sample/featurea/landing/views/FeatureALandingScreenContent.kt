package com.santukis.sample.featurea.landing.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.santukis.ca.ui.scaffold.Action
import com.santukis.sample.featurea.landing.FeatureALandingAction
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureB
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureC
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToFeatureD
import com.santukis.sample.featurea.landing.FeatureALandingNavigationAction.NavigateToSecondaryScreen
import com.santukis.sample.featurea.landing.FeatureALandingState
import com.santukis.sample.featurea.landing.ItemB
import com.santukis.sample.featurea.landing.navigation.FeatureAModel
import com.santukis.sample.featurea.landing.navigation.ToFeatureBArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureCArguments
import com.santukis.sample.featurea.landing.navigation.ToFeatureDArguments
import com.santukis.sample.featurea.landing.navigation.ToSecondaryScreenArguments
import java.util.UUID
import kotlin.random.Random

@Suppress("LongMethod")
@Composable
fun FeatureALandingScreenContent(
    featureDResult: String,
    state: FeatureALandingState,
    onActions: (Action) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.Cyan)
    ) {
        Text(text = "Feature A Landing")

        val model = rememberSaveable { mutableStateOf(FeatureAModel()) }
        Button(onClick = {
            onActions(
                NavigateToSecondaryScreen(
                    ToSecondaryScreenArguments()
                )
            )
        }) {
            Text(text = "Navigate to Secondary Screen")
        }
        Button(onClick = {
            onActions(
                NavigateToFeatureB(
                    ToFeatureBArguments(
                        anyParam = "Hello"
                    )
                )
            )
        }) {
            Text(text = "Navigate to Feature B")
        }
        Button(onClick = {
            onActions(
                NavigateToFeatureC(
                    ToFeatureCArguments(
                        anyParam = "Hello"
                    ) { result -> model.value = result }
                )
            )
        }) {
            Text(text = "Navigate to Feature C For Results")
        }
        Text(text = "Results From Feature C:\n${model.value}")
        Button(onClick = {
            onActions(
                NavigateToFeatureD(
                    ToFeatureDArguments(
                        anyParam = "Hello"
                    )
                )
            )
        }) {
            Text(text = "Navigate to Feature D")
        }
        Text(text = "Results From Feature D:\n$featureDResult")

        Text(text = "State: FeatureALandingState")
        Text(text = "FeatureALandingState: $state")
        Text(text = "FeatureALandingState: ${state.field01}")
        Text(text = "FeatureALandingState: ${state.field02}")
        Text(text = "FeatureALandingState: ${state.field03}")
        Text(text = "FeatureALandingState: ${state.field04}")
        Text(text = "FeatureALandingState: ${state.field05}")
        Text(text = "FeatureALandingState: ${state.field06}")

        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField01(
                        UUID.randomUUID().toString()
                    )
                )
            }
        ) {
            Text(text = "Modify State field01")
        }
        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField02(
                        Random.nextInt()
                    )
                )
            }
        ) {
            Text(text = "Modify State field02")
        }
        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField03(
                        Random.nextBoolean()
                    )
                )
            }
        ) {
            Text(text = "Modify State field03")
        }
        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField04(
                        listOf(
                            UUID.randomUUID().toString(),
                            UUID.randomUUID().toString(),
                            UUID.randomUUID().toString(),
                            UUID.randomUUID().toString(),
                        )
                    )
                )
            }
        ) {
            Text(text = "Modify State field04")
        }
        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField05(
                        FeatureALandingState.LandingItem(
                            field01 = UUID.randomUUID().toString(),
                            field02 = Random.nextLong()
                        )
                    )
                )
            }
        ) {
            Text(text = "Modify State field05")
        }
        Button(
            onClick = {
                onActions(
                    FeatureALandingAction.UpdateField06(
                        ItemB()
                    )
                )
            }
        ) {
            Text(text = "Modify State field06")
        }
    }
}
