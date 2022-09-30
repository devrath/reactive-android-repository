package com.droid.code.fullImplementations.gitFeedDemo.components

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class GitFeedViewModel : ViewModel() {

  val eventLiveData = MutableLiveData<List<Event>>()

  var events = mutableListOf<Event>()

  private val gitHubApi by lazy {
    GitHubApi.create()
  }

  private val disposables = CompositeDisposable()

  fun fetchEvents(repo: String) {
    eventLiveData.value = EventsStore.readEvents()

    val lastModified = EventsStore.readLastModified()

    val apiResponse = gitHubApi.fetchEvents(repo, lastModified?.trim() ?: "").share()

    apiResponse
        .filter { response ->
          (200..300).contains(response.code())
        }
        .map { response ->
          response.body()!!
        }
        .filter { objects ->
          objects.isNotEmpty()
        }
        .map { objects ->
          objects.mapNotNull { Event.fromAnyDict(it) }
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy(
            onNext = { events -> processEvents(events) },
            onError = { error -> println("Events Error ::: ${error.message}") }
        )
        .addTo(disposables)

    apiResponse
        .filter { response ->
          (200 until 300).contains(response.code())
        }
        .flatMap { response ->
          val value = response.headers().get("Last-Modified")
          if (value == null) {
            Observable.empty()
          } else {
            Observable.just(value)
          }
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy(
            onNext = { EventsStore.saveLastModified(it) },
            onError = { error -> println("Last Modified Error ::: ${error.message}") }
        )
        .addTo(disposables)
  }

  override fun onCleared() {
    super.onCleared()
    disposables.dispose()
  }

  private fun processEvents(newEvents: List<Event>) {
    var updatedEvents = newEvents + events

    if (updatedEvents.size > 50) {
      updatedEvents = updatedEvents.slice(0 until 50)
    }

    events = updatedEvents.toMutableList()

    eventLiveData.value = events

    EventsStore.saveEvents(events)
  }
}
