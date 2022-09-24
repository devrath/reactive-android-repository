package com.droid.code.fullImplementations.collageDemo.components

import androidx.lifecycle.ViewModel
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream


class SharedViewModel : ViewModel() {

  // Composite disposable for Rx functions
  private val disposables = CompositeDisposable()
  // It will emit mutable list of photos
  private val imagesSubject: BehaviorSubject<MutableList<Photo>> =
    BehaviorSubject.createDefault(mutableListOf())
  // We shall use this variable to stream the selected photos to the view
  private val selectedPhotos = MutableLiveData<List<Photo>>()


  init {
    // Here when the view model is started, we subscribe to the  image subject
    imagesSubject.subscribe { photos ->
      // Here we add values to the live data when the subscriber is triggered
      selectedPhotos.value = photos
    }.addTo(disposables) // Using this extension function, we add the subscriber to disposables
  }

  /**
   * The view layer keeps listening to the changes in live data in view model
   */
  fun getSelectedPhotos(): LiveData<List<Photo>> {
    return selectedPhotos
  }

  /**
   * Control will come from::
   * <*> Adapter of bottom sheet to fragment of bottom sheet via callback.
   * <*> OnNext of the observable is triggered in the fragment o bottom sheet.
   * <*> It is linked to view-model of activity via a function in activity.
   * <*> In the activity we use the adapter reference to refer the fragment observable
   * <*> Now when the observable is bottom sheet is triggered on adding the image below function is called
   */
  fun subscribeSelectedPhotos(selectedPhotos: Observable<Photo>) {
    selectedPhotos
      .doOnComplete {
        // When the bottom sheet dialog is destroyed -> this complete action is triggered
        Log.v("SharedViewModel", "Completed selecting photos")
      }
      .subscribe { photo ->
        // When new image is added
        // <*> --> we add it to the behaviour subject
        imagesSubject.value?.add(photo)
        // <*> --> we trigger the behaviour subject
        imagesSubject.onNext(imagesSubject.value ?: mutableListOf())
      }
      .addTo(disposables)
  }

  fun clearPhotos() {
    imagesSubject.value?.clear()
    imagesSubject.onNext(imagesSubject.value!!)
  }

  fun saveBitmapFromImageView(imageView: ImageView, context: Context): Single<String> {
    return Single.create { observer ->
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
        observer.onSuccess(tmpImg)
      } catch (e: IOException) {
        observer.onError(e)
      }
    }
  }


  override fun onCleared() {
    disposables.dispose()
    super.onCleared()
  }

}