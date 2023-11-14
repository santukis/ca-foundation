package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Stable

@Stable
interface ActionHandler<Action : ScreenAction> {

    fun handle(action: Action)
}
