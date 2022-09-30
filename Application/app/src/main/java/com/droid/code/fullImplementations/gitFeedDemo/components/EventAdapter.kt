package com.droid.code.fullImplementations.gitFeedDemo.components

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.droid.code.R


class EventAdapter(private val events: MutableList<Event>) : androidx.recyclerview.widget.RecyclerView.Adapter<EventAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.list_item_event))
  }

  override fun getItemCount() = events.size

  fun updateEvents(events: List<Event>?) {
    this.events.addAll(events ?: emptyList())
    notifyDataSetChanged()
  }

  fun clear() {
    events.clear()
    notifyDataSetChanged()
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(events[position])
  }

  inner class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    private val avatar = itemView.findViewById<ImageView>(R.id.avatar)
    private val name = itemView.findViewById<TextView>(R.id.name)
    private val repoAction = itemView.findViewById<TextView>(R.id.repoAction)

    fun bind(event: Event) {
      name.text = event.name
      val action = event.action.toLowerCase().replace("event", "")
      repoAction.text = String.format(itemView.context.getString(R.string.repoAction), event.repo, action)
      Glide.with(avatar.context).load(event.imageUrl).into(avatar)
    }
  }
}
