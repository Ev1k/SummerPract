package com.example.summerpract

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.summerpract.databinding.ItemSongBinding

class SongItem(
    private val binding: ItemSongBinding
) : ViewHolder(binding.root) {

    fun onBind(song: Song) {
        binding.run {
            tvTitle.text = song.author
            tvDesc.text = song.name
        }
    }
}