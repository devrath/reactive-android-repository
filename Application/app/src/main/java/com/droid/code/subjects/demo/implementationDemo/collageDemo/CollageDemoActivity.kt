package com.droid.code.subjects.demo.implementationDemo.collageDemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.droid.code.R
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.SharedViewModel
import kotlinx.android.synthetic.main.activity_collage_main.addButton
import kotlinx.android.synthetic.main.activity_collage_main.clearButton
import kotlinx.android.synthetic.main.activity_collage_main.saveButton


class CollageDemoActivity : AppCompatActivity() {

  private lateinit var viewModel: SharedViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_collage_main)

    title = getString(R.string.collage)

    viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

    addButton.setOnClickListener {
      actionAdd()
    }

    clearButton.setOnClickListener {
      actionClear()
    }

    saveButton.setOnClickListener {
      actionSave()
    }
  }

  private fun actionAdd() {
    println("actionAdd")
  }

  private fun actionClear() {
    println("actionClear")
  }

  private fun actionSave() {
    println("actionSave")
  }
}
