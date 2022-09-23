package com.droid.code.subjects.demo.utils

import android.util.Log
import com.droid.code.PROJECT_TAG
import io.reactivex.rxjava3.subjects.PublishSubject

class DemoPublishSubject {

    private val publishSubject: PublishSubject<Int> = PublishSubject.create<Int>()

    var count : Int = 1

    fun addElement(){
        Log.d(PROJECT_TAG,"Adding a new element".plus(" ").plus(count).plus(" ").plus("to subscriber"))
        publishSubject.onNext(count)
        count++
    }

    fun subscriberOne() {
        publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-1".plus("<---->").plus(it.toString()))
        }
    }

    fun subscriberTwo() {
        publishSubject.subscribe {
            Log.d(PROJECT_TAG,"Subscriber-2".plus("<---->").plus(it.toString()))
        }
    }

}