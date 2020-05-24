package com.dudencov.redditapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ViewGroup.inflater(): LayoutInflater? = LayoutInflater.from(this.context)

fun ViewGroup.inflate(layoutRes: Int): View? = inflater()?.inflate(layoutRes, this, false)

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

fun View.setVisibilityExt(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
