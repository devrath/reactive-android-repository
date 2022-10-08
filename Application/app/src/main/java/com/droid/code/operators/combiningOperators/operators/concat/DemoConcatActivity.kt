package com.droid.code.operators.combiningOperators.operators.concat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityConcatDemoBinding
import com.droid.code.databinding.ActivityStartsWithDemoBinding

class DemoConcatActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityConcatDemoBinding

    private val demo = OperatorConcat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConcatDemoBinding.inflate(layoutInflater)
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