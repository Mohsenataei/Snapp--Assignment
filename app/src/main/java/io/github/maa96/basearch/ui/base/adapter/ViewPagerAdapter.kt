package io.github.maa96.basearch.ui.base.adapter

import androidx.databinding.ViewDataBinding

open class ViewPagerAdapter<T : Any, B : ViewDataBinding>(
    private val layoutId: Int,
    items: List<T> = emptyList(),
    onItemClicked: ((T) -> Unit)? = null,
    onBind: B.(Int) -> Unit = {}
) : BaseAdapter<T, B>(items = items, onItemClicked = onItemClicked, onBind = onBind) {

    override fun getLayoutId(position: Int): Int = layoutId
}
