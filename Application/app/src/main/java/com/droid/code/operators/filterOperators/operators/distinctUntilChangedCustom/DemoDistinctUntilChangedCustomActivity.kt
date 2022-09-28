package com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityDistinctUntilChangedCustomBinding
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal.OperatorDistinctNormal

class DemoDistinctUntilChangedCustomActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityDistinctUntilChangedCustomBinding

    private val demo = OperatorDistinctCustom()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistinctUntilChangedCustomBinding.inflate(layoutInflater)
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