package io.github.maa96.data.source.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.maa96.data.model.poi.PointOfInterestDto
import kotlinx.coroutines.flow.Flow

@Dao
interface PointOfInterestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPois(pois: List<PointOfInterestDto>)

    @Query("DELETE from PointOfInterestDto")
    suspend fun deleteAllPois()

    @Query("SELECT * FROM PointOfInterestDto")
    fun getAllPois(): Flow<List<PointOfInterestDto>>

}