package com.droid.code.specialObservables.completableObservable

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.PROJECT_TAG
import com.droid.code.databinding.ActivityObservableCompletableBinding
import com.droid.code.databinding.ActivityObservableSingleBinding
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding
import io.reactivex.rxjava3.schedulers.Schedulers

class CompletableObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableCompletableBinding

    private val demo = DemoCompletableObservable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableCompletableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnCompletionId.setOnClickListener {
            demo.getCompletableObservable()
                ?.observeOn(Schedulers.io())?.subscribe(
                    {
                        Log.d(PROJECT_TAG,"COMPLETE")
                    },{
                        Log.d(PROJECT_TAG,"ERROR".plus("--").plus(it.toString()))
                    }
                )
        }
        binding.btnFailureId.setOnClickListener {
            demo.getFailureObservable()
                ?.observeOn(Schedulers.io())?.subscribe(
                    {
                        Log.d(PROJECT_TAG,"COMPLETE")
                    },{
                        Log.d(PROJECT_TAG,"ERROR".plus("--").plus(it.toString()))
                    }
                )
        }
    }
}