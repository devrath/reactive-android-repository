package com.droid.code.operators.combiningOperators

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityCombiningOperatorsSelectionBinding
import com.droid.code.databinding.ActivityFilterOperatorsSelectionBinding
import com.droid.code.operators.combiningOperators.operators.concat.DemoConcatActivity
import com.droid.code.operators.combiningOperators.operators.concatMap.DemoConcatMapActivity
import com.droid.code.operators.combiningOperators.operators.concatWith.DemoConcatWithActivity
import com.droid.code.operators.combiningOperators.operators.startsWith.DemoStartsWithActivity
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedCustom.DemoDistinctUntilChangedCustomActivity
import com.droid.code.operators.filterOperators.operators.distinctUntilChangedNormal.DemoDistinctUntilChangedNormalActivity
import com.droid.code.util.openActivity

class CombiningOperatorsSelectionActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityCombiningOperatorsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCombiningOperatorsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.startWithId.setOnClickListener {
           openActivity(DemoStartsWithActivity::class.java)
        }
        binding.concatId.setOnClickListener {
            openActivity(DemoConcatActivity::class.java)
        }
        binding.concatWithId.setOnClickListener {
            openActivity(DemoConcatWithActivity::class.java)
        }
        binding.concatMapId.setOnClickListener {
            openActivity(DemoConcatMapActivity::class.java)
        }
    }

}