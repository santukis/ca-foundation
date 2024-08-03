package com.santukis.ca.data.datasource.local

import android.content.Context
import com.santukis.ca.data.repository.source.DataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.Type

interface LocalDataSource : DataSource

fun Context.loadJsonFromAssets(
    fileName: String
): String? = try {
    assets
        .open(fileName)
        .bufferedReader()
        .toString()

} catch (exception: Exception) {
    null
}

inline fun <reified T> String.mapAs(
    type: Type
): T? = try {
    Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter<T>(type)
        .fromJson(this)

} catch (exception: Exception) {
    null
}