package com.santukis.ca.components.scaffold.states

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberBottomSheetState(
    sheetState: SheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    ),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    initialVisibilityValue: VisibilityState.VisibleValue = VisibilityState.VisibleValue.Invisible
): BottomSheetState =
    rememberSaveable(
        saver = BottomSheetState.saver(
            sheetState = sheetState,
            coroutineScope = coroutineScope
        )
    ) {
        BottomSheetState(
            sheetState = sheetState,
            coroutineScope = coroutineScope,
            initialVisibilityValue = initialVisibilityValue
        )
    }

@OptIn(ExperimentalMaterial3Api::class)
class BottomSheetState(
    val sheetState: SheetState,
    private val coroutineScope: CoroutineScope,
    private val initialVisibilityValue: VisibilityState.VisibleValue
) {
    private val visibilityState by mutableStateOf(VisibilityState(initialVisibilityValue))

    fun isBottomSheetVisible(): Boolean = visibilityState.isVisible

    fun toggleBottomSheetVisibility() {
        when {
            visibilityState.isVisible ->
                coroutineScope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    visibilityState.hide()
                }
            else -> visibilityState.show()
        }
    }

    companion object {
        fun saver(
            sheetState: SheetState,
            coroutineScope: CoroutineScope
        ): Saver<BottomSheetState, VisibilityState.VisibleValue> = Saver(
            save = { with(VisibilityState.Saver) { save(it.visibilityState) } },
            restore = {
                BottomSheetState(
                    sheetState = sheetState,
                    coroutineScope = coroutineScope,
                    initialVisibilityValue = it
                )
            }
        )
    }
}
