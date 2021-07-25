package io.github.maa96.basearch.ui.base.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mohsen.architecture.R

class BindingAdapters {

    companion object {
        @BindingAdapter("app:changeVisibility")
        @JvmStatic
        fun changeVisibility(view: View, value: Boolean) {
            view.visibility = if (value) View.VISIBLE else View.GONE
        }

        @BindingAdapter("app:imageResource")
        @JvmStatic
        fun setImageResource(imageView: ImageView, imageUrl: String?) {
            val context = imageView.context
            val options: RequestOptions =
                RequestOptions().placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageUrl)
                .into(imageView)
        }
    }
}