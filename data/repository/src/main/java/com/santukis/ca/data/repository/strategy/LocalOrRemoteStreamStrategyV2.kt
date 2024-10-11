package com.santukis.ca.data.repository.strategy

import com.santukis.domain.usecases.model.Response
import com.santukis.domain.usecases.model.getOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class LocalOrRemoteStreamStrategyV2<Input, Output>(
    open val loadFromLocal: RepositoryStrategy<Input, Response<Throwable, Output>>,
    open val loadFromRemote: RepositoryStrategy<Input, Response<Throwable, Output>>,
    open val saveIntoLocal: RepositoryStrategy<Output?, Response<Throwable, Output>>
) : RepositoryStrategy<Input, Flow<Response<Throwable, Output>>> {

    override suspend fun execute(input: Input): Flow<Response<Throwable, Output>> =
        flow {
            val localResult = loadFromLocal.execute(input)

            if (localResult.isSuccess()) {
                emit(localResult)
            }

            val remoteResult = loadFromRemote.execute(input)

            val updatedLocalResult = saveIntoLocal.execute(remoteResult.getOrNull())
                .takeIf { remoteResult.isSuccess() }
                ?: remoteResult

            if (localResult.isError()) {
                emit(updatedLocalResult)
            }
        }
}
