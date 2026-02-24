package com.santukis.scaffold.di

import com.santukis.injection.koininjection.KoinDILibrary
import com.santukis.injection.koininjection.KoinDIModule

class AppDILibrary : KoinDILibrary() {

    override fun getModules(): List<KoinDIModule> =
        listOf(
            AppDIModule()
        )
}
