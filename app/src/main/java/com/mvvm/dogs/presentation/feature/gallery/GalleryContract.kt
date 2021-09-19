package com.mvvm.dogs.presentation.feature.gallery

import com.mvvm.dogs.presentation.base.IViewVmContract
import com.mvvm.dogs.presentation.base.view_handler.IViewControl

interface GalleryContract : IViewControl {

    /** Actions in direction  VM ---> View */
    interface ViewModel : IViewVmContract.IViewModelContract {

    }

    /** Actions in direction  VM <--- View */
    interface ViewController : IViewVmContract.IViewContract {

    }

}