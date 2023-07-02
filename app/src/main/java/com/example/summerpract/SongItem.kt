package com.example.summerpract

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.summerpract.databinding.ItemSongBinding

class SongItem(
    private val binding: ItemSongBinding,
    private val glide: RequestManager,
) : ViewHolder(binding.root) {

    fun onBind(song: Song) {
        binding.run {
            tvTitle.text = song.author
            tvDesc.text = song.name

            glide.load(song.url).into(ivImage)
        }
    }
}