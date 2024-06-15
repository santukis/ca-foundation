package com.santukis.injection.koininjection

import android.content.Context
import androidx.compose.runtime.Composable
import com.santukis.ca.components.scaffold.CaViewModel
import com.santukis.injection.core.DIGraph
import com.santukis.injection.core.DependencyInjector
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.TypeQualifier
import org.koin.core.qualifier.named
import org.koin.ext.getFullName
import org.koin.java.KoinJavaComponent
import kotlin.reflect.KClass

class KoinDependencyInjector : DependencyInjector {

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

    override fun <T : Any> getDependency(
        clazz: KClass<*>,
        scopeId: String?,
        qualifier: String?
    ): T? =
        if (scopeId.isNullOrEmpty()) {
            KoinJavaComponent
                .getKoin()
                .getOrNull(
                    clazz = clazz,
                    qualifier = qualifier?.let { named(name = it) }
                )
        } else {
            KoinJavaComponent
                .getKoin()
                .getScope(scopeId = scopeId)
                .getOrNull(
                    clazz = clazz,
                    qualifier = qualifier?.let { named(name = it) }
                )
        }

    @Composable
    override fun <T : Any> getDependency(
        dependency: KClass<*>,
        into:  KClass<*>
    ): T? =
        when {
            dependency == CaViewModel::class -> injectViewModel(into = into) as? T
            else -> injectDependency(
                dependency = dependency,
                into = into
            )
        }

    @Composable
    private fun  injectViewModel(
        into:  KClass<*>
    ): CaViewModel<*> =
        koinViewModel(
            scope = getKoin()
                .getOrCreateScope(
                    scopeId = into.getFullName(),
                    qualifier = TypeQualifier(into),
                    source = into
                )
        )


    @Composable
    private fun <T : Any> injectDependency(
        dependency: KClass<*>,
        into:  KClass<*>? = null
    ): T? =
        if (into == null) {
            getKoin().getOrNull(clazz = dependency)
        } else {
            getKoin()
                .getOrCreateScope(
                    scopeId = into.getFullName(),
                    qualifier = TypeQualifier(into),
                    source = into
                )
                .getOrNull(
                    clazz = dependency
                )
        }

    private fun getModules(diLibraries: List<KoinDILibrary>): List<Module> {
        val diModules = diLibraries.flatMap { it.getModules() }
        return diModules.map { it.getModule() }
    }
}
