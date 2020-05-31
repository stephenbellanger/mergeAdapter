package com.sbellanger.mergedadapter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.sbellanger.mergedadapter.R
import com.sbellanger.mergedadapter.ui.adapter.FooterAdapter
import com.sbellanger.mergedadapter.ui.adapter.HeaderAdapter
import com.sbellanger.mergedadapter.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment :
    Fragment(),
    IMainContract.ViewCapabilites {

    companion object {
        fun newInstance() = MainFragment()
    }

    ///////////////////////////////////////////////////////////////////////////
    // DATA
    ///////////////////////////////////////////////////////////////////////////

    private lateinit var viewModel: MainViewModel

    private val headerAdapter by lazy { HeaderAdapter() }
    private val mainDataAdapter by lazy { MainAdapter() }
    private val footerAdapter by lazy { FooterAdapter() }

    ///////////////////////////////////////////////////////////////////////////
    // LIFECYCLE
    ///////////////////////////////////////////////////////////////////////////

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initRecyclerView()

        viewModel.observeIsLoading().observe(viewLifecycleOwner, Observer { isLoading ->
            showLoader(isLoading)
        })

        viewModel.observeHeader().observe(viewLifecycleOwner, Observer { header ->
            headerAdapter.setData(header)
        })

        viewModel.observeMainData().observe(viewLifecycleOwner, Observer { data ->
            mainDataAdapter.setData(data)
        })

        viewModel.observeFooter().observe(viewLifecycleOwner, Observer { footer ->
            footerAdapter.setData(footer)
        })
    }

    ///////////////////////////////////////////////////////////////////////////
    // CONTRACT IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    override fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MergeAdapter(
                headerAdapter,
                mainDataAdapter,
                footerAdapter
            )
        }
    }

    override fun showLoader(shouldShow: Boolean) {
        val visibility = if (shouldShow) View.VISIBLE else View.GONE
        loader_view.visibility = visibility
    }
}
