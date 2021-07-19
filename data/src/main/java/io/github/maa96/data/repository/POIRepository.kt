package io.github.maa96.data.repository

import arrow.core.Either
import io.github.maa96.data.di.qualifier.Concrete
import io.github.maa96.data.mapper.ErrorMapper
import io.github.maa96.data.model.Error
import io.github.maa96.data.model.crypto.PointOfInterest
import io.github.maa96.data.source.remote.DataSource
import javax.inject.Inject

class POIRepository @Inject constructor(
    errorMapper: ErrorMapper,
    @Concrete private val dataSource: DataSource
) : BaseRepository(errorMapper) {
    suspend fun getLatestUpdates(): Either<Error, List<PointOfInterest>> {
        return safeApiCall { dataSource.getAllPOIs() }
    }
}
