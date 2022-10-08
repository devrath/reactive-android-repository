package com.droid.code.operators.combiningOperators.operators.concatMap

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable

class OperatorConcatMap {

    private val ourObservable = Observable.just(1,3,5)

    private val subscriptions = CompositeDisposable()

    fun subscribeForSuccess() {

        ourObservable.concatMap {
            when(it){
                1 -> Observable.just(2)
                3 -> Observable.just(4)
                5 -> Observable.just(6)
                else -> Observable.just(0)
            }
        }.subscribe(
            {
                Log.d(PROJECT_TAG,it.toString())
            },{
                Log.d(PROJECT_TAG,it.message.toString())
            }
        )
    }

    fun disposeAll(){ subscriptions.dispose() }

}