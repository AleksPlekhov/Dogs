package com.mvvm.dogs.presentation.dagger.component

import com.mvvm.dogs.AppMain
import com.mvvm.dogs.presentation.dagger.module.AppModule
import com.mvvm.dogs.presentation.dagger.module.GalleryModule
import com.mvvm.dogs.presentation.dagger.module.NetworkModule
import com.mvvm.dogs.presentation.dagger.module.SchedulerDispatchersModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SchedulerDispatchersModule::class,
        NetworkModule::class

    ]
)


interface AppComponent {
    fun inject(obj: AppMain)


    fun addGalleryComponent(galleryModule: GalleryModule): GalleryComponent

}