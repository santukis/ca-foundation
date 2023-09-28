package com.santukis.ca.data.repository.strategy

abstract class LocalStrategy<Input, Output> : RepositoryStrategy<Input, Output> {

    protected abstract suspend fun loadFromLocal(input: Input): Output

    override suspend fun execute(input: Input): Output {
        return loadFromLocal(input)
    }
}
