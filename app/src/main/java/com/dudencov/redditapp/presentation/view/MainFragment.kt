package com.dudencov.redditapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dudencov.redditapp.R
import com.dudencov.redditapp.di.components.DaggerMainFragmentComponent
import com.dudencov.redditapp.di.components.MainFragmentComponent
import com.dudencov.redditapp.di.components.injector
import com.dudencov.redditapp.di.modules.MainFragmentModule
import com.dudencov.redditapp.presentation.notView.MainViewModel
import com.dudencov.redditapp.presentation.notView.MainViewModelImpl
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(activity!!, activity!!.injector.mainViewModelFactory())
            .get(MainViewModelImpl::class.java)
    }

    var component: MainFragmentComponent? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDi()

        mainViewModel.topListLiveData.observe(this, Observer { tv.text = it.toString() })
    }

    override fun onDestroy() {
        component = null
        super.onDestroy()
    }

    private fun initDi() {
        component = DaggerMainFragmentComponent.builder()
            .appComponent((activity as MainActivity).injector)
            .mainFragmentModule(MainFragmentModule(activity as MainActivity))
            .build()
            .apply { inject(this@MainFragment) }
    }
}