package io.github.maa96.basearch.ui.home.map


import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.FragmentMapBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>() {
    override val viewModel: MapViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_map

    override fun onViewInitialized(binding: FragmentMapBinding) {
        super.onViewInitialized(binding)
        viewModel.initMap(binding.mapView)
    }
}