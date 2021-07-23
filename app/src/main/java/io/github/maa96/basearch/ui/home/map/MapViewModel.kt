package io.github.maa96.basearch.ui.home.map

import android.animation.ValueAnimator
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.FrameLayout
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.*
import com.mapbox.mapboxsdk.plugins.markerview.MarkerView
import com.mapbox.mapboxsdk.plugins.markerview.MarkerViewManager
import com.mapbox.mapboxsdk.utils.ColorUtils
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.data.repository.POIRepository
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: POIRepository
) : BaseViewModel(), OnSymbolClickListener, OnSymbolLongClickListener {
    private val TAG = "MapViewModel"

    private lateinit var symbolManager: SymbolManager
    private val random = Random()
    private var markerViewManager: MarkerViewManager? = null
    private var marker: MarkerView? = null


    init {
        getAllPOIs()
    }

    fun initMap(mapView: MapView?) {

    }

//    private fun createCustomMarker() {
//        // create a custom animation marker view
//        val customView = createCustomAnimationView()
//        marker = MarkerView(LatLng(), customView)
//        marker?.let {
//            markerViewManager?.addMarker(it)
//        }
//    }

//    private fun createCustomAnimationView(): View {
//        val customView = LayoutInflater.from(this).inflate(R.layout.marker_view, null)
//        customView.layoutParams = FrameLayout.LayoutParams(
//            ViewGroup.LayoutParams.WRAP_CONTENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
//        val icon = customView.findViewById<View>(R.id.imageview)
//        val animationView = customView.findViewById<View>(R.id.animation_layout)
//        icon.setOnClickListener { view ->
//            val anim = ValueAnimator.ofInt(animationView.measuredWidth, 350)
//            anim.interpolator = AccelerateDecelerateInterpolator()
//            anim.addUpdateListener { valueAnimator ->
//                val `val` = valueAnimator.animatedValue as Int
//                val layoutParams = animationView.layoutParams
//                layoutParams.width = `val`
//                animationView.layoutParams = layoutParams
//            }
//            anim.duration = 1250
//            anim.start()
//        }
//        return customView
//    }

    fun getAllPOIs() {
        poiRepository.getPointOfInterests().asLiveData().also {
            Log.d(TAG, "getAllPOIs: ${it.value}")
        }
//        viewModelScope.launch {
//            poiRepository.getLatestUpdates().fold(
//                {
//                    Log.d(TAG, "getAllPOIs: $it")
//                },
//                {
//                    Log.d(TAG, "getAllPOIs: $it")
//                }
//            )
//        }
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