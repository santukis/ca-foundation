package com.santukis.injection.core

import android.content.Context
import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

interface DependencyInjector {

    fun <Graph : DIGraph<*>> initialize(context: Context, graph: Graph)

    fun <T : Any> getDependency(
        clazz: KClass<*>,
        scopeId: String? = null,
        qualifier: String? = null
    ): T

    @Composable
    fun <T : Any> getDependency(
        dependency: KClass<*>,
        into: KClass<*>
    ): T?
}
