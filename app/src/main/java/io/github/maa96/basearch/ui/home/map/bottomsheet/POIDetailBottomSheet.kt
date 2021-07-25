package io.github.maa96.basearch.ui.home.map.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mohsen.architecture.R
import com.mohsen.architecture.databinding.PoiDetailBottomSheetBinding
import io.github.maa96.data.model.poi.PointOfInterestDto

class POIDetailBottomSheet(
    private val poi: PointOfInterestDto,
    val onClick: (() -> Unit)? = null
) : BottomSheetDialogFragment() {
    private lateinit var binding: PoiDetailBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.poi_detail_bottom_sheet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = poi
        binding.poiContainer.setOnClickListener {
            onClick?.invoke()
        }
    }
}