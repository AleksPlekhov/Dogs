package com.mvvm.dogs.presentation.feature.gallery.list_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_dog.view.*

class DogViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Dog?) {
        if (item != null) {
            Glide.with(view.context)
                .load(item.thumbUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.image_view)
        }
    }

}