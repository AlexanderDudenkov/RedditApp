package com.dudencov.redditapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dudencov.redditapp.R
import com.dudencov.redditapp.domain.TopListInteractor
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapperImpl
import com.dudencov.redditapp.presentation.App
import com.dudencov.redditapp.presentation.notView.MainViewModel
import com.dudencov.redditapp.presentation.notView.MainViewModelImpl
import com.dudencov.redditapp.repository.RepositoryImpl
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = MainViewModelImpl(
            App.instance,
            TopListInteractor(RepositoryImpl(), DataAndModelTopListMapperImpl())
        )

        mainViewModel.topListLiveData.observe(this, Observer { tv.text = it.toString() })
    }

}