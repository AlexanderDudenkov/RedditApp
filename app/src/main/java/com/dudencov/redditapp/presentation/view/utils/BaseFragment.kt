package com.dudencov.redditapp.presentation.view.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

abstract class BaseFragment<out T : ViewDataBinding>(@LayoutRes val contentLayoutId: Int) : DaggerFragment() {

    private var _binding: WeakReference<T?> = WeakReference(null)

    val binding: T
        get() = _binding.get()!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<T>(
            LayoutInflater.from(activity),
            contentLayoutId,
            null,
            true
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            _binding = WeakReference(this)
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding.clear()
    }
}