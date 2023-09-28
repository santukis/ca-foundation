package com.santukis.ca.testing.remoteTest

import com.santukis.ca.data.datasource.remote.HttpClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.BeforeEach
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class DataRemoteTest(
    protected open val baseUrl: String = ""
) {

    protected open lateinit var mockWebServer: MockWebServer
    protected open lateinit var httpClient: HttpClient

    abstract fun initialize()

    @BeforeEach
    fun setUp() {
        mockWebServer = MockWebServer()
        val moshiConverter = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url(baseUrl))
            .client(OkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create(moshiConverter))
            .build()

        httpClient = HttpClient(retrofit)

        initialize()
    }
}
