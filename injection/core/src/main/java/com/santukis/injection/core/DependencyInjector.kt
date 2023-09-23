package com.santukis.injection.core

import android.content.Context
import kotlin.reflect.KClass

interface DependencyInjector {

    fun <Graph : DIGraph<*>> initialize(context: Context, graph: Graph)

    fun <T : Any> KClass<T>.getDependency(): T?
}
