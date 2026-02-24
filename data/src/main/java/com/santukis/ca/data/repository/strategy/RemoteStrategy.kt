package com.santukis.ca.data.repository.strategy

interface RemoteStrategy<Input, Output> : RepositoryStrategy<Input, Output> {

    suspend fun loadFromRemote(input: Input): Output

    suspend fun saveIntoLocal(output: Output): Output

    override suspend fun execute(input: Input): Output {
        val output = loadFromRemote(input)
        return saveIntoLocal(output)
    }
}
