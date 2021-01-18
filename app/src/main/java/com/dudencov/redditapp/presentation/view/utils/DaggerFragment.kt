package com.dudencov.redditapp.presentation.view.utils

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class DaggerFragment : Fragment() {

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    private fun inject() {
        AndroidSupportInjection.inject(this)
    }
}