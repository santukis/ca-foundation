package com.santukis.injection.providers.koin

import android.content.Context
import com.santukis.injection.core.DIGraph
import com.santukis.injection.core.DependencyInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal class KoinDependencyInjector : DependencyInjector {

    override fun <Graph : DIGraph<*>> initialize(
        context: Context,
        graph: Graph
    ) {
        (graph as? KoinDIGraph)?.let {
            startKoin {
                androidContext(context)
                modules(getModules(graph.getLibraries()))
            }

            graph.getLibraries().forEach { it.populate() }
        } ?: throw ExceptionInInitializerError("Graph is not a subclass of KoinDIGraph")
    }

    private fun getModules(diLibraries: List<KoinDILibrary>): List<Module> {
        val diModules = diLibraries.flatMap { it.getModules() }
        return diModules.map { it.getModule() }
    }
}
