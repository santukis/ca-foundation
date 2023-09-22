package com.santukis.ca.components.scaffold

interface ActionHandler<Action : ScreenAction> {

    fun handle(action: Action)
}
