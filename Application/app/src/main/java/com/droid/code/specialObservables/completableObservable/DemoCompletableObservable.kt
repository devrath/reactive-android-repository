package com.droid.code.specialObservables.completableObservable

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.disposables.CompositeDisposable

class DemoCompletableObservable {

    private val subscriptions = CompositeDisposable()

    private val completeScenario = Completable.create { emitter ->

        var sum = 0
        // Perform long running task
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }

        emitter.onComplete()
    }

    private val failureScenario = Completable.create { emitter ->

        var sum = 0
        emitter.onError(RuntimeException("Some custom exception"))
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }
    }

    fun getCompletableObservable(): Completable? {
        return completeScenario
    }

    fun getFailureObservable(): Completable? {
        return failureScenario
    }


    fun addSubscription(): CompositeDisposable {
        return subscriptions
    }

    fun disposeAll(){ subscriptions.dispose() }

}