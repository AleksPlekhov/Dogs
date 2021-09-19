package com.mvvm.dogs.presentation.feature.gallery

import com.mvvm.dogs.R
import com.mvvm.dogs.databinding.ActivityGalleryBinding
import com.mvvm.dogs.presentation.base.activity.BindingAct


class GalleryActivity : BindingAct<ActivityGalleryBinding, GalleryVM>(),
    GalleryContract.ViewController {


    override val provideLayoutId = R.layout.activity_gallery
    override var provideViewModel = GalleryVM::class.java


}