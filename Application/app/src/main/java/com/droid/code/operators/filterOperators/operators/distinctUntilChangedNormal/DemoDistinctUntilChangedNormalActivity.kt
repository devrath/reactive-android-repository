package com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityDistinctUntilChangedNormalBinding

class DemoDistinctUntilChangedNormalActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityDistinctUntilChangedNormalBinding

    private val demo = OperatorDistinctNormal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistinctUntilChangedNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.initiateId.setOnClickListener {
            demo.addValuesForObservable()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}