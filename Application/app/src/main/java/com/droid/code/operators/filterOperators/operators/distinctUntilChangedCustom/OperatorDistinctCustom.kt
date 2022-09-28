package com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.PublishSubject

class OperatorDistinctCustom {

    // Let's create the source of the observable which we can emit some integers
    private val publishSubject: PublishSubject<User> = PublishSubject.create<User>()
    private val subscriptions = CompositeDisposable()

    init {
        subscribeForSuccess()
    }

    fun addValuesForObservable() {
        publishSubject.apply {
            onNext(User(name = "User1", age = 20))
            onNext(User(name = "User2", age = 21))
            onNext(User(name = "User3", age = 2))
            onNext(User(name = "User4", age = 10))
            onNext(User(name = "User5", age = 25))
            onNext(User(name = "User6", age = 30))
            onNext(User(name = "User7", age = 40))
            onNext(User(name = "User8", age = 10))
        }
    }

    private fun subscribeForSuccess() {
        val dispose = publishSubject
            .distinctUntilChanged { first, second ->
                first.age > 20
            }
            .subscribe {
                Log.d(
                    PROJECT_TAG,
                    "Subscriber-Success-Demo"
                        .plus("<-->")
                        .plus("Name:->"+it.name)
                        .plus("<-->")
                        .plus("Age:->"+it.age)
                )
            }.addTo(subscriptions)
        subscriptions.add(dispose)
    }


    fun disposeAll(){ subscriptions.dispose() }

}