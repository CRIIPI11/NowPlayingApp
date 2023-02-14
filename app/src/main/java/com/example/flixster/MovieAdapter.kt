package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment, parent, false)
        return MovieViewHolder(view)
    }
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var aitem: Movie? = null
        val atitle: TextView = mView.findViewById<View>(R.id.title) as TextView
        val adescription: TextView = mView.findViewById<View>(R.id.description) as TextView
        val aposter: ImageView = mView.findViewById<View>(R.id.poster) as ImageView

        override fun toString(): String {
            return atitle.toString() + " '"
        }
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.aitem = movie
        holder.atitle.text = movie.title
        holder.adescription.text = movie.description

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500"+movie.imageUrl)
            .centerInside()
            .into(holder.aposter)

        holder.mView.setOnClickListener {
            holder.aitem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}