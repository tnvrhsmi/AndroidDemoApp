package com.tnvrhsmi.knowcanada.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tnvrhsmi.knowcanada.R
import com.tnvrhsmi.knowcanada.ui.adapter.CanadaDetailsListAdapter
import kotlinx.android.synthetic.main.canada_details_list_fragment.*

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

    }

    private fun setupRecyclerView() {
        canadaDetailsListAdapter = CanadaDetailsListAdapter()

        canada_details_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()

        }
        canada_details_list.adapter = canadaDetailsListAdapter
    }

}
