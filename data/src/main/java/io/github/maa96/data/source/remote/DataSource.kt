package io.github.maa96.data.source.remote

import io.github.maa96.data.model.crypto.PointOfInterest
import io.github.maa96.data.source.remote.dtos.ResponseWrapper
import retrofit2.http.GET

interface DataSource {
    @GET("v1/POIs")
    suspend fun getAllPOIs(): List<PointOfInterest>
}