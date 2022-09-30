package com.droid.code.fullImplementations.gitFeedDemo.components

data class Event(
    val repo: String,
    val name: String,
    val imageUrl: String,
    val action: String) {

  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromAnyDict(dict: AnyDict): Event? {
      val repoDict = dict["repo"] as? AnyDict
      val actor = dict["actor"] as? AnyDict
      val repoName = repoDict?.get("name") as? String
      val actorName = actor?.get("display_login") as? String
      val actorUrlString = actor?.get("avatar_url") as? String
      val actionType = dict["type"] as? String

      if (repoName == null || actorName == null || actorUrlString == null || actionType == null) {
        return null
      }

      return Event(repoName, actorName, actorUrlString, actionType)
    }
  }
}
