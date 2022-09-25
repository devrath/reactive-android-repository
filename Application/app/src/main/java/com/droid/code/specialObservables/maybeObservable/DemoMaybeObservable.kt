package com.droid.code.specialObservables.maybeObservable

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

class DemoMaybeObservable {

    private val subscriptions = CompositeDisposable()

    private val successScenario = Maybe.create { emitter ->

        var sum = 0
        // Perform long running task
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }

        emitter.onSuccess(sum)
        //emitter.onError(RuntimeException("Some custom exception"))
    }

    private val failureScenario = Maybe.create { emitter ->

        var sum = 0
        emitter.onError(RuntimeException("Some custom exception"))
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }

        emitter.onSuccess(sum)
    }

    private val completeScenario = Maybe.create { emitter ->

        var sum = 0
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }
        // complete is called prior to success
        emitter.onComplete()

        emitter.onSuccess(sum)
    }

    fun getSuccessObservable(): Maybe<Int>? {
        return successScenario
    }

    fun getFailureObservable(): Maybe<Int>? {
        return failureScenario
    }

    fun getCompletableObservable(): Maybe<Int>? {
        return completeScenario
    }


    fun addSubscription(): CompositeDisposable {
        return subscriptions
    }

    fun disposeAll(){ subscriptions.dispose() }

}