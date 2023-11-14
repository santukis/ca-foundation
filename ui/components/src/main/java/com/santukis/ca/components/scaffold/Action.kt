package com.santukis.ca.components.scaffold

import androidx.compose.runtime.Stable

@Stable
interface Action

@Stable
interface ScreenAction : Action

@Stable
interface NavigationAction : Action
