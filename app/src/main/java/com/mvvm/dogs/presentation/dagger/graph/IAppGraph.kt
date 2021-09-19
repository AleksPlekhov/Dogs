package com.mvvm.dogs.presentation.dagger.graph

import com.mvvm.dogs.AppMain
import com.mvvm.dogs.presentation.dagger.component.AppComponent
import com.mvvm.dogs.presentation.dagger.component.GalleryComponent
import io.reactivex.disposables.CompositeDisposable


interface IAppGraph {
    fun initialize(application: AppMain)
    fun appComponent(): AppComponent


    fun addGalleryComponent(disposables: CompositeDisposable): GalleryComponent
    fun removeGalleryComponent()

}