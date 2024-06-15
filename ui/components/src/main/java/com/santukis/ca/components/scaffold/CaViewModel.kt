package com.santukis.ca.components.scaffold

import androidx.lifecycle.ViewModel

abstract class CaViewModel<S : ScreenState> :
    ViewModel(),
    StateHolder<S>,
    ActionHandler