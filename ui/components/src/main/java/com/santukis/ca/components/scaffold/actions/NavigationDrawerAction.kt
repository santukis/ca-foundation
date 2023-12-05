package com.santukis.ca.components.scaffold.actions

import com.santukis.ca.components.scaffold.ScreenAction

open class NavigationDrawerAction : ScreenAction {

    open class OpenDrawer : NavigationDrawerAction()

    open class CloseDrawer : NavigationDrawerAction()
}
