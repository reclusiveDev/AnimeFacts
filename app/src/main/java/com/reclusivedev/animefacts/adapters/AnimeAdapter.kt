package com.reclusivedev.animefacts.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reclusivedev.animefacts.R
import com.reclusivedev.animefacts.models.Anime

class AnimeAdapter(private val context: Context, private val AnimeList: List<Anime>) :
    RecyclerView.Adapter<AnimeAdapter.AnimeVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeVH {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.anime_card, parent, false)
        return (AnimeVH(view))
    }

    override fun onBindViewHolder(holder: AnimeVH, position: Int) {
        val currentItem = AnimeList[position]

        Glide.with(context)
            .load(currentItem.image)
            .into(holder.image)

        holder.title.text = currentItem.title

    }

    override fun getItemCount(): Int {
        return AnimeList.size
    }

    class AnimeVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)

    }
}