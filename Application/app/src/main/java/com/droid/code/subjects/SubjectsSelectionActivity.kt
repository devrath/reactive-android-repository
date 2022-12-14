package com.droid.code.subjects

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivitySubjectsSelectionBinding
import com.droid.code.fullImplementations.collageDemo.CollageDemoActivity
import com.droid.code.subjects.asyncSubjectDemo.AsyncSubjectDemoActivity
import com.droid.code.subjects.behaviourSubjectDemo.BehaviourSubjectDemoActivity
import com.droid.code.subjects.publishSubjectDemo.PublishSubjectDemoActivity
import com.droid.code.subjects.replaySubjectDemo.ReplaySubjectDemoActivity
import com.droid.code.util.openActivity

class SubjectsSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectsSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySubjectsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnPublishSubjectId.setOnClickListener {
            openActivity(PublishSubjectDemoActivity::class.java)
        }
        binding.btnBehaviourSubjectId.setOnClickListener {
            openActivity(BehaviourSubjectDemoActivity::class.java)
        }
        binding.btnReplaySubjectId.setOnClickListener {
            openActivity(ReplaySubjectDemoActivity::class.java)
        }
        binding.btnAsyncSubjectId.setOnClickListener {
            openActivity(AsyncSubjectDemoActivity::class.java)
        }

        binding.btnPhotoCollageDemoId.setOnClickListener {
            openActivity(CollageDemoActivity::class.java)
        }
    }
}