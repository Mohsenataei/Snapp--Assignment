package io.github.maa96.basearch.ui.home.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import io.github.maa96.basearch.ui.base.BaseViewModel
import io.github.maa96.data.model.poi.PointOfInterestDto
import io.github.maa96.data.repository.POIRepository
import javax.inject.Inject

class POIDetailViewModel @Inject constructor(
    private val poiRepository: POIRepository
) : BaseViewModel() {


    fun getPoiDetailById(pId: Int) = poiRepository.getPointOfInterestById(pId).asLiveData()


}