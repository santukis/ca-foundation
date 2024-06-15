package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Stable

@Stable
interface ActionHandler {

    fun handle(action: Action)
}
