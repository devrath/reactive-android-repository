package com.droid.code.operators.combiningOperators.operators.concatWith

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityConcatDemoBinding
import com.droid.code.databinding.ActivityConcatWithBinding

class DemoConcatWithActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityConcatWithBinding

    private val demo = OperatorConcatWith()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConcatWithBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnInitiateId.setOnClickListener {
            demo.subscribeForSuccess()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}