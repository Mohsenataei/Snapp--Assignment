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

    override fun getFlowOfPOIs(): Flow<List<PointOfInterestDto>> {
        TODO("Not yet implemented")
    }
//    (
//        start: Int,
//        limit: Int,
//        convertTo: String
//    ): ResponseWrapper<List<PointOfInterest>> {
//        val inputStream = fileProvider.getAsset("latest_updates.json")
//        val response = String(fileProvider.getByteArrayFromInputStream(inputStream))
//        return gson.fromJson(response) ?: throw JsonParseException("provided json file is not ")
//    }
}
