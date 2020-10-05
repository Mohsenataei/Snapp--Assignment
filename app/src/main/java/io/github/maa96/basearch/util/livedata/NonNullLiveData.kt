package io.github.maa96.basearch.util.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * This is a wrapper for [MutableLiveData] which never accept or  return null value
 * The [defaultValue] makes all observers to observe data at least one time
 *
 * @param defaultValue will be set to [MutableLiveData.setValue] at the first time, and after that
 * all null values in [getValue], [setValue] and [observe] will be replaced with default value
 * */

class NonNullLiveData<T>(private val defaultValue: T) : MutableLiveData<T>() {

    init {
        value = defaultValue
    }


    /**
     * @return returns current value, if value is null returns [defaultValue]
     * */
    override fun getValue(): T = super.getValue() ?: defaultValue


    /**
     * @param value if it is not null will be set, otherwise [defaultValue] will be replaced.
     */
    override fun setValue(value: T) {
        super.setValue(value ?: defaultValue)
    }


    fun observe(body: (T) -> Unit) {
        observeForever { body(it ?: defaultValue) }
    }


    /**
     * @param owner an instance of [LifecycleOwner] to observe on.
     * @param body a lambda function will be invoke if value is not null, otherwise
     * [defaultValue] will be replaced.
     */
    fun observe(owner: LifecycleOwner, body: (T) -> Unit) {
        observe(owner, Observer { body(it ?: defaultValue) })
    }

    /**
     * @param value will be set if it is not null, otherwise [defaultValue] will be replaced.
     */
    override fun postValue(value: T?) =
        super.postValue(value ?: defaultValue)


}