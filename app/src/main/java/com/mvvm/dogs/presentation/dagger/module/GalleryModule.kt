package com.mvvm.dogs.presentation.dagger.module

import com.mvvm.dogs.data.data_source.GalleryDataSource
import com.mvvm.dogs.data.data_source.remote.NetworkManager
import com.mvvm.dogs.domain.interactor.GalleryInteractor
import com.mvvm.dogs.presentation.dagger.scope.GalleryScope
import com.mvvm.dogs.presentation.feature.gallery.list_adapter.GalleryPagingDataManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module

class GalleryModule(private val disposables: CompositeDisposable) {


    @Provides
    @GalleryScope
    fun provideGalleryDataSource(networkManager: NetworkManager) =
        GalleryDataSource(networkManager)


    @Provides
    @GalleryScope
    fun provideGalleryPagingDataManager(galleryDataSource: GalleryDataSource) =
        GalleryPagingDataManager(galleryDataSource, disposables)


    @Provides
    @GalleryScope
    fun provideGalleryInteractor(
        galleryPagingDataManager: GalleryPagingDataManager
    ) =
        GalleryInteractor(galleryPagingDataManager)


}