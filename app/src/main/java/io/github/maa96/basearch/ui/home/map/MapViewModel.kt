package io.github.maa96.basearch.ui.home.map

import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import io.github.maa96.basearch.ui.base.BaseViewModel
import javax.inject.Inject

class MapViewModel @Inject constructor() : BaseViewModel() {


    fun initMap(mapView: MapView?){

        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
            }
        }
    }
}