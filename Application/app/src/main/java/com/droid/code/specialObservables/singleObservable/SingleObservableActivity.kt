package com.droid.code.specialObservables.singleObservable

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.PROJECT_TAG
import com.droid.code.databinding.ActivityObservableSingleBinding
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SingleObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableSingleBinding

    private val data = DemoSingleObservable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableSingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnSuccessId.setOnClickListener {
            data.getSuccessObservable()
                ?.observeOn(Schedulers.io())
                ?.subscribe({
                    Log.d(PROJECT_TAG,it.toString())
                }, {
                    Log.d(PROJECT_TAG,it.message.toString())
                })?.addTo(data.addSubscription())
        }

        binding.btnFailureId.setOnClickListener {
            data.getFailureObservable()
                ?.observeOn(Schedulers.io())
                ?.subscribe({
                    Log.d(PROJECT_TAG,it.toString())
                }, {
                    Log.d(PROJECT_TAG,it.message.toString())
                })?.addTo(data.addSubscription())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        data.disposeAll()
    }
}