package com.santukis.injection.core

interface DIGraph<Library : DILibrary<*>> {

    fun getLibraries(): List<Library>
}
