package com.santukis.injection.core

import android.content.Context
import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

interface DependencyInjector {

    fun <Graph : DIGraph<*>> initialize(context: Context, graph: Graph)

    fun <T : Any> KClass<T>.getDependency(): T?

    @Composable
    fun <S : Any, T : Any> injectComposable(from: KClass<S>, to: KClass<T>): T
}
