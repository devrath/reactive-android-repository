package com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.PublishSubject

class OperatorDistinctNormal {

    // Let's create the source of the observable which we can emit some integers
    private val publishSubject: PublishSubject<Int> = PublishSubject.create<Int>()
    private val subscriptions = CompositeDisposable()

    init {
        subscribeForSuccess()
    }

    fun addValuesForObservable() {
        publishSubject.apply {
            onNext(0)
            onNext(1)
            onNext(2)
            onNext(2)
            onNext(3)
            onNext(3)
            onNext(4)
            onNext(5)
        }
    }

    private fun subscribeForSuccess() {
        val dispose = publishSubject
            .distinctUntilChanged()
            .subscribe {
                Log.d(PROJECT_TAG,"Subscriber-Success-Demo".plus("<-->").plus(it.toString()))
            }.addTo(subscriptions)
        subscriptions.add(dispose)
    }


    fun disposeAll(){ subscriptions.dispose() }

}