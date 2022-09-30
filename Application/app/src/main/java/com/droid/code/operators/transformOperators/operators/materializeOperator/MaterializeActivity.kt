package com.droid.code.operators.transformOperators.operators.materializeOperator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.databinding.ActivityMaterializeBinding

class MaterializeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaterializeBinding

    private val demo = MaterializeSource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterializeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnInitiateId.setOnClickListener {
            demo.subscribeDemo()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        demo.disposeAll()
    }
}