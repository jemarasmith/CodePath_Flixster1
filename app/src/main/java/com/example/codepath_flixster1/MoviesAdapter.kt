package com.example.codepath_flixster1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesAdapter(private val movies : List<Movies>,
                                  private val mListener: OnListFragment) : RecyclerView.Adapter<MoviesAdapter.MovieHolder>()
{
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.movies_rv, parent, false)
    return MovieHolder(view) }

  inner class  MovieHolder(val mView: View) : RecyclerView.ViewHolder(mView){
    var mItem : Movies ? =null
    val mMovieOverview: TextView = mView.findViewById(R.id.movie_description)
    val mMoviePoster: ImageView = mView.findViewById(R.id.movie_image)
    val mMovieTitle : TextView = mView.findViewById(R.id.movie_name)

  }

  override fun onBindViewHolder(holder: MovieHolder, position: Int) {
    val movie = movies[position]
    holder.mMovieTitle.text = movie.title
    holder.mMovieOverview.text = movie.overview

    Glide.with(holder.mView)
      .load(movie.posterpath)
      .centerInside()
      .into(holder.mMoviePoster)
    holder.mView.setOnClickListener {
      holder.mItem?.let { movie ->
        mListener.onItemClick(movie)
      }
    }
  }

  override fun getItemCount(): Int {
    return movies.size
  }
}
