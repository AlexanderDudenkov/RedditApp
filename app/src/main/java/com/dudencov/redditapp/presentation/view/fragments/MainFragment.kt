package com.dudencov.redditapp.presentation.view.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent.Builder
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dudencov.redditapp.R
import com.dudencov.redditapp.di.components.DaggerMainFragmentComponent
import com.dudencov.redditapp.di.components.MainFragmentComponent
import com.dudencov.redditapp.di.components.injector
import com.dudencov.redditapp.di.modules.MainFragmentModule
import com.dudencov.redditapp.presentation.notView.MainViewModel
import com.dudencov.redditapp.presentation.notView.MainViewModelImpl
import com.dudencov.redditapp.presentation.view.activies.MainActivity
import com.dudencov.redditapp.presentation.view.adapters.MainAdapter
import com.dudencov.redditapp.util.ItemDiffCallback
import com.dudencov.redditapp.util.setVisibilityExt
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : BaseFragment() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(requireActivity(), requireActivity().injector.mainViewModelFactory())
            .get(MainViewModelImpl::class.java)
    }

    var component: MainFragmentComponent? = null

    private lateinit var adapter: MainAdapter

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
        initRecyclerView()
        initLiveData()
    }

    private fun initDi() {
        component = DaggerMainFragmentComponent.builder()
            .appComponent((activity as MainActivity).injector)
            .mainFragmentModule(MainFragmentModule(activity as MainActivity))
            .build()
            .apply { inject(this@MainFragment) }
    }

    private fun initRecyclerView() {
        adapter = MainAdapter(ItemDiffCallback()) { itemPos ->
            openDetailScreen(
                mainViewModel.topListUiLiveData?.value?.get(itemPos)?.detailUrl
            )
        }

        rv_main?.adapter = this.adapter
    }

    private fun initLiveData() {
        mainViewModel.topListUiLiveData?.observe(
            viewLifecycleOwner,
            Observer { adapter.submitList(it) })

        mainViewModel.mainProgressBarVisibility.observe(
            viewLifecycleOwner,
            Observer { pb_main.setVisibilityExt(it) })
    }

    override fun onDestroy() {
        component = null
        super.onDestroy()
    }

    private fun openBrowser(url: String) {
        Builder().build().launchUrl(requireContext(), Uri.parse(url))
    }

    private fun openDetailScreen(url: String?) {
        if (url.isNullOrEmpty()) {
            Toast.makeText(context, "Not possible to open page!", Toast.LENGTH_SHORT).show()
        } else {
            openBrowser(url)
        }
    }
}