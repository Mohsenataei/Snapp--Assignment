package io.github.maa96.basearch.ui.home.map


import android.graphics.Color
import com.mapbox.mapboxsdk.Mapbox
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
import com.mohsen.architecture.databinding.PoiDetailBottomSheetBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope
import io.github.maa96.basearch.ui.home.map.bottomsheet.POIDetailBottomSheet
import java.util.*

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>(), OnSymbolClickListener {
    override val viewModel: MapViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_map
    private lateinit var mapView: MapView
    private lateinit var symbolManager: SymbolManager
    private val random = Random()
    private var markerViewManager: MarkerViewManager? = null
    private var marker: MarkerView? = null

    override fun onViewInitialized(binding: FragmentMapBinding) {
        super.onViewInitialized(binding)
        mapView = binding.mapView
        initMap(binding.mapView)
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

    override fun onAnnotationClick(t: Symbol?): Boolean {
        val poiDetailBottomSheet = POIDetailBottomSheet()
        poiDetailBottomSheet.show(childFragmentManager, "")
        return true
    }
}