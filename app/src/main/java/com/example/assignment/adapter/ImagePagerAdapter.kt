package com.example.assignment.adapter

import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.R

class ImagePagerAdapter(private val context: Context) :
    RecyclerView.Adapter<ImagePagerAdapter.ItemViewHolder>() {
    lateinit var items: List<Int>
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(layoutInflater.inflate(R.layout.image_view, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(items[position])

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(@DrawableRes imageId: Int) {
            view.findViewById<ImageView>(R.id.imageView).apply {
                setImageResource(imageId)
            }
        }
    }

}
