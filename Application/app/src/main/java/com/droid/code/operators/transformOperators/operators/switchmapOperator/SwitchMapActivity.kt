package com.droid.code.operators.transformOperators.operators.switchmapOperator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivitySwitchmapBinding
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom.OperatorDistinctCustom

class SwitchMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchmapBinding

    private val demo = SwitchMapSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchmapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnInitiateId.setOnClickListener {
            demo.subscribeDemo()
        }
    }

}