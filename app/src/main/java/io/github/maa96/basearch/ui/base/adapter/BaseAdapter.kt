package io.github.maa96.basearch.ui.base.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mohsen.architecture.BR

/**
 * This is an abstract adapter that inherited - extend - [RecyclerView.Adapter]
 * and can be used as a base adapter for layouts provided by DataBinding framework
 * @param itemBindingId Generated item binding id that will should be founded in BR class and will be
 * used in [BaseViewHolder.bind] method.
 * @param items list of items to be shown. Can be changed later by calling [swapItems].
 * @param onItemClicked click listener to be invoked when user clicks on an item
 * @param onBind an extension function on [B] that receives position of current item and allow us to access
 * binding class outside of [BaseAdapter].
 * */

// TODO ("")
abstract class BaseAdapter<T : Any, B : ViewDataBinding>(
    private val itemBindingId: Int,
    items: List<T> = emptyList(),
    private val onItemClicked: ((T) -> Unit)? = null,
    private val onBind: B.(Int) -> Unit = {}
) : RecyclerView.Adapter<BaseViewHolder<T, B>>() {

    private val items = mutableListOf<T>().apply {
        addAll(items)
    }

    /*
    * returns item in given index
    * */
    fun getItem(index: Int): T = items[index]

    override fun getItemCount(): Int = items.size

    /**
     * abstract function to decide which layout should be shown at given position.
     * This will be useful for multi layout adapters. for single layout adapter it can only returns
     * a static layout resource id.
     *
     * @return relevant layout resource id based on given position
     *
     */
    abstract fun getLayoutId(position: Int) : Int



}