package io.github.maa96.data.source.remote

import io.github.maa96.data.model.poi.PointOfInterestDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface DataSource {
    @GET("v1/POIs")
    suspend fun getAllPOIs(): List<PointOfInterestDto>

    @GET("v1/POIs/{id}")
    suspend fun getPOIById(@Path("id") pId: Int): PointOfInterestDto

    @GET("v1/POIs")
    fun getFlowOfPOIs(): Flow<List<PointOfInterestDto>>
}