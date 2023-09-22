package com.santukis.scaffold

import android.app.Application
import com.santukis.injection.core.DependencyInjector
import com.santukis.injection.core.DependencyInjectorProvider
import com.santukis.scaffold.di.AppDIGraph

class AppApplication : Application() {

    private val dependencyInjector: DependencyInjector =
        DependencyInjectorProvider.provide()

    override fun onCreate() {
        super.onCreate()

        dependencyInjector.initialize(
            context = this,
            graph = AppDIGraph()
        )
    }
}
