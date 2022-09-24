package com.droid.code.subjects.demo.implementationDemo.collageDemo

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.droid.code.R
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.Photo
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.PhotoStore
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.PhotosBottomDialogFragment
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.SharedViewModel
import com.droid.code.subjects.demo.implementationDemo.collageDemo.components.combineImages
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_collage_main.addButton
import kotlinx.android.synthetic.main.activity_collage_main.clearButton
import kotlinx.android.synthetic.main.activity_collage_main.collageImage
import kotlinx.android.synthetic.main.activity_collage_main.progressBar
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

    viewModel.getSelectedPhotos().observe(this, Observer { photos ->
      photos?.let { _ ->
        if (photos.isNotEmpty()) {
          val bitmaps = photos.map { BitmapFactory.decodeResource(resources, it.drawable) }
          val newBitmap = combineImages(bitmaps)
          collageImage.setImageDrawable(BitmapDrawable(resources, newBitmap))
        } else {
          collageImage.setImageResource(android.R.color.transparent)
        }
        updateUi(photos)
      }
    })

  }
  private fun actionAdd() {
    val addPhotoBottomDialogFragment = PhotosBottomDialogFragment.newInstance()
    addPhotoBottomDialogFragment.show(supportFragmentManager, PhotosBottomDialogFragment::class.java.name)
    viewModel.subscribeSelectedPhotos(
      addPhotoBottomDialogFragment.selectedPhotos)
  }

  private fun actionClear() {
    viewModel.clearPhotos()
  }

  private fun actionSave() {
    progressBar.visibility = View.VISIBLE
    viewModel.saveBitmapFromImageView(collageImage, applicationContext)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeBy(
        onSuccess = { file ->
          Toast.makeText(this, "$file saved", Toast.LENGTH_SHORT).show()
          progressBar.visibility = View.GONE
        },
        onError = { error ->
          Toast.makeText(this, "Error saving file :${error.localizedMessage}", Toast.LENGTH_SHORT).show()
          progressBar.visibility = View.GONE
        }
      )
  }

  private fun updateUi(photos: List<Photo>) {
    saveButton.isEnabled = photos.isNotEmpty() && (photos.size % 2 == 0)
    clearButton.isEnabled = photos.isNotEmpty()
    addButton.isEnabled = photos.size < 6
    title = if (photos.isNotEmpty()) {
      resources.getQuantityString(R.plurals.photos_format, photos.size, photos.size)
    } else {
      getString(R.string.collage)
    }
  }
}
