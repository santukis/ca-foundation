package com.santukis.injection.core

import com.santukis.injection.providers.koin.KoinDependencyInjector

object DependencyInjectorProvider {

    fun provide(): DependencyInjector = KoinDependencyInjector()
}
