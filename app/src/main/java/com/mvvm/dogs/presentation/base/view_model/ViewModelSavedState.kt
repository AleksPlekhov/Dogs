package com.mvvm.dogs.presentation.base.view_model

import android.os.Bundle
import com.mvvm.dogs.presentation.base.IStateHolder
import com.mvvm.dogs.utils.BundleKey

abstract class ViewModelSavedState<H : IStateHolder>(lateInitDataHolder: () -> H) : BaseViewModel() {

    /** You should save data manually ASAP to holder, at least inside onStop() */
    private var provideDataHolder: H = lateInitDataHolder()

    /** We consume restored light data */
    abstract fun onRestoreState(dataHolder: H)


    /** We receive holder and fill it with light data */
    abstract fun onSaveState(dataHolder: H): H


    override fun onRestoreInstanceState(bn: Bundle) {
        super.onRestoreInstanceState(bn)
        (bn.getSerializable(BundleKey.STATE_HOLDER.name) as? H)?.run {
            provideDataHolder = this
            onRestoreState(this)
        }
    }


    override fun onSaveInstanceState(bn: Bundle) {
        super.onSaveInstanceState(bn)
        val savedData = onSaveState(provideDataHolder)
        bn.putSerializable(BundleKey.STATE_HOLDER.name, savedData)
    }


}