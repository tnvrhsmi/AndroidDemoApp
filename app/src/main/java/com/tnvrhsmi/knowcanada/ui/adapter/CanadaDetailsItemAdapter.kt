package com.tnvrhsmi.knowcanada.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tnvrhsmi.knowcanada.R
import com.tnvrhsmi.knowcanada.data.model.FactListModel
import kotlinx.android.synthetic.main.canada_list_item.view.*

class CanadaDetailsItemAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = CanadaDetailsItemViewHolder(parent)



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as CanadaDetailsItemViewHolder
        holder.bind(item as FactListModel)
    }

    class CanadaDetailsItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.canada_list_item,parent,false)) {
        private val title = itemView.title_text
        private val description = itemView.description_text

        fun bind(item : FactListModel) {
            title.text = item.title
            description.text = item.description

        }

    }
}