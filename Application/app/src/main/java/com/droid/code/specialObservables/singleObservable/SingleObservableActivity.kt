package com.droid.code.specialObservables.singleObservable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityObservableSingleBinding
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding

class SingleObservableActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableSingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityObservableSingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {

    }
}