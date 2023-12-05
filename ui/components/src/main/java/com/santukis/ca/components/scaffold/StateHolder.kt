package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Stable
import androidx.compose.runtime.State

@Stable
interface StateHolder<S : ScreenState> {

    fun getState(): State<S>
}
