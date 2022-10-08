package com.droid.code.operators.combiningOperators.operators.concat

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable

class OperatorConcat {

    private val listOne = Observable.just("item-1","item-2","item-3")
    private val listTwo = Observable.just("item-4","item-5","item-6")

    private val subscriptions = CompositeDisposable()

    fun subscribeForSuccess() {
        Observable.concat(listOne,listTwo).subscribe(
            {
                Log.d(PROJECT_TAG,it)
            },{
                Log.d(PROJECT_TAG,it.message.toString())
            }
        )
    }

    fun disposeAll(){ subscriptions.dispose() }

}