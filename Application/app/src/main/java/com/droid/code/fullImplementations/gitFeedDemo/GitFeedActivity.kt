package com.droid.code.fullImplementations.gitFeedDemo

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.droid.code.R
import com.droid.code.fullImplementations.gitFeedDemo.components.EventAdapter
import com.droid.code.fullImplementations.gitFeedDemo.components.GitFeedViewModel
import kotlinx.android.synthetic.main.activity_git_feed.recyclerView
import kotlinx.android.synthetic.main.activity_git_feed.swipeContainer


class GitFeedActivity : AppCompatActivity() {

  private lateinit var viewModel: GitFeedViewModel

  private val adapter = EventAdapter(mutableListOf())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_git_feed)

    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = adapter

    swipeContainer.setOnRefreshListener {
      adapter.clear()
      viewModel.fetchEvents("RxKotlin")
    }

    viewModel = ViewModelProvider(this).get(GitFeedViewModel::class.java)

    viewModel.eventLiveData.observe(this, Observer { events ->
      adapter.updateEvents(events)
      swipeContainer.isRefreshing = false
    })

    viewModel.fetchEvents("RxKotlin")
  }
}
