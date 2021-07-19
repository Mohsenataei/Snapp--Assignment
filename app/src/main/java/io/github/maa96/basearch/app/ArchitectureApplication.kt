package io.github.maa96.basearch.app

import com.facebook.stetho.Stetho
import com.mapbox.mapboxsdk.Mapbox
import com.mohsen.architecture.BuildConfig
import com.mohsen.architecture.R
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.maa96.basearch.di.component.DaggerAppComponent

class ArchitectureApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)


    override fun onCreate() {
        super.onCreate()
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))
    }
    private fun initDebugModeValues() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}