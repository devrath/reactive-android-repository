package com.droid.code.operators.transformOperators.operators.flatmapOperator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityDistinctUntilChangedCustomBinding
import com.droid.code.databinding.ActivityFlatmapBinding
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom.OperatorDistinctCustom

class FlatmapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlatmapBinding

    private val demo = FlatMapSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlatmapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnInitiateId.setOnClickListener {
            demo.subscribeDemo()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}