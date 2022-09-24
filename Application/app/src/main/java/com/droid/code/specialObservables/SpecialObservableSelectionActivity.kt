package com.droid.code.specialObservables

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivitySpecialObservableSelectionBinding
import com.droid.code.databinding.ActivitySubjectsSelectionBinding
import com.droid.code.fullImplementations.collageDemo.CollageDemoActivity
import com.droid.code.specialObservables.completableObservable.CompletableObservableActivity
import com.droid.code.specialObservables.maybeObservable.MaybeObservableActivity
import com.droid.code.specialObservables.singleObservable.SingleObservableActivity
import com.droid.code.subjects.asyncSubjectDemo.AsyncSubjectDemoActivity
import com.droid.code.subjects.behaviourSubjectDemo.BehaviourSubjectDemoActivity
import com.droid.code.subjects.publishSubjectDemo.PublishSubjectDemoActivity
import com.droid.code.subjects.replaySubjectDemo.ReplaySubjectDemoActivity
import com.droid.code.util.openActivity

class SpecialObservableSelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpecialObservableSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpecialObservableSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener() {
        binding.btnSingleObservableId.setOnClickListener {
            openActivity(SingleObservableActivity::class.java)
        }
        binding.btnCompletableObservableId.setOnClickListener {
            openActivity(CompletableObservableActivity::class.java)
        }
        binding.btnMaybeObservableId.setOnClickListener {
            openActivity(MaybeObservableActivity::class.java)
        }
    }
}