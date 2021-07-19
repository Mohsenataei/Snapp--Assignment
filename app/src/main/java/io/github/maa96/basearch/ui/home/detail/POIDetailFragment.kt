package io.github.maa96.basearch.ui.home.detail

import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.FragmentPoiDetailBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope

class POIDetailFragment : BaseFragment<POIDetailViewModel, FragmentPoiDetailBinding>() {
    override val viewModel: POIDetailViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_poi_detail
}