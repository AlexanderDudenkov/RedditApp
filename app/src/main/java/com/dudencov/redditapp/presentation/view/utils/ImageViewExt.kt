package com.dudencov.redditapp.presentation.view.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:src")
fun ImageView.loadImage(url: String?) {
    if (url.isNullOrEmpty()) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        Picasso.get()
            .load(url)
            .noPlaceholder()
            .into(this)
    }
}