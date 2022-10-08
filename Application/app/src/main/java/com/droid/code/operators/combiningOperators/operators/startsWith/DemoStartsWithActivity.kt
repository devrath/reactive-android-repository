package com.droid.code.operators.combiningOperators.operators.startsWith

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityStartsWithDemoBinding

class DemoStartsWithActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityStartsWithDemoBinding

    private val demo = OperatorStartsWith()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartsWithDemoBinding.inflate(layoutInflater)
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