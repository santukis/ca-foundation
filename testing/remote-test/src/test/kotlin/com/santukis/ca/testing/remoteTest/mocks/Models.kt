package com.santukis.ca.testing.remoteTest.mocks

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnythingEntity(
    val anyString: String,
    val anyInt: Int
)

@JsonClass(generateAdapter = true)
data class ServiceError(
    val message: String,
    val code: Int
)
