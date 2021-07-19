package io.github.maa96.basearch.ui.home.map

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.data.repository.POIRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: POIRepository
) : BaseViewModel() {
    private val TAG = "MapViewModel"


    init {
        getAllPOIs()
    }

    fun initMap(mapView: MapView?) {
        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
            }
        }
    }

    fun getAllPOIs() {
        viewModelScope.launch {
            poiRepository.getLatestUpdates().fold(
                {
                    Log.d(TAG, "getAllPOIs: $it")
                },
                {
                    Log.d(TAG, "getAllPOIs: $it")
                }
            )
        }
    }
}