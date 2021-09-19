package com.mvvm.dogs.presentation.feature.gallery.list_adapter

import androidx.paging.PositionalDataSource
import com.mvvm.dogs.data.data_source.GalleryDataSource
import com.mvvm.dogs.utils.PagingAdapter
import com.mvvm.dogs.utils.extensions.clearWith
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GalleryPagingDataManager(
    private val galleryDataSource: GalleryDataSource,
    private val disposables: CompositeDisposable
) : PositionalDataSource<Dog>() {


    /**
     * While changing screen orientation Paging lib  below  methods are called again  with request to server. So it is better to  handle  this case and  use cached data while rotation.
     * */

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Dog>) {
        fetchData { callback.onResult(it) }
    }


    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Dog>) {
        fetchData { callback.onResult(it, 0) }
    }


    private fun fetchData(function: (list: List<Dog>) -> Unit) {
        galleryDataSource.dogsUrl(PagingAdapter.PageSize.value)
            .map {
                it.body()?.urls?.map { Dog(it) } ?: listOf()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    function(it)
                },
                Throwable::printStackTrace
            ).clearWith(disposables)

    }

}