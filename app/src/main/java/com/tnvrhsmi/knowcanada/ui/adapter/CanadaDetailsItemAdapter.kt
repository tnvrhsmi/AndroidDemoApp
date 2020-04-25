package com.tnvrhsmi.knowcanada.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        private val image = itemView.item_image


        fun bind(item : FactListModel) {
            title.text = item.title
            description.visibility = View.VISIBLE
            if(item.description.isNullOrBlank()) description.visibility = View.GONE
            else description.text = item.description

            image.visibility = View.VISIBLE
            if(item.imageHref.isNullOrBlank()) image.visibility = View.GONE
            else Picasso.get().load(Uri.parse(item.imageHref)).
                placeholder(android.R.drawable.stat_sys_download).
                error(android.R.drawable.stat_notify_error).
                into(image)



        }

    }
}