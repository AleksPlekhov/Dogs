package com.mvvm.dogs.presentation.feature.gallery.list_adapter

import androidx.recyclerview.widget.DiffUtil

class DogDiffUtil : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog) =
        oldItem.thumbUrl == newItem.thumbUrl


    override fun areContentsTheSame(oldItem: Dog, newItem: Dog) =
        oldItem.thumbUrl == newItem.thumbUrl


}