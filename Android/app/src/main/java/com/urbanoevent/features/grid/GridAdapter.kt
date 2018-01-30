package com.urbanoevent.features.grid


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.urbanoevent.R
import com.urbanoevent.application.BaseFragment
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import kotlinx.android.synthetic.main.grid_item_view.view.*

/**
 * Created by cinq on 30/01/18.
 */

class GridAdapter(val items: List<UrbanoEvent>, val listener: (UrbanoEvent) -> Unit) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int) {
        GridViewHolder(parent.inflate(R.layout.grid_item_view))

        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.grid_item_view, parent, false)
        return ViewHolder(view, itemClick)

    }

    override fun getItemCount() : Int = items.size;

    override fun onBindViewHolder(holder: GridViewHolder?, position: Int) = holder.bind(items[position], listener)

    class GridViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item: UrbanoEvent, listener: (UrbanoEvent) -> Unit) =
                with(itemView) {
                    tvTitle.text = item.title
                    tvDesc.text  = item.desc
//                    itemImage.loadUrl(item.url)
                    setOnClickListener { listener(item) }
                }
    }
}