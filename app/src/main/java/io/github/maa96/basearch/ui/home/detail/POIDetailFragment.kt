package io.github.maa96.basearch.ui.home.detail

import android.util.Log
import androidx.lifecycle.Observer
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.FragmentPoiDetailBinding
import com.mohsen.architecture.databinding.ViewpagerItemBinding
import io.github.maa96.basearch.ui.base.BaseFragment
import io.github.maa96.basearch.ui.base.ViewModelScope
import io.github.maa96.basearch.ui.base.adapter.ViewPagerAdapter

class POIDetailFragment : BaseFragment<POIDetailViewModel, FragmentPoiDetailBinding>() {
    override val viewModel: POIDetailViewModel by getLazyViewModel(ViewModelScope.FRAGMENT)
    override val layoutId: Int
        get() = R.layout.fragment_poi_detail

    override fun onViewInitialized(binding: FragmentPoiDetailBinding) {
        super.onViewInitialized(binding)
        val bundle = requireArguments()
        val id = bundle.getInt("POI_ID", 0)
        binding.adapter = ViewPagerAdapter<Image, ViewpagerItemBinding>(
            layoutId = R.layout.viewpager_item
        )
        viewModel.getPoiDetailById(id).observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onViewInitialized: ${it.data}")
            binding.adapter?.swapItems(listOf(Image(it.data?.image)))
            binding.item = it.data
        })
    }

    companion object {
        private const val TAG = "POIDetailFragment"
    }
}