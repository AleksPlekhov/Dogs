package com.mvvm.dogs.utils.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.clearWith(disposable: CompositeDisposable?): Disposable {
    return this.apply {
        disposable?.add(this)
    }
}
