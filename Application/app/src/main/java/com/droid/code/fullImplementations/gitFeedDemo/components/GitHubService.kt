package com.droid.code.fullImplementations.gitFeedDemo.components

import io.reactivex.rxjava3.core.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface GitHubApi {

  companion object {
    fun create(): GitHubApi {

      val logging = HttpLoggingInterceptor()
      logging.level = HttpLoggingInterceptor.Level.BODY

      val client = OkHttpClient.Builder()
          .addInterceptor(logging)
          .build()

      val retrofit = Retrofit.Builder()
          .client(client)
          .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl("https://api.github.com/")
          .build()

      return retrofit.create(GitHubApi::class.java)
    }
  }

  @GET("repos/ReactiveX/{repo}/events")
  fun fetchEvents(@Path("repo") repo: String, @Header("If-Modified-Since") lastModified: String)
      : Observable<Response<List<AnyDict>>>
}
