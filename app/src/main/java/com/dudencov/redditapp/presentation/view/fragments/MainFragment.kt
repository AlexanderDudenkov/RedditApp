package com.dudencov.redditapp.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dudencov.redditapp.R
import com.dudencov.redditapp.databinding.FragmentMainBinding
import com.dudencov.redditapp.presentation.App
import com.dudencov.redditapp.presentation.view.utils.BaseFragment
import com.dudencov.redditapp.presentation.view.utils.setVisibilityExt
import com.dudencov.redditapp.presentation.view_models.MainVMImpl

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainVM: MainVMImpl by viewModels {
        App.getAppComponent().mainViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = mainVM
        initLiveData()
    }

    private fun initLiveData() {
        mainVM.mainProgressBarVisibility.observe(
            viewLifecycleOwner,
            Observer { binding.pbMain.setVisibilityExt(it) }
        )
    }
}