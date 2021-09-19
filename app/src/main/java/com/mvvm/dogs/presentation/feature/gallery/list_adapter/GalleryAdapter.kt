package com.mvvm.dogs.presentation.feature.gallery.list_adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.mvvm.dogs.R


open class GalleryAdapter(diffUtilCallback: DogDiffUtil) : PagedListAdapter<Dog, DogViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(getItem(position));
    }
}