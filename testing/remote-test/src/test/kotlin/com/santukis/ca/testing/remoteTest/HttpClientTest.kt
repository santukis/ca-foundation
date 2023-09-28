package com.santukis.ca.testing.remoteTest

import com.santukis.ca.testing.remoteTest.mocks.AnythingEntity
import com.santukis.ca.testing.remoteTest.mocks.SampleService
import com.santukis.ca.testing.remoteTest.mocks.SampleServiceKey
import com.santukis.ca.testing.remoteTest.mocks.ServiceError
import com.santukis.domain.usecases.model.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import retrofit2.HttpException

@OptIn(ExperimentalCoroutinesApi::class)
class HttpClientTest : DataRemoteTest() {

    override fun initialize() {
        httpClient.addService(SampleServiceKey, SampleService::class.java)
    }

    @Test
    fun `get should return excepted model`() {
        runTest {
            val expectedResponse = AnythingEntity("any", 1)
            mockWebServer.enqueue(
                MockResponse().setBody(
                    """
                    {
                        "anyString": "any",
                        "anyInt": 1
                    }
                    """.trimIndent()
                )
            )

            val service: SampleService? = httpClient[SampleServiceKey]

            val response: Response<Unit?, AnythingEntity> = httpClient.response(service?.getAnything())

            assertEquals(expectedResponse, (response as Response.Success<*>).value)
        }
    }

    @Test
    fun `get should return excepted error`() {
        runTest {
            val expectedResponse = ServiceError("any", 1)
            mockWebServer.enqueue(
                MockResponse().setResponseCode(404).setBody(
                    """
                    {
                        "message": "any",
                        "code": 1
                    }
                    """.trimIndent()
                )
            )

            val service: SampleService? = httpClient[SampleServiceKey]

            val response: Response<ServiceError?, AnythingEntity> = httpClient.response(service?.getAnything())

            assertEquals(expectedResponse, (response as Response.Error<*>).value)
        }
    }

    @Test
    fun `get should return httpException`() {
        runTest {
            mockWebServer.enqueue(MockResponse().setResponseCode(404))

            val service: SampleService? = httpClient[SampleServiceKey]

            val response: Response<ServiceError?, AnythingEntity> = httpClient.response(service?.getAnything())

            assertTrue(response.isError() && (response as Response.Error).error is HttpException)
        }
    }
}
