package com.mvvm.dogs.presentation.dagger.module

import android.content.Context
import com.mvvm.dogs.data.data_source.remote.NetworkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    internal fun provideContext(context: Context) = NetworkManager(context)


}