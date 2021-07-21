package io.github.maa96.data.repository

import arrow.core.Either
import io.github.maa96.data.mapper.ErrorMapper
import io.github.maa96.data.model.Error
import io.github.maa96.data.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

abstract class BaseRepository(private val errorMapper: ErrorMapper) {
    protected suspend fun <T : Any> safeApiCall(call: suspend () -> T): Either<Error, T> {
        return withContext(Dispatchers.IO) {
            getResult(call)
        }
    }

    private suspend fun <T : Any> getResult(call: suspend () -> T): Either<Error, T> {
        return try {
            Either.right(call.invoke())
        } catch (t: Throwable) {
            Either.left(errorMapper.getError(t))
        }
    }

    /**
     * This is a generic function
     * */
    @OptIn(ExperimentalCoroutinesApi::class)
    inline protected fun <ResultType, RequestType> networkBoundResource(
        crossinline query: () -> Flow<ResultType>,
        crossinline fetch: suspend () -> RequestType,
        crossinline saveFetchedResult: suspend (RequestType) -> Unit,
        crossinline shouldFetch: (ResultType) -> Boolean = { true }
    ) = flow {
        val data = query().first()
        val flow = if (shouldFetch(data)) {
            emit(Resource.Loading(data))
            try {
                saveFetchedResult(fetch())
                query().map { Resource.Success(it) }
            } catch (throwable: Throwable) {
                query().map { Resource.Error(it, throwable) }
            }
        } else {
            query().map { Resource.Success(it) }
        }
        emitAll(flow)

        // This is functional implementation of above piece of code but todo remember to test it
        shouldFetch(data).takeIf { it }?.apply {
            emit(Resource.Loading(data))
            try {
                saveFetchedResult(fetch())
                query().map { Resource.Success(it) }
            } catch (throwable: Throwable) {
                query().map { Resource.Error(it, throwable) }
            }
        } ?: let {
            query().map { Resource.Success(it) }
        }
        emitAll(flow)
    }

}