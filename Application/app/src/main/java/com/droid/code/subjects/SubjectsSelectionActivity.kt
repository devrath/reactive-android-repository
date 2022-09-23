package com.droid.code.subjects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivitySubjectsSelectionBinding

class SubjectsSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}