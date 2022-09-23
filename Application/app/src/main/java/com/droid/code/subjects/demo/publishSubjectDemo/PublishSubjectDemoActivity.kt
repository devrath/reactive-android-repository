package com.droid.code.subjects.demo.publishSubjectDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityPublishSubjectDemoBinding

class PublishSubjectDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPublishSubjectDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishSubjectDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}