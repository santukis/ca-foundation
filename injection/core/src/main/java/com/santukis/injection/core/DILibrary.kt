package com.santukis.injection.core

interface DILibrary<Module : DIModule<*>> {

    fun getModules(): List<Module>

    fun populate() { }
}
