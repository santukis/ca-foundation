package com.santukis.ca.components.scaffold.states

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
interface BottomSheetState : VisibilityState {
    val sheetState: SheetState
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberBottomSheetState(
    sheetState: SheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    )
): BottomSheetState {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    return remember {
        DefaultBottomSheetState(
            sheetState = sheetState,
            coroutineScope = coroutineScope
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal class DefaultBottomSheetState(
    override val sheetState: SheetState,
    private val coroutineScope: CoroutineScope
) : BottomSheetState {

    override fun isVisible(): Boolean = sheetState.isVisible

    override fun show(onShown: () -> Unit) {
        coroutineScope.launch {
            sheetState.show()
        }.invokeOnCompletion {
            onShown()
        }
    }

    override fun hide(onHidden: () -> Unit) {
        coroutineScope.launch {
            sheetState.hide()
        }.invokeOnCompletion {
            onHidden()
        }
    }
}
