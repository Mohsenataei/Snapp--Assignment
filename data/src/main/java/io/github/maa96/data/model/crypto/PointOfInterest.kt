package io.github.maa96.data.model.crypto

import com.google.gson.annotations.SerializedName

data class PointOfInterest(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val latitude: Long,
    @SerializedName("longitude") val longitude: Long,
    @SerializedName("description") val description: String,
    @SerializedName("title") val title: String
)