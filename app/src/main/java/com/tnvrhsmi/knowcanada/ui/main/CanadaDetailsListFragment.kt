@file:Suppress("DEPRECATION")

package com.tnvrhsmi.knowcanada.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tnvrhsmi.knowcanada.R
import com.tnvrhsmi.knowcanada.ui.adapter.CanadaDetailsListAdapter
import kotlinx.android.synthetic.main.canada_details_list_fragment.*

@Suppress("DEPRECATION")
class CanadaDetailsListFragment : Fragment() {

    companion object {
        fun newInstance() = CanadaDetailsListFragment()
    }

    private lateinit var viewModel: CanadaDetailsListViewModel
    private lateinit var canadaDetailsListAdapter: CanadaDetailsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.canada_details_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProviders.of(this).get(CanadaDetailsListViewModel::class.java)

        viewModel.dataFetchState.observe(this, Observer {
            val state = it
            when (state) {
                is DataFetchState.Success -> {
                    canadaDetailsListAdapter.addItems(state.factList)
                }
                is DataFetchState.Error -> {
//                    Snackbar.make(news_list, state.message.orEmpty(), Snackbar.LENGTH_INDEFINITE)
//                        .setAction("RETRY") { requestNews() }
//                        .show()
                }
            }

        })

    }

    private fun setupRecyclerView() {
        canadaDetailsListAdapter = CanadaDetailsListAdapter()

        canada_details_list.apply {
            setHasFixedSize(false)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()

        }
        canada_details_list.adapter = canadaDetailsListAdapter
    }

}
