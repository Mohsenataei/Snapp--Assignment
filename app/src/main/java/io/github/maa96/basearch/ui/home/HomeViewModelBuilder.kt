package io.github.maa96.basearch.ui.home

import androidx.lifecycle.ViewModel
import com.mapbox.mapboxsdk.maps.MapView
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.maa96.basearch.di.builder.ViewModelKey
import io.github.maa96.basearch.ui.home.detail.POIDetailViewModel
import io.github.maa96.basearch.ui.home.map.MapViewModel


@Module
abstract class HomeViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    abstract fun bindMapViewModel(mapViewModel: MapViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(POIDetailViewModel::class)
    abstract fun bindPOIViewModel(poiDetailViewModel: POIDetailViewModel): ViewModel
}