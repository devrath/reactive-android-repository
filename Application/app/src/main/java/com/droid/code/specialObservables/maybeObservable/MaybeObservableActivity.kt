package com.droid.code.specialObservables.maybeObservable

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.PROJECT_TAG
import com.droid.code.databinding.ActivityObservableCompletableBinding
import com.droid.code.databinding.ActivityObservableMaybeBinding
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class MaybeObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableMaybeBinding

    private val demo = DemoMaybeObservable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableMaybeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnSuccessId.setOnClickListener {
            demo.getSuccessObservable()
                ?.observeOn(Schedulers.io())
                ?.subscribe(
                    { Log.d(PROJECT_TAG,"SUCCESS".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"FAILURE".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"COMPLETED") }
                )
                ?.addTo(demo.addSubscription())
        }
        binding.btnFailureId.setOnClickListener {
            demo.getFailureObservable()
                ?.observeOn(Schedulers.io())
                ?.subscribe(
                    { Log.d(PROJECT_TAG,"SUCCESS".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"FAILURE".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"COMPLETED") }
                )
                ?.addTo(demo.addSubscription())
        }
        binding.btnCompletionId.setOnClickListener {
            demo.getCompletableObservable()
                ?.observeOn(Schedulers.io())
                ?.subscribe(
                    { Log.d(PROJECT_TAG,"SUCCESS".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"FAILURE".plus("--").plus(it.toString())) },
                    { Log.d(PROJECT_TAG,"COMPLETED") }
                )
                ?.addTo(demo.addSubscription())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}