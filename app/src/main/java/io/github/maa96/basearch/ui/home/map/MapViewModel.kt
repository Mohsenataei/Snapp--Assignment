package io.github.maa96.basearch.ui.home.map

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.*
import com.mapbox.mapboxsdk.utils.ColorUtils
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.data.repository.POIRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: POIRepository
) : BaseViewModel(), OnSymbolClickListener, OnSymbolLongClickListener {
    private val TAG = "MapViewModel"

    private lateinit var symbolManager: SymbolManager


    init {
        getAllPOIs()
    }

    fun initMap(mapView: MapView?) {
        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
                symbolManager = SymbolManager(mapView, mapboxMap, style)

                symbolManager.addClickListener(this)
                symbolManager.addLongClickListener(this)
                // Set non-data-driven properties.
                symbolManager.iconAllowOverlap = true
                symbolManager.iconIgnorePlacement = true

                // Create a symbol at the specified location.

                // create nearby symbols

                // create nearby symbols
                val nearbyOptions = SymbolOptions()
                    .withLatLng(LatLng(6.626384, 0.367099))
                    .withIconImage("fire-station-15")
                    .withIconColor(ColorUtils.colorToRgbaString(Color.BLUE))
                    .withIconSize(2f)
                    .withSymbolSortKey(5.0f)
                symbolManager.create(nearbyOptions)
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

    override fun onAnnotationClick(t: Symbol?): Boolean {
        Log.d(TAG, "onAnnotationClick: $t")
        return true
    }

    override fun onAnnotationLongClick(t: Symbol?): Boolean {
        Log.d(TAG, "onAnnotationLongClick: $t")
        return true
    }
}