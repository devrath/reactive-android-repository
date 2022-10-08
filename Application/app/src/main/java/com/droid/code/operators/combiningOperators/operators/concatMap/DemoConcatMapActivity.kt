package com.droid.code.operators.combiningOperators.operators.concatMap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityConcatMapDemoBinding
import com.droid.code.databinding.ActivityConcatWithBinding

class DemoConcatMapActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityConcatMapDemoBinding

    private val demo = OperatorConcatMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConcatMapDemoBinding.inflate(layoutInflater)
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