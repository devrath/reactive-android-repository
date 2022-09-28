package com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityDistinctUntilChangedCustomBinding

class DemoDistinctUntilChangedCustomActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityDistinctUntilChangedCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistinctUntilChangedCustomBinding.inflate(layoutInflater)
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