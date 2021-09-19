package com.mvvm.dogs

import android.app.Application
import android.content.Context
import com.mvvm.dogs.presentation.dagger.graph.AppGraph
import com.plav.test_library.TestClass


class AppMain : Application() {
    companion object {
        var logPermission = BuildConfig.DEBUG
        lateinit var context: Context
    }


    override fun onCreate() {
        super.onCreate()
        AppGraph.initialize(this)
        context = this@AppMain

        TestClass()
    }


}