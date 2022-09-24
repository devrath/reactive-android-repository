package com.droid.code.specialObservables.maybeObservable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityObservableCompletableBinding
import com.droid.code.databinding.ActivityObservableMaybeBinding
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding

class MaybeObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableMaybeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableMaybeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {

    }
}