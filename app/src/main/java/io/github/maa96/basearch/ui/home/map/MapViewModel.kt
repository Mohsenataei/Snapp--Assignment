package io.github.maa96.basearch.ui.home.map

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.basearch.ui.home.HomeNavigator
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.repository.POIRepository
import io.github.maa96.data.util.Resource
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: POIRepository,
    private val homeNavigator: HomeNavigator
) : BaseViewModel() {
    private val TAG = "MapViewModel"

    val allPois = poiRepository.getPointOfInterests().asLiveData()

    lateinit var poiMap: Map<Int, PointOfInterestDto>

    fun setPoiMap(pois: List<PointOfInterestDto>?) {
        poiMap = pois?.map {
            it.id to it
        }?.toMap()!!
    }

    fun getPoiById(id: Int?): PointOfInterestDto? {
        return poiMap[id]
    }

    fun navigateToPoiDetail(pid: Int) {
        val bundle = Bundle()
        bundle.putInt("POI_ID", pid)
        fragmentAction {
            homeNavigator.navigateToDetailFragment(it, bundle)
        }
    }


    init {
        getAllPOIs()
    }

    fun getAllPOIs() {
        poiRepository.getPointOfInterests().asLiveData().also {
            Log.d(TAG, "getAllPOIs: ${it.value}")
        }
    }
}