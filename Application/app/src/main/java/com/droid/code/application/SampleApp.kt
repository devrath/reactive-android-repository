package com.droid.code.application

import android.app.Application
import android.content.Context
import android.util.Log
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins




class SampleApp : Application() {

    companion object {
        private lateinit var instance: SampleApp

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        catchApplicationError()
    }

    private fun catchApplicationError() {
        RxJavaPlugins.setErrorHandler { e: Throwable? ->
            if (e is UndeliverableException) {
                // Merely log undeliverable exceptions
                Log.d("AppTag", e.message.toString())
            } else {
                // Forward all others to current thread's uncaught exception handler
                Thread.currentThread().also { thread ->
                    thread.uncaughtExceptionHandler?.uncaughtException(thread, e)
                }
            }
        }
    }
}