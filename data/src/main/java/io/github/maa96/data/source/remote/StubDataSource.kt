package io.github.maa96.data.source.remote

import com.google.gson.Gson
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.source.local.file.BaseFileProvider
import kotlinx.coroutines.flow.Flow

/**
 * Stub implementation of [DataSource].
 *
 * <b>CAUTION : this implementation should be used only in debug mode</b>
 */
class StubDataSource(
    private val gson: Gson,
    private val fileProvider: BaseFileProvider
) : DataSource {

    override suspend fun getAllPOIs(): List<PointOfInterestDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getPOIById(pId: Int): PointOfInterestDto {
        TODO("Not yet implemented")
    }

    override fun getFlowOfPOIs(): Flow<List<PointOfInterestDto>> {
        TODO("Not yet implemented")
    }
}
