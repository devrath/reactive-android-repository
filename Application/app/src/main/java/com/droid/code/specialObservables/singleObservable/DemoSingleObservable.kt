package com.droid.code.specialObservables.singleObservable

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

class DemoSingleObservable {

    private val subscriptions = CompositeDisposable()

    private val successScenario = Single.create { emitter ->

        var sum = 0
        // Perform long running task
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }

        emitter.onSuccess(sum)

        //emitter.onError(RuntimeException("Some custom exception"))
    }

    private val failureScenario = Single.create { emitter ->

        var sum = 0
        emitter.onError(RuntimeException("Some custom exception"))
        for(i in 1..5){
            Thread.sleep(500L)
            sum += i
        }

        emitter.onSuccess(sum)
    }

    fun getSuccessObservable(): Single<Int>? {
        return successScenario
    }

    fun getFailureObservable(): Single<Int>? {
        return failureScenario
    }


    fun disposeAll(){ subscriptions.dispose() }

}