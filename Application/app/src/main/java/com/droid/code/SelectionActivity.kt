package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.operators.OperatorsSelectionActivity
import com.droid.code.specialObservables.SpecialObservableSelectionActivity
import com.droid.code.subjects.SubjectsSelectionActivity
import com.droid.code.util.openActivity

const val PROJECT_TAG = "PIKACHU"

class SelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.specialObservablesId.setOnClickListener { openActivity(SpecialObservableSelectionActivity::class.java) }
        binding.subjectsId.setOnClickListener { openActivity(SubjectsSelectionActivity::class.java) }
        binding.operatorsId.setOnClickListener { openActivity(OperatorsSelectionActivity::class.java) }
    }
}