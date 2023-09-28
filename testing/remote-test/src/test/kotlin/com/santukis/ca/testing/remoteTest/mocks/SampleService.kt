package com.santukis.ca.testing.remoteTest.mocks

import com.santukis.ca.data.datasource.remote.Service
import retrofit2.Call
import retrofit2.http.GET

interface SampleService : Service {

    @GET("anyPath")
    fun getAnything(): Call<AnythingEntity>
}
