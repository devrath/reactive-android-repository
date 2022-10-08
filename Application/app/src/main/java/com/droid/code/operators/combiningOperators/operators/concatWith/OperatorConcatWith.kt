package com.droid.code.operators.combiningOperators.operators.concatWith

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable

class OperatorConcatWith {

    private val listOne = Observable.just("item-1","item-2","item-3")
    private val listTwo = Observable.just("item-4","item-5","item-6")

    private val subscriptions = CompositeDisposable()

    fun subscribeForSuccess() {

        listOne.concatWith(listTwo).subscribe(
            {
                Log.d(PROJECT_TAG,it)
            },{
                Log.d(PROJECT_TAG,it.message.toString())
            }
        )
    }

    fun disposeAll(){ subscriptions.dispose() }

}