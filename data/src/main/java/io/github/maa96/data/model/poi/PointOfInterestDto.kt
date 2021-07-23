package io.github.maa96.data.model.poi

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PointOfInterestDto(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("latitude") val latitude: Long,
    @SerializedName("longitude") val longitude: Long,
    @SerializedName("description") val description: String,
    @SerializedName("title") val title: String
)