package com.droid.code.operators.transformOperators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityFilterOperatorsSelectionBinding
import com.droid.code.databinding.ActivityTransformOperatorsSelectionBinding
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom.DemoDistinctUntilChangedCustomActivity
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal.DemoDistinctUntilChangedNormalActivity
import com.droid.code.operators.transformOperators.operators.flatmapOperator.FlatmapActivity
import com.droid.code.operators.transformOperators.operators.materializeOperator.MaterializeActivity
import com.droid.code.operators.transformOperators.operators.switchmapOperator.SwitchMapActivity
import com.droid.code.util.openActivity

class TransformOperatorsSelectionActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityTransformOperatorsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransformOperatorsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnFlatMapOperatorId.setOnClickListener {
            openActivity(FlatmapActivity::class.java)
        }
        binding.btnSwitchMapOperatorId.setOnClickListener {
            openActivity(SwitchMapActivity::class.java)
        }
        binding.btnMaterializeOperatorId.setOnClickListener {
            openActivity(MaterializeActivity::class.java)
        }
    }

}