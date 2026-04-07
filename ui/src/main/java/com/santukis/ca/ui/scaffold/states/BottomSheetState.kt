package com.santukis.ca.ui.scaffold.states

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Represents the state of a bottom sheet, including its visibility and sheet-specific properties.
 *
 * It extends [VisibilityState] to provide basic show/hide functionality.
 *
 * @see VisibilityState
 */
@OptIn(ExperimentalMaterial3Api::class)
interface BottomSheetState : VisibilityState {
    /**
     * The underlying [SheetState] from Material 3, which controls the bottom sheet's properties
     * like position, expansion, and anchors.
     */
    val sheetState: SheetState
}

/**
 * Creates and remembers a [BottomSheetState] for a bottom sheet.
 *
 * This function provides a convenient way to manage the state of a bottom sheet within a Composable.
 *
 * @param sheetState The underlying [SheetState] to be used. Defaults to a standard bottom sheet state
 * that is initially hidden.
 * @return A remembered instance of [BottomSheetState].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomSheetState(
    sheetState: SheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Hidden,
        skipHiddenState = false
    )
): BottomSheetState {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    return DefaultBottomSheetState(
        sheetState = sheetState,
        coroutineScope = coroutineScope
    )
}

/**
 * The default implementation of [BottomSheetState].
 *
 * It uses a [CoroutineScope] to launch suspend functions for showing and hiding the sheet.
 *
 * @param sheetState The underlying Material 3 [SheetState].
 * @param coroutineScope The coroutine scope used to animate the sheet's visibility.
 */
@OptIn(ExperimentalMaterial3Api::class)
internal class DefaultBottomSheetState(
    override val sheetState: SheetState,
    private val coroutineScope: CoroutineScope
) : BottomSheetState {

    /**
     * Indicates whether the bottom sheet is currently visible on the screen.
     *
     * @return `true` if the sheet is visible, `false` otherwise.
     */
    override fun isVisible(): Boolean = sheetState.isVisible

    /**
     * Shows the bottom sheet with an animation.
     *
     * @param onShown A callback to be invoked after the sheet has been fully shown.
     */
    override fun show(onShown: () -> Unit) {
        coroutineScope.launch {
            sheetState.show()
        }.invokeOnCompletion {
            onShown()
        }
    }

    /**
     * Hides the bottom sheet with an animation.
     *
     * @param onHidden A callback to be invoked after the sheet has been fully hidden.
     */
    override fun hide(onHidden: () -> Unit) {
        coroutineScope.launch {
            sheetState.hide()
        }.invokeOnCompletion {
            onHidden()
        }
    }
}
