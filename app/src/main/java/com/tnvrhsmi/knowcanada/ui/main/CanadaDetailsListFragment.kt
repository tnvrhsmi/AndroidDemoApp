@file:Suppress("DEPRECATION")

package com.tnvrhsmi.knowcanada.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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
        setupViewModel()

    }


    //Viewmodel for this fragment setup
    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(CanadaDetailsListViewModel::class.java)
        swipeView.isRefreshing = true
        viewModel.dataFetchState.observe(this, Observer {
            swipeView.isRefreshing = false
            val state = it
            when (state) {
                is DataFetchState.Success -> {
                    canadaDetailsListAdapter.addItems(state.factList)
                    var activitySupport : AppCompatActivity =  activity as AppCompatActivity
                    activitySupport.supportActionBar?.title = state.title
                }
                is DataFetchState.Error -> {
                    handleError(state)
//                    Toast.makeText(context,state.message,Toast.LENGTH_LONG).show()

                }
            }

        })
    }

    // Showing alert if API fetch is not successful
    private fun handleError(state: DataFetchState.Error) {
        val errorAlert = activity?.let { it1 -> AlertDialog.Builder(it1) }
        if (errorAlert != null) {
            errorAlert.setMessage(state.message)
            errorAlert.setTitle(R.string.alert_title)
            errorAlert.setPositiveButton(R.string.retry) { dialogInterface, which ->
                swipeView.isRefreshing = true
                viewModel.fetchData()
            }

            errorAlert.show()

        }
    }

    //pull to refresh setup
    private fun setupRecyclerView() {
        canadaDetailsListAdapter = CanadaDetailsListAdapter()

        canada_details_list.apply {
            setHasFixedSize(false)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()

        }
        canada_details_list.adapter = canadaDetailsListAdapter

        swipeView.setOnRefreshListener{
           viewModel.fetchData()
        }

    }

}
