package io.github.maa96.basearch.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mohsen.architecture.R
import io.github.maa96.basearch.ui.base.BaseNavigator
import javax.inject.Inject

class HomeNavigator @Inject constructor() : BaseNavigator {

    fun navigateToDetailFragment(fragment: Fragment, bundle: Bundle) {
        navigateTo(fragment, R.id.action_mapFragment_to_poiDetailFragment, bundle)
    }
}