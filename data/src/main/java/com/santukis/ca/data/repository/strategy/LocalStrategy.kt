package com.santukis.ca.data.repository.strategy

interface LocalStrategy<Input, Output> : RepositoryStrategy<Input, Output> {

    suspend fun loadFromLocal(input: Input): Output

    override suspend fun execute(input: Input): Output {
        return loadFromLocal(input)
    }
}
