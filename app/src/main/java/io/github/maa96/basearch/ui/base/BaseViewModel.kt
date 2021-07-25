package io.github.maa96.basearch.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.github.maa96.basearch.util.livedata.ActivityActionLiveData
import io.github.maa96.basearch.util.livedata.FragmentActionLiveData

/*
* A BaseViewModel for all ViewModels in this project, all viewModels shoud inherit this BaseViewModel
* */
abstract class BaseViewModel() : ViewModel(), LifecycleObserver {

    var activityAction = ActivityActionLiveData()
    var fragmentAction = FragmentActionLiveData()

    /**
     * We can use lifeCycle in inherited classes if we need
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {}

    /**
     * We can use lifeCycle in inherited classes if we need
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun onStop() {}


}