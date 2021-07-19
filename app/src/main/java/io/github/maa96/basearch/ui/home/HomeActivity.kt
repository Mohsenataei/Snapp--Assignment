package io.github.maa96.basearch.ui.home

import android.os.Bundle
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mohsen.architecture.BuildConfig
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.ActivityHomeBinding
import io.github.maa96.basearch.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    override val viewModel: HomeViewModel by getLazyViewModel()
    override val layoutId: Int
        get() = R.layout.activity_home

    private var mapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewInitialized(binding: ActivityHomeBinding) {
        super.onViewInitialized(binding)
        mapView = binding.mapView
        mapView?.getMapAsync { mapboxMap ->
            mapboxMap.setStyle(Style.MAPBOX_STREETS) {
                // Map is set up and the style has loaded. Now you can add data or make other map adjustments
            }
        }

    }
}