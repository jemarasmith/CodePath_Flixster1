package com.example.codepath_flixster1

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

class Movies(title: String,poster_path : String, overview: String) {
  @SerializedName("title")
  var title = title
  @SerializedName("poster_path")
  var posterpath = "https://image.tmdb.org/t/p/w342/$poster_path"
  @SerializedName("overview")
  var overview = overview

}
