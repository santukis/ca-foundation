package com.santukis.injection.providers.koin

import android.content.Context
import androidx.compose.runtime.Composable
import com.santukis.injection.core.DIGraph
import com.santukis.injection.core.DependencyInjector
import org.koin.android.ext.koin.androidContext
import org.koin.compose.getKoin
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.ext.getFullName
import org.koin.java.KoinJavaComponent
import kotlin.reflect.KClass

internal class KoinDependencyInjector : DependencyInjector {

    override fun <Graph : DIGraph<*>> initialize(
        context: Context,
        graph: Graph
    ) {
        (graph as? KoinDIGraph)?.let { diGraph ->
            startKoin {
                androidContext(context)
                modules(getModules(diGraph.getLibraries()))
            }

            diGraph.getLibraries().forEach { it.populate(this) }
        } ?: throw ExceptionInInitializerError("Graph is not a subclass of KoinDIGraph")
    }

    override fun <T : Any> KClass<T>.getDependency(): T? =
        KoinJavaComponent.getKoin().getOrNull(this)

    @Composable
    override fun <S : Any, T : Any> injectComposable(from: KClass<S>, to: KClass<T>): T =
        getKoin()
            .getOrCreateScope(
                scopeId = from.getFullName(),
                qualifier = TypeQualifier(from),
                source = this
            ).get(
                clazz = to
            )

    private fun getModules(diLibraries: List<KoinDILibrary>): List<Module> {
        val diModules = diLibraries.flatMap { it.getModules() }
        return diModules.map { it.getModule() }
    }
}
