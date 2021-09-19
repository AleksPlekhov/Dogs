package com.mvvm.dogs.domain.interactor

import android.os.Handler
import android.os.Looper
import androidx.paging.PagedList
import com.mvvm.dogs.domain.interactor.base.BaseInteractor
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.DogDiffUtil
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.GalleryAdapter
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.GalleryPagingDataManager
import com.mvvm.dogs.utils.PagingAdapter
import java.util.concurrent.Executor
import java.util.concurrent.Executors


internal class MainThreadExecutor : Executor {
    private val mHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }
}


class GalleryInteractor(
    private val galleryPagingDataManager: GalleryPagingDataManager
) : BaseInteractor() {


    fun prepareAdapter(): GalleryAdapter {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PagingAdapter.PageSize.value)
            .build()


        val pagedList = PagedList.Builder(galleryPagingDataManager, config)
            .setNotifyExecutor(MainThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()


        val adapter = GalleryAdapter(DogDiffUtil())

        adapter.submitList(pagedList)


        return adapter
    }


}