package com.droid.code.operators.transformOperators.operators.flatmapOperator

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class FlatMapSource {

    // Let's create the source of the observable which we can emit some integers
    private val sourceSubject = PublishSubject.create<UserFlatMap>()

    // Observable-1: Even observable
    private val evenNumbers = UserFlatMap(BehaviorSubject.createDefault(2))
    // Observable-2: Odd observable
    private val oddNumbers = UserFlatMap(BehaviorSubject.createDefault(1))

    private val subscriptions = CompositeDisposable()


    fun subscribeDemo() {
        sourceSubject
            .flatMap { it.age }
            .subscribe {
                Log.d(PROJECT_TAG, "Subscriber-Triggered".plus(" ").plus(it))
            }
            .addTo(subscriptions)

        // I add a new observable that has a default value
        sourceSubject.onNext(oddNumbers)
        // I modify the newly added observable value
        oddNumbers.age.onNext(3)
        // Again I add a new observable that has a default value
        sourceSubject.onNext(evenNumbers)
        // I modify the newly added observable value
        evenNumbers.age.onNext(4)

    }


    fun disposeAll(){ subscriptions.dispose() }

}