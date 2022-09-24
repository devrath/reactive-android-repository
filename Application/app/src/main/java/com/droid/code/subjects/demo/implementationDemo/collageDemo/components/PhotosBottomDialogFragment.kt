package com.droid.code.subjects.demo.implementationDemo.collageDemo.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.droid.code.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.android.synthetic.main.layout_collage_photo_bottom_sheet.photosRecyclerView


class PhotosBottomDialogFragment : BottomSheetDialogFragment(), PhotosAdapter.PhotoListener {

  private lateinit var viewModel: SharedViewModel

  private val selectedPhotosSubject = PublishSubject.create<Photo>()

  val selectedPhotos: Observable<Photo> = selectedPhotosSubject.hide()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.layout_collage_photo_bottom_sheet, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    val ctx = activity
    ctx?.let {
      viewModel = ViewModelProvider(ctx).get(SharedViewModel::class.java)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    photosRecyclerView.layoutManager = GridLayoutManager(context, 3)
    photosRecyclerView.adapter = PhotosAdapter(PhotoStore.photos, this)
  }

  override fun onDestroyView() {
    selectedPhotosSubject.onComplete()
    super.onDestroyView()
  }

  override fun photoClicked(photo: Photo) {
    selectedPhotosSubject.onNext(photo)
  }

  companion object {
    const val TAG = "PhotosBottomDialogFragment"
    fun newInstance(): PhotosBottomDialogFragment {
      return PhotosBottomDialogFragment()
    }
  }
}