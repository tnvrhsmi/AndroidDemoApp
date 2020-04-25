package com.tnvrhsmi.knowcanada.ui.adapter
import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tnvrhsmi.knowcanada.data.model.FactListModel

class CanadaDetailsListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : ArrayList<ViewType> = ArrayList()
    private var delegateAdapter = SparseArray<ViewTypeDelegateAdapter>()

    init {

        delegateAdapter.put(AdapterConstants.CanadaDetailsItem,CanadaDetailsItemAdapter())

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapter.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int) = items[position].getType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapter.get(getItemViewType(position))?.onBindViewHolder(holder,items[position])
    }

    fun addItems(factList: List<FactListModel>) {
        items.clear()
        items.addAll(factList.filter{ !it.title.isNullOrBlank() })
        notifyDataSetChanged()
    }
}