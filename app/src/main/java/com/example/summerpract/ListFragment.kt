package com.example.summerpract

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.summerpract.databinding.FragmentListBinding
import com.example.summerpract.utils.showSnackbar

class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        val name = arguments?.getString(this.toString())
        Log.e("ListFragment", name.orEmpty())

        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {

        adapter = SongAdapter(
            list = SongRepository.list,
            glide = Glide.with(this),
            onItemClick = { song ->
                binding?.root?.showSnackbar(song.name)
                findNavController().navigate(
                    R.id.action_listFragment_to_infoFragment,
                    createBundle(song.id)
                )
            }
        )
        binding?.rvSongs?.adapter = adapter
    }

    companion object {

        fun createBundle(result: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt("id", result)
            return bundle
        }
    }
}