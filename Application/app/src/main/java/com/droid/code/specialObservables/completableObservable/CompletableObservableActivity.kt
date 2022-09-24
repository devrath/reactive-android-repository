package com.droid.code.specialObservables.completableObservable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityObservableCompletableBinding
import com.droid.code.databinding.ActivityObservableSingleBinding
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding

class CompletableObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableCompletableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableCompletableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {

    }
}