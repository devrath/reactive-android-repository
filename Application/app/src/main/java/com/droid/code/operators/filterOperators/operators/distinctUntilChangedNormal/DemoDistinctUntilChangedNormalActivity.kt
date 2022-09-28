package com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityDistinctUntilChangedNormalBinding

class DemoDistinctUntilChangedNormalActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityDistinctUntilChangedNormalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistinctUntilChangedNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
       /* binding.distinctNormalOprId.setOnClickListener {

        }
        binding.distinctNormalCustId.setOnClickListener {

        }*/
    }
}