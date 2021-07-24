package io.github.maa96.basearch.ui.home.map

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.github.maa96.data.model.poi.PointOfInterestDto

data class Poi(
    val id: Int,
    val name: String,
    val description: String,
    val latitude: String,
    val longitude: String,
    val title: String,
    val image: String
)

fun mapToPoi(poiDtos: List<PointOfInterestDto>): List<Poi> = poiDtos.map {
    Poi(
        it.id,
        it.name,
        it.description,
        it.latitude,
        it.longitude,
        it.title,
        it.image
    )
}


