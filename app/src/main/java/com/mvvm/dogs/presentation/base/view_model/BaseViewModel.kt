package com.mvvm.dogs.presentation.base.view_model

import androidx.lifecycle.ViewModel
import com.mvvm.dogs.presentation.aac.SingleLiveEvent
import com.mvvm.dogs.presentation.base.view_handler.IViewControl
import com.mvvm.dogs.presentation.feature.gallery.GalleryContract
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : GalleryContract.ViewModel(), IVM {
    val Lo = com.mvvm.dogs.utils.Lo(this)
    var disposables = CompositeDisposable()

    private var isJustCreated = true

    val viewHandler = SingleLiveEvent<IViewControl>()


    override fun callViewControl(viewControl: IViewControl) {
        viewHandler.value = viewControl
    }


    override fun handleOnCreate() {

        if (isJustCreated) {
            isJustCreated = false
            onCreate()
        } else
            onRestore()
    }

    override fun onDestroy() {
        //this.view = null
        // Lo.ge("onDestroy ${this.hashCode()}")

        disposables.clear()
    }


    override fun onCleared() {
        //   Lo.g("onCleared ${this.hashCode()}")
        onDestroy()
        super.onCleared()

    }


}