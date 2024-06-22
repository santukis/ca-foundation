package com.santukis.injection.core

import android.content.Context
import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

object DependencyInjectorProvider : DependencyInjector {

    private val providers: MutableList<DependencyInjector> = mutableListOf()

    fun addProvider(provider: DependencyInjector) {
        providers.add(provider)
    }

    override fun <Graph : DIGraph<*>> initialize(context: Context, graph: Graph) {
        providers.forEach { provider ->
            provider.initialize(
                context = context,
                graph = graph
            )
        }
    }

    override fun <T : Any> getDependency(
        clazz: KClass<*>,
        scopeId: String?,
        qualifier: String?
    ): T =
        providers.firstNotNullOf { provider ->
            provider.getDependency(
                clazz = clazz,
                scopeId = scopeId,
                qualifier = qualifier
            )
        }

    @Composable
    override fun <T : Any> getDependency(
        dependency: KClass<*>,
        into: KClass<*>
    ): T? =
        providers.firstNotNullOfOrNull { provider ->
            provider.getDependency(
                dependency = dependency,
                into = into
            )
        }
}
