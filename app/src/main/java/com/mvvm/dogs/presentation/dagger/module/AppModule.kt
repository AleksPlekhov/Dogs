package com.mvvm.dogs.presentation.dagger.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {


    @Provides
    @Singleton
    internal fun provideContext(): Context = context


}