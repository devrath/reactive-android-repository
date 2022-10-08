package com.droid.code.operators.combiningOperators.operators.merge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityConcatDemoBinding
import com.droid.code.databinding.ActivityMergeDemoBinding

class DemoMergeActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityMergeDemoBinding

    private val demo = OperatorMerge()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMergeDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnLeftObservableId.setOnClickListener {
            val data = binding.editTextTextPersonName.text
            demo.source1.onNext("Left-".plus(data))
        }
        binding.btnRightObservableId.setOnClickListener {
            val data = binding.editTextTextPersonName.text
            demo.source2.onNext("Right-".plus(data))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}