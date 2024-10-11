package com.santukis.ca.data.repository.strategy

interface LoadStrategy<Input, Output> : RepositoryStrategy<Input, Output> {

    suspend fun load(input: Input): Output

    override suspend fun execute(input: Input): Output = load(input)
}

interface SaveStrategy<Input, Output> : RepositoryStrategy<Input, Output> {

    suspend fun save(output: Input): Output

    override suspend fun execute(input: Input): Output = save(input)
}
