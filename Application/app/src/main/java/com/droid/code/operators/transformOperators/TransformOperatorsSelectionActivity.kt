package com.droid.code.operators.filterOperators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityFilterOperatorsSelectionBinding
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom.DemoDistinctUntilChangedCustomActivity
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal.DemoDistinctUntilChangedNormalActivity
import com.droid.code.util.openActivity

class FilterOperatorsSelectionActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityFilterOperatorsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterOperatorsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.distinctNormalOprId.setOnClickListener {
            openActivity(DemoDistinctUntilChangedNormalActivity::class.java)
        }
        binding.distinctNormalCustId.setOnClickListener {
            openActivity(DemoDistinctUntilChangedCustomActivity::class.java)
        }
    }

}