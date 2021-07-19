package io.github.maa96.basearch.ui.home

import android.os.Bundle
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.ActivityHomeBinding
import io.github.maa96.basearch.ui.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    override val viewModel: HomeViewModel by getLazyViewModel()

    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onViewInitialized(binding: ActivityHomeBinding) {
        super.onViewInitialized(binding)
    }
}