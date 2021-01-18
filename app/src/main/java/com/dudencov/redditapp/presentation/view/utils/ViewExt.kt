package com.dudencov.redditapp.presentation.view.utils

import android.view.View

fun View.setVisibilityExt(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}
