package com.santukis.ca.data.repository.strategy

interface RepositoryStrategy<Input, Output> {

    suspend fun execute(input: Input): Output

}
