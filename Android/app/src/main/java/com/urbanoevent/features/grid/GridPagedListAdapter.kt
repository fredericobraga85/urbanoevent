package com.urbanoevent.features.grid

import android.arch.paging.PagedListAdapter
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.urbanoevent.R
import com.urbanoevent.R.id.*
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import kotlinx.android.synthetic.main.grid_item_view.view.*

/**
 * Created by fred_braga on 30/01/18.
 */

class GridPagedListAdapter(var items: List<UrbanoEvent>?, val listener: (UrbanoEvent, ImageView) -> Unit) : PagedListAdapter<UrbanoEvent, GridPagedListAdapter.GridViewHolder>(diffCallback) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridPagedListAdapter.GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view, parent, false)
        return GridViewHolder(view)
    }


//    override fun getItemCount() : Int {
//        if(items != null)
//        {
//            return items!!.size
//        }
//
//        return 0
//    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

        return holder.bind(getItem(position), listener)
    }

//    fun updateList(urbanoEventList: List<UrbanoEvent>?)
//    {
//        this.items = urbanoEventList
//        this.notifyDataSetChanged()
//    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<UrbanoEvent>() {
            override fun areItemsTheSame(oldItem: UrbanoEvent, newItem: UrbanoEvent): Boolean =
                    oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: UrbanoEvent, newItem: UrbanoEvent): Boolean =
                    oldItem == newItem
        }
    }

    class GridViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {

        var urbanoEvent : UrbanoEvent? = null

        fun bind(item: UrbanoEvent?, listener: (UrbanoEvent, ImageView) -> Unit) =

                with(itemView) {

                    urbanoEvent = item

                    tvTitle.text = item?.title
                    tvDesc.text  = item?.desc


                    Glide.with(context)
                            .load(item?.imageUrl)
                            .apply(RequestOptions().centerCrop())
                            .into(imgView);

                    setOnClickListener {

                        if(item != null) {
                            listener(item, imgView)
                        }
                    }
                }
    }

}