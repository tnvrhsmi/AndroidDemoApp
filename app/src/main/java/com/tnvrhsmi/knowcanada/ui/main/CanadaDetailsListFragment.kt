package com.tnvrhsmi.knowcanada.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tnvrhsmi.knowcanada.R

class CanadaDetailsListFragment : Fragment() {

    companion object {
        fun newInstance() = CanadaDetailsListFragment()
    }

    private lateinit var viewModel: CanadaDetailsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.canada_details_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CanadaDetailsListViewModel::class.java)
    }

}
