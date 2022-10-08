package com.droid.code.operators.combiningOperators.operators.merge

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject

class OperatorMerge {

    val source1: PublishSubject<String> = PublishSubject.create<String>()
    val source2: PublishSubject<String> = PublishSubject.create<String>()

    private val subscriptions = CompositeDisposable()

    init { subscribeForSuccess() }

    fun subscribeForSuccess() {
        Observable.merge(source1,source2)
            .subscribe(
                { Log.d(PROJECT_TAG,it) },
                { Log.d(PROJECT_TAG,it.message.toString()) }
            )
    }



    fun disposeAll(){ subscriptions.dispose() }

}