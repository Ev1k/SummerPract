package com.example.summerpract

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.summerpract.databinding.ItemSongBinding

class SongAdapter : RecyclerView.Adapter<SongItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongItem = SongItem(
        ItemSongBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SongItem, position: Int) {
        TODO("Not yet implemented")
    }
}