package com.droid.code.operators.combiningOperators.operators.startsWith

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject

class OperatorStartsWith {
    
    private val initialCollection = Observable.just("item-1","item-2","item-3")
    private val finalCollection = initialCollection.startWithIterable(listOf("default-1","default-2"))

    private val subscriptions = CompositeDisposable()

    fun subscribeForSuccess() {
        finalCollection.subscribe(
            {
                Log.d(PROJECT_TAG,it)
            },{
                Log.d(PROJECT_TAG,it.message.toString())
            }
        )
    }

    fun disposeAll(){ subscriptions.dispose() }

}