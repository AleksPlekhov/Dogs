package com.mvvm.dogs.presentation.feature.gallery

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedListAdapter
import com.mvvm.dogs.domain.interactor.GalleryInteractor
import com.mvvm.dogs.presentation.base.view_model.BaseViewModel
import com.mvvm.dogs.presentation.dagger.graph.AppGraph
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.Dog
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.DogViewHolder
import javax.inject.Inject


class GalleryVM : BaseViewModel(), GalleryContract.ViewModel {


    @Inject
    lateinit var galleryInteractor: GalleryInteractor

    var adapter = MutableLiveData<PagedListAdapter<Dog, DogViewHolder>>()
    val refreshing = ObservableBoolean()


    override fun onDestroy() {
        super.onDestroy()
        AppGraph.removeGalleryComponent()
    }

    override fun onCreate() {
        super.onCreate()
        AppGraph.addGalleryComponent(disposables).inject(this)
        populateData()
    }

    private fun populateData() {
        adapter.postValue(galleryInteractor.prepareAdapter())
    }

    /** Implementation is simplified in demo case. Need use callback of success fetching data */
    fun onRefresh() {
        refreshing.set(true)
        populateData()
        refreshing.set(false)
    }


}