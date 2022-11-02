package com.azamovhudstc.gamerrecyclerviewalphabet

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class CustomAdapter(var modelList: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(), ItemMoveCallback.ItemTouchHelperContract {

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bind(modelList[position]);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return modelList.size;
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: TextView = itemView.findViewById(R.id.img)
        fun bind(model: String) {

            img.text=model
            Log.d("!@#", "bind: $model")

        }
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(modelList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(modelList, i, i - 1)
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(list: ArrayList<String>) {
        modelList.clear()
        modelList.addAll(list)
        notifyDataSetChanged()
    }
}