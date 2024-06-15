package com.santukis.scaffold.di

import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule

class AppDILibrary : com.santukis.injection.koininjection.KoinDILibrary() {

    override fun getModules(): List<com.santukis.injection.koininjection.KoinDIModule> =
        listOf(
            AppDIModule()
        )
}
