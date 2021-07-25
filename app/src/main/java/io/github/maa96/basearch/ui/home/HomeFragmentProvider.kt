package io.github.maa96.basearch.ui.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.github.maa96.basearch.ui.home.detail.POIDetailFragment
import io.github.maa96.basearch.ui.home.map.MapFragment
import io.github.maa96.basearch.ui.home.map.bottomsheet.POIDetailBottomSheet


@Module
abstract class HomeFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideMapFragment(): MapFragment

    @ContributesAndroidInjector
    abstract fun providePOIDetailFragment(): POIDetailFragment

    @ContributesAndroidInjector
    abstract fun providePOIDetailSheetFragment(): POIDetailBottomSheet

}