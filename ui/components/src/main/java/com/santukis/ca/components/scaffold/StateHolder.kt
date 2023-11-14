package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.StateFlow

@Stable
interface StateHolder<State : ScreenState> {

    fun getState(): StateFlow<State>
}
