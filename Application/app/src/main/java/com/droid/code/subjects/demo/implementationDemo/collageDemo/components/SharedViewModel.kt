package com.droid.code.subjects.demo.implementationDemo.collageDemo.components

import androidx.lifecycle.ViewModel
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream


class SharedViewModel : ViewModel() {

  fun saveBitmapFromImageView(imageView: ImageView, context: Context) {
    val tmpImg = "${System.currentTimeMillis()}.png"

    val os: OutputStream?

    val collagesDirectory = File(context.getExternalFilesDir(null), "collages")
    if (!collagesDirectory.exists()) {
      collagesDirectory.mkdirs()
    }

    val file = File(collagesDirectory, tmpImg)

    try {
      os = FileOutputStream(file)
      val bitmap = (imageView.drawable as BitmapDrawable).bitmap
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, os)
      os.flush()
      os.close()
    } catch(e: IOException) {
      Log.e("MainActivity", "Problem saving collage", e)
    }
  }
}