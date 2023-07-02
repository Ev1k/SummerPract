package com.example.summerpract

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpract.databinding.ItemSongBinding

class SongItem(
    private val binding: ItemSongBinding,
    private val glide: RequestManager,
    private val onItemClick: (Song) -> Unit,
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    fun onBind(song: Song) {
        binding.run {
            tvTitle.text = song.name
            tvDesc.text = song.author

            glide.load(song.url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.error)
                .apply(options)
                .centerCrop().into(ivImage)

            root.setOnClickListener {
                onItemClick(song)
            }
        }
    }
}