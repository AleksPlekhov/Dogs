package com.mvvm.dogs.presentation.dagger.graph

import com.mvvm.dogs.AppMain
import com.mvvm.dogs.presentation.dagger.component.AppComponent
import com.mvvm.dogs.presentation.dagger.component.DaggerAppComponent
import com.mvvm.dogs.presentation.dagger.component.GalleryComponent
import com.mvvm.dogs.presentation.dagger.module.AppModule
import com.mvvm.dogs.presentation.dagger.module.GalleryModule
import io.reactivex.disposables.CompositeDisposable


object AppGraph : IAppGraph {

    private lateinit var appComponent: AppComponent
    private var galleryComponent: GalleryComponent? = null


    override fun appComponent(): AppComponent = appComponent

    override fun initialize(application: AppMain) {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build().apply {
                inject(application)
            }
    }


    override fun addGalleryComponent(disposables: CompositeDisposable): GalleryComponent {

        if (galleryComponent == null)
            galleryComponent = appComponent().addGalleryComponent(GalleryModule(disposables))
        return galleryComponent!!
    }

    override fun removeGalleryComponent() {
        galleryComponent = null
    }


}