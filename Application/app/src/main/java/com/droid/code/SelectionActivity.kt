package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.subjects.SubjectsSelectionActivity
import com.droid.code.util.openActivity

class SelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {

        binding.subjectsId.setOnClickListener { openActivity(SubjectsSelectionActivity::class.java) }

    }


}