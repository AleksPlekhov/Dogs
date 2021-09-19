package com.mvvm.dogs.presentation.dagger.component

import com.mvvm.dogs.presentation.dagger.module.GalleryModule
import com.mvvm.dogs.presentation.dagger.scope.GalleryScope
import com.mvvm.dogs.presentation.feature.gallery.GalleryVM
import dagger.Subcomponent


@GalleryScope
@Subcomponent(
    modules = [
        GalleryModule::class
    ]
)


interface GalleryComponent {
    fun inject(obj: GalleryVM)

}