package com.santukis.injection.core

import android.content.Context

interface DependencyInjector {

    fun <Graph : DIGraph<*>> initialize(context: Context, graph: Graph)
}
