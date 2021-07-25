package io.github.maa96.data.source.db.dao

import androidx.room.*
import arrow.core.Id
import io.github.maa96.data.model.poi.PointOfInterestDto
import kotlinx.coroutines.flow.Flow

@Dao
interface PointOfInterestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPois(pois: List<PointOfInterestDto>)

    @Query("Select * From PointOfInterestDto WHERE `id` == :pId")
    fun getPoiById(pId: Int): Flow<PointOfInterestDto>

    @Query("DELETE from PointOfInterestDto")
    suspend fun deleteAllPois()

    @Query("DELETE FROM PointOfInterestDto WHERE id == :pId")
    suspend fun deletePoiById(pId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoi(poi: PointOfInterestDto)

    @Query("SELECT * FROM PointOfInterestDto")
    fun getAllPois(): Flow<List<PointOfInterestDto>>

}