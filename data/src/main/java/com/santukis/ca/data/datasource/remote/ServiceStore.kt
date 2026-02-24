package com.santukis.ca.data.datasource.remote

interface ServiceStore {

    fun addService(serviceKey: ServiceKey, service: Class<out Service>)

    operator fun <A : Service> get(key: ServiceKey): A?
}
