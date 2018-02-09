package com.shanerudolf.cbmcodechalllenge.utils

import android.databinding.BindingAdapter
import com.shanerudolf.cbmcodechalllenge.views.customViews.SquareImageView
import com.squareup.picasso.Picasso

/**
 * Created by shane1 on 2/9/18.
 */
class BindingAdapters {
    companion object {
        @JvmStatic @BindingAdapter("imageUrl")
        fun loadImage(view: SquareImageView, imageUrl: String) {
            Picasso.with(view.context).load(imageUrl).into(view)
        }
    }

}