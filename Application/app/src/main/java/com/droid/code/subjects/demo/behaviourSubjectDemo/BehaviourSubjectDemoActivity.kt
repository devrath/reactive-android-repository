package com.droid.code.subjects.demo.behaviourSubjectDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityBehaviourSubjectBinding
import com.droid.code.databinding.ActivityPublishSubjectDemoBinding
import com.droid.code.subjects.demo.publishSubjectDemo.DemoPublishSubject

class BehaviourSubjectDemoActivity : AppCompatActivity() {

    private val demo = DemoBehaviourSubject()
    private lateinit var binding: ActivityBehaviourSubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBehaviourSubjectBinding.inflate(layoutInflater)
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

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}