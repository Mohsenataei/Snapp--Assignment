package io.github.maa96.basearch.ui.home.map

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.repository.POIRepository
import io.github.maa96.data.util.Resource
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: POIRepository
) : BaseViewModel() {
    private val TAG = "MapViewModel"

    val _allPois = poiRepository.getPointOfInterests().asLiveData()
    val allPois: LiveData<Resource<List<PointOfInterestDto>>>
        get() = _allPois


    init {
        getAllPOIs()
    }

    fun getAllPOIs() {
        poiRepository.getPointOfInterests().asLiveData().also {
            Log.d(TAG, "getAllPOIs: ${it.value}")
        }
    }
}