package com.santukis.ca.data.datasource.remote

import com.santukis.domain.usecases.model.Response
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Retrofit
import kotlin.coroutines.resume
import kotlin.reflect.jvm.javaType
import kotlin.reflect.typeOf

typealias RetrofitResponse<S> = retrofit2.Response<S>

class HttpClient(
    val retrofit: Retrofit
) : ServiceStore {

    private var apis: MutableMap<ServiceKey, Service> = mutableMapOf()

    override operator fun <A : Service> get(key: ServiceKey): A? = apis[key] as? A

    override fun addService(serviceKey: ServiceKey, service: Class<out Service>) {
        apis[serviceKey] = retrofit.create(service)
    }

    suspend inline fun <reified E, S> response(call: Call<S>?): Response<E?, S> =
        suspendCancellableCoroutine { continuation ->
            continuation.invokeOnCancellation {
                call?.cancel()
            }

            call?.enqueue(
                object : Callback<S> {
                    override fun onResponse(call: Call<S>, response: RetrofitResponse<S>) {
                        val body = response.body()
                        val errorBody = response.errorBody()

                        when {
                            response.isSuccessful && body != null -> continuation.resume(Response.Success(body))
                            errorBody != null && errorBody.contentLength() > 0 -> continuation.resume(
                                Response.Error(value = errorBody.parseException())
                            )
                            else -> continuation.resume(Response.Error(error = HttpException(response)))
                        }
                    }

                    override fun onFailure(call: Call<S>, throwable: Throwable) {
                        continuation.resume(Response.Error(error = throwable))
                    }
                }
            )
        }

    inline fun <reified Error> ResponseBody.parseException(): Error? =
        retrofit.converterFactories().firstNotNullOfOrNull { converterFactory ->
            val type = typeOf<Error>()

            converterFactory.responseBodyConverter(
                type.javaType,
                type.annotations.toTypedArray(),
                retrofit
            )?.convert(this) as? Error
        }
}
