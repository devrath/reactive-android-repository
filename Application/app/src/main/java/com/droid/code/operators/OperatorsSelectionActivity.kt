package com.droid.code.operators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.code.databinding.ActivityOperatorsSelectionBinding
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.operators.filterOperators.FilterOperatorsSelectionActivity
import com.droid.code.operators.transformOperators.TransformOperatorsSelectionActivity
import com.droid.code.specialObservables.SpecialObservableSelectionActivity
import com.droid.code.subjects.SubjectsSelectionActivity
import com.droid.code.util.openActivity

class OperatorsSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOperatorsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOperatorsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.filterOperatorsId.setOnClickListener { openActivity(FilterOperatorsSelectionActivity::class.java) }
        binding.transformingOperatorsId.setOnClickListener { openActivity(TransformOperatorsSelectionActivity::class.java) }
        binding.combiningOperatorsId.setOnClickListener {

        }
    }
}