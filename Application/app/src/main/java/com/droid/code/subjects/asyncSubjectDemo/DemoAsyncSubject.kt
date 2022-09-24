package com.droid.code.subjects.asyncSubjectDemo

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

class DemoAsyncSubject {

    private val publishSubject: AsyncSubject<Int> = AsyncSubject.create<Int>()
    private val subscriptions = CompositeDisposable()

    var count : Int = 1

    fun addElement(){
        Log.d(PROJECT_TAG,"Adding a new element".plus(" ").plus(count).plus(" ").plus("to subscriber"))
        publishSubject.onNext(count)
        count++
    }

    fun subscriberOne() {
        val dispose = publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-1".plus("<---->").plus(it.toString()))
        }
        subscriptions.add(dispose)
    }

    fun subscriberTwo() {
        val dispose = publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-2".plus("<---->").plus(it.toString()))
        }
        subscriptions.add(dispose)
    }

    fun disposeAll(){ subscriptions.dispose() }

}