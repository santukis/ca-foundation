package com.santukis.usecase.input

interface UseCase<Params, Result> {
    suspend operator fun invoke(params: Params): Result
}

suspend fun <Input : Any, Result> Input.then(other: UseCase<Input, Result>): Result =
    other.invoke(this)
