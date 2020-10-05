package io.github.maa96.basearch.util.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean


/**
 * Custom wrapper for {@link MutableLiveData} that calls observer only one time
 * @param <T>
 */
open class SingleEventLiveData<T> : MutableLiveData<T>() {
    private var mPending = AtomicBoolean(false)

    override fun setValue(value: T) {
        mPending.set(true)
        super.setValue(value)
    }

    override fun observe(
        owner: LifecycleOwner,
        observer: Observer<in T>
    ) {
        super.observe(owner,
            Observer { t: T ->
                if (mPending.compareAndSet(true, false)) {
                    observer.onChanged(t)
                }
            }
        )
    }
}