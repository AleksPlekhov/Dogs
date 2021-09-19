package com.mvvm.dogs.presentation.binding

import androidx.databinding.BindingAdapter
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class RecycleViewBinding {


    @BindingAdapter("adapter")
    fun RecyclerView.setupPagedListView(
        pagedListAdapter: PagedListAdapter<Any, RecyclerView.ViewHolder>
    ) {
        adapter = pagedListAdapter
    }

    @BindingAdapter("defaultSetup")
    fun RecyclerView.defaultSetup(
        flag: Boolean
    ) {
        setHasFixedSize(flag)
        layoutManager = LinearLayoutManager(context).apply {
            orientation = RecyclerView.VERTICAL

        }

    }


    @BindingAdapter("setupSwipeToRefresh")
    fun SwipeRefreshLayout.setupSwipeToRefresh(flag: Boolean) {
        setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
    }


}