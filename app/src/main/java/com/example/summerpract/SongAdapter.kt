package com.example.summerpract

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpract.databinding.ItemSongBinding

class SongAdapter(
    private var list: List<Song>,
    private val glide: RequestManager,
) : RecyclerView.Adapter<SongItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongItem = SongItem(
        ItemSongBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide
    )

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SongItem, position: Int) {
        holder.onBind(list[position])
    }
}