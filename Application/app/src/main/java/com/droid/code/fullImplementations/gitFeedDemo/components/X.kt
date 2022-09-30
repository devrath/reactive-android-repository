package com.droid.code.fullImplementations.gitFeedDemo.components

import android.content.Context
import androidx.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droid.code.application.SampleApp
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*


typealias AnyDict = Map<String, Any>

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
  return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun getGson(): Gson {
  val builder = GsonBuilder()
  builder.registerTypeAdapter(Event::class.java, EventTypeAdapter())
  return builder.create()
}

private fun eventsDirectory() = SampleApp.getAppContext().getDir("events", Context.MODE_PRIVATE)

fun eventsFile() = File(eventsDirectory(), "events.txt")

fun eventsOutputStream(): FileOutputStream {
  return FileOutputStream(eventsFile())
}

fun eventsInputStream(): FileInputStream {
  return FileInputStream(eventsFile())
}

fun lastModifiedFile() = File(eventsDirectory(), "modified.txt")

fun lastModifiedOutputStream(): FileOutputStream {
  return FileOutputStream(lastModifiedFile())
}

fun lastModifiedInputStream(): FileInputStream {
  return FileInputStream(lastModifiedFile())
}


@Throws(IOException::class)
private fun convertStreamToString(inputStream: InputStream): String {
  val reader = BufferedReader(InputStreamReader(inputStream))
  val sb = StringBuilder()
  var line: String? = reader.readLine()
  while (line != null) {
    sb.append(line).append("\n")
    line = reader.readLine()
  }
  reader.close()
  return sb.toString()
}

object EventsStore {

  fun saveEvents(events: List<Event>) {
    val gson = getGson()
    try {
      val json = gson.toJson(events)
      val eventsStream = eventsOutputStream()
      eventsStream.write(json.toByteArray())
      eventsStream.close()
    } catch (e: IOException) {
      Log.e("OutputError", "Error saving events")
    }
  }

  fun readEvents(): List<Event>? {
    val gson = getGson()
    val eventListType = object : TypeToken<ArrayList<Event>>() {}.type

    try {
      val json = convertStreamToString(eventsInputStream())
      return gson.fromJson<List<Event>>(json, eventListType)
    } catch (e: IOException) {
      Log.e("Input Error", "Error reading events")
    }

    return null
  }

  fun saveLastModified(lastModified: String) {
    try {
      val lastModifiedStream = lastModifiedOutputStream()
      lastModifiedStream.write(lastModified.toByteArray())
      lastModifiedStream.close()
    } catch (e: IOException) {
      Log.e("OutputError", "Error saving last modified")
    }
  }

  fun readLastModified(): String? {
    if (!lastModifiedFile().exists()) {
      return null
    }

    return try {
      convertStreamToString(lastModifiedInputStream())
    } catch (e: IOException) {
      Log.e("Input Error", "Error reading last modified")
      null
    }
  }
}
