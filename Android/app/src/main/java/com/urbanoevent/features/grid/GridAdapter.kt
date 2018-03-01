package com.urbanoevent.features.grid


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup




import com.urbanoevent.R
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import kotlinx.android.synthetic.main.grid_item_view.view.*
import com.urbanoevent.R.id.imageView
import android.R.attr.thumbnail
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


/**
 * Created by cinq on 30/01/18.
 */

class GridAdapter(var items: List<UrbanoEvent>?, val listener: (UrbanoEvent, ImageView) -> Unit) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapter.GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view, parent, false)
        return GridViewHolder(view)
    }


    override fun getItemCount() : Int {
        if(items != null)
        {
            return items!!.size
        }

        return 0
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

        return holder.bind(items?.get(position), listener)
    }

    fun updateList(urbanoEventList: List<UrbanoEvent>?)
    {
        this.items = urbanoEventList
        this.notifyDataSetChanged()
    }

    class GridViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(item: UrbanoEvent?, listener: (UrbanoEvent, ImageView) -> Unit) =
                with(itemView) {
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