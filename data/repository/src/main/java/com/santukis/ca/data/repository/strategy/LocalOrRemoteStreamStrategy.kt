package com.santukis.ca.data.repository.strategy

import com.santukis.domain.usecases.model.Response
import com.santukis.domain.usecases.model.getOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface LocalOrRemoteStreamStrategy<Input, Output> :
    RepositoryStrategy<Input, Flow<Response<Throwable, Output>>> {

        suspend fun loadFromLocal(input: Input): Response<Throwable, Output>

        suspend fun loadFromRemote(input: Input): Response<Throwable, Output>

        suspend fun saveIntoLocal(output: Output?): Response<Throwable, Output>

    override suspend fun execute(input: Input): Flow<Response<Throwable, Output>> =
        flow {
            val localResult = loadFromLocal(input)

            if (localResult.isSuccess()) {
                emit(localResult)
            }

            val remoteResult = loadFromRemote(input)

            val updatedLocalResult = saveIntoLocal(remoteResult.getOrNull())
                .takeIf { remoteResult.isSuccess() }
                ?: remoteResult

            if (localResult.isError()) {
                emit(updatedLocalResult)
            }
        }
}
