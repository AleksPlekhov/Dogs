package com.mvvm.dogs.presentation.dagger.module


import com.mvvm.dogs.data.model.AppRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class SchedulerDispatchersModule {

    @Provides
    @Singleton
    fun provideRxSchedulers() = AppRxSchedulers(
        database = Schedulers.single(),
        disk = Schedulers.io(),
        network = Schedulers.io(),
        main = AndroidSchedulers.mainThread()
    )


}