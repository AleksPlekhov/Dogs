package com.mvvm.dogs.presentation.base.view_handler

import androidx.appcompat.app.AppCompatActivity


interface IViewHandler {
    fun handleControl(viewControl: IViewControl?)
}


open class BaseViewHandler(private val actContext: AppCompatActivity?) : IViewHandler {
    protected val Lo = com.mvvm.dogs.utils.Lo(this)

    override fun handleControl(viewControl: IViewControl?) {
        viewControl?.action(actContext)
    }
}
