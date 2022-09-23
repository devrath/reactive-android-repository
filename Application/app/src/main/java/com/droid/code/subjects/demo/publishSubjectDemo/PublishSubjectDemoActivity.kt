package com.droid.code.subjects.demo.publishSubjectDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityPublishSubjectDemoBinding
import com.droid.code.subjects.demo.utils.DemoPublishSubject

class PublishSubjectDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPublishSubjectDemoBinding
    private val demo = DemoPublishSubject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublishSubjectDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnPublishId.setOnClickListener {
            demo.addElement()
        }

        binding.btnSubscriberOneId.setOnClickListener {
            demo.subscriberOne()
        }

        binding.btnSubscriberTwoId.setOnClickListener {
            demo.subscriberTwo()
        }
    }
}