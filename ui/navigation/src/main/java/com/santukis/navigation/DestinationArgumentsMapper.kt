package com.santukis.navigation

interface DestinationArgumentsMapper {

    fun <Result : Any> map(from: Result): Any
}
