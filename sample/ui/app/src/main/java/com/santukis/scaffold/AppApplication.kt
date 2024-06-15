package com.santukis.scaffold

import android.app.Application
import com.santukis.injection.core.DependencyInjectorProvider
import com.santukis.injection.koininjection.KoinDependencyInjector
import com.santukis.scaffold.di.AppDIGraph

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DependencyInjectorProvider.addProvider(
            provider = KoinDependencyInjector()
        )

        DependencyInjectorProvider.initialize(
            context = this,
            graph = AppDIGraph()
        )
    }
}
