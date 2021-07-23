package io.github.maa96.data.repository

import androidx.room.withTransaction
import arrow.core.Either
import io.github.maa96.data.di.qualifier.Concrete
import io.github.maa96.data.mapper.ErrorMapper
import io.github.maa96.data.model.Error
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.source.db.AppDataBase
import io.github.maa96.data.source.db.dao.PointOfInterestDao
import io.github.maa96.data.source.remote.DataSource
import javax.inject.Inject

class POIRepository @Inject constructor(
    errorMapper: ErrorMapper,
    @Concrete private val dataSource: DataSource,
    private val pointOfInterestDao: PointOfInterestDao,
    private val db: AppDataBase
) : BaseRepository(errorMapper) {
    suspend fun getLatestUpdates(): Either<Error, List<PointOfInterestDto>> {
        return safeApiCall { dataSource.getAllPOIs() }
    }

    fun getPointOfInterests() = networkBoundResource(
        query = {
            pointOfInterestDao.getAllPois()
        },
        fetch = {
            dataSource.getAllPOIs()
        },
        saveFetchedResult = { pointOfInterests ->
            db.withTransaction {
                pointOfInterestDao.deleteAllPois()
                pointOfInterestDao.insertPois(pointOfInterests)
            }
        }
    )


}
