package com.santukis.navigation

interface ArgumentsMapper {

    fun <Result : Any> map(from: Result): Any?
}
