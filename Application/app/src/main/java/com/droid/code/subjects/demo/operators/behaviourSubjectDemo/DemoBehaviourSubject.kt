package com.droid.code.subjects.demo.operators.behaviourSubjectDemo

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

class DemoBehaviourSubject {

    private val publishSubject: BehaviorSubject<Int> = BehaviorSubject.createDefault(0)
    private val subscriptions = CompositeDisposable()

    var count : Int = 1

    fun addElement(){
        Log.d(PROJECT_TAG,"Adding a new element".plus(" ").plus(count).plus(" ").plus("to subscriber"))
        publishSubject.onNext(count)
        count++
    }

    fun subscriberOne() {
        val disposable = publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-1".plus("<---->").plus(it.toString()))
        }
        subscriptions.add(disposable)
    }

    fun subscriberTwo() {
        val disposable = publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-2".plus("<---->").plus(it.toString()))
        }
        subscriptions.add(disposable)
    }

    fun disposeAll(){ subscriptions.dispose() }

}