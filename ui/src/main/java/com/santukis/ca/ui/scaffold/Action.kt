package com.santukis.ca.ui.scaffold

import androidx.compose.runtime.Stable

@Stable
interface Action

@Stable
interface ScreenAction : Action

@Stable
interface NavigationAction : Action
