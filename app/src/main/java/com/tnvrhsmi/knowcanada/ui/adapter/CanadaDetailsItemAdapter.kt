package com.tnvrhsmi.knowcanada.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tnvrhsmi.knowcanada.R
import kotlinx.android.synthetic.main.canada_list_item.view.*

class CanadaDetailsItemAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = CanadaDetailsItemViewHolder(parent)



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as CanadaDetailsItemViewHolder
        holder.bind()
    }

    class CanadaDetailsItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.canada_list_item,parent,false)) {
        private val title = itemView.title_text
        private val description = itemView.description_text

        fun bind() {
            title.text = "Beavers"
            description.text =
                "Beavers are second only to humans in their ability to manipulate and" +
                        " change their environment. They can measure up to 1.3 metres long. " +
                        "A group of beavers is called a colony"
        }

    }
}