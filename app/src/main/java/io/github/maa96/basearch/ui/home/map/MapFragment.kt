package io.github.maa96.basearch.ui.home.map


import android.graphics.Color
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.OnSymbolClickListener
import com.mapbox.mapboxsdk.plugins.annotation.Symbol
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions
import com.mapbox.mapboxsdk.plugins.markerview.MarkerView
import com.mapbox.mapboxsdk.plugins.markerview.MarkerViewManager
import com.mapbox.mapboxsdk.utils.ColorUtils
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.FragmentMapBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope
import io.github.maa96.basearch.ui.home.map.bottomsheet.POIDetailBottomSheet
import io.github.maa96.basearch.util.extension.observe
import io.github.maa96.basearch.util.extension.stringToInt
import io.github.maa96.basearch.util.extension.withData
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.util.Resource.*
import java.util.*
import kotlin.Error

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>(), OnSymbolClickListener {
    override val viewModel: MapViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_map
    private lateinit var mapView: MapView
    private lateinit var symbolManager: SymbolManager
    private var markerViewManager: MarkerViewManager? = null
    private var marker: MarkerView? = null

    override fun onViewInitialized(binding: FragmentMapBinding) {
        super.onViewInitialized(binding)
        mapView = binding.mapView
        initMap(binding.mapView)
        viewModel.allPois.observe(viewLifecycleOwner) {
            when (it) {
                is Loading -> {
                    // do nothing, we do not need it yet
                }
                is Success -> {
                    viewModel.setPoiMap(it.data)
                    addPointsToMap(it.data)
                    Log.d(TAG, "onViewInitialized: ${it.data}")
                }

                is Error -> {
                    Toast.makeText(requireContext(), "${it.error?.cause}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun addPointsToMap(data: List<PointOfInterestDto>?) {
        // create nearby symbols
        data?.forEach {
            val nearbyOptions = SymbolOptions()
                .withLatLng(LatLng(it.latitude.toDouble(), it.longitude.toDouble()))
                .withIconImage("fire-station-15")
                .withIconColor(ColorUtils.colorToRgbaString(Color.BLUE))
                .withIconSize(2f)
                .withSymbolSortKey(5.0f)
                .withData(it.id.toString())
            symbolManager.create(nearbyOptions)
        }

    }

    private fun initMap(bindingMapView: MapView) {
        mapView = bindingMapView
        mapView.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
                symbolManager = SymbolManager(mapView, mapboxMap, style)
                markerViewManager = MarkerViewManager(mapView, mapboxMap)


                symbolManager.addClickListener(this)
//                symbolManager.addLongClickListener(this)
                // Set non-data-driven properties.
                symbolManager.iconAllowOverlap = true
                symbolManager.iconIgnorePlacement = true
            }
        }
    }

    override fun onAnnotationClick(symbol: Symbol?): Boolean {
        Log.d(TAG, "onAnnotationClick: data is ${symbol?.data}")
        val data = symbol?.data
        val id = data?.stringToInt()
        Log.d(
            TAG, "onAnnotationClick: poi info is ${
                viewModel.getPoiById(
                    id
                )
            }"
        )
        val poiDetailBottomSheet = POIDetailBottomSheet(viewModel.getPoiById(id)!!) {
            viewModel.navigateToPoiDetail(id!!)
        }
        poiDetailBottomSheet.show(childFragmentManager, "")
        return true
    }

    companion object {
        private const val TAG = "MapFragment"
    }
}