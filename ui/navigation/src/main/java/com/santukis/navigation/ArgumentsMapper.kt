package com.santukis.navigation

import androidx.compose.runtime.Stable

@Stable
interface ArgumentsMapper {

    fun <Result : Any> map(from: Result): Any?
}
