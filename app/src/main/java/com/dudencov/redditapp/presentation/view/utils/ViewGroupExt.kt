package com.dudencov.redditapp.presentation.view.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflater(): LayoutInflater = LayoutInflater.from(this.context)

fun ViewGroup.inflate(layoutRes: Int): View? = inflater().inflate(layoutRes, this, false)