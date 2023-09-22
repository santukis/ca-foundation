package com.santukis.ca.components.scaffold

import kotlinx.coroutines.flow.StateFlow

interface StateHolder<State : ScreenState> {

    fun getState(): StateFlow<State>
}
