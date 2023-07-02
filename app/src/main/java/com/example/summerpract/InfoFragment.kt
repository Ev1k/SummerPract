package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpract.databinding.FragmentInfoBinding
import com.google.android.material.snackbar.Snackbar

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.ALL)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)

        val result = arguments?.getInt("id")

        val listOfSongs = SongRepository.list
        var song: Song? = listOfSongs.find { it.id == result }

        binding.tvAuthor.text = "Author:" + song?.author
        binding.tvId.text = "ID:" + song?.id.toString()
        binding.tvName.text = "Name:" + song?.name
        binding.tvDesc.text = "Description:" + song?.desc

        Glide.with(this).load(song?.url?.toUri()).centerCrop().into(binding.ivImage)

        Snackbar.make(view, result.toString(), Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}