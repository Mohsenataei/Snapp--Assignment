package io.github.maa96.basearch.ui.home.map


import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.FragmentMapBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>() {
    override val viewModel: MapViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_map
    private lateinit var mapView: MapView
    override fun onViewInitialized(binding: FragmentMapBinding) {
        super.onViewInitialized(binding)
        mapView = binding.mapView
        viewModel.initMap(binding.mapView)
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}