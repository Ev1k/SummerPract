package com.example.summerpract

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.summerpract.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var binding: FragmentListBinding? = null
    private var adapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        val name = arguments?.getString(this.toString())
        Log.e("ListFragment", name.orEmpty())

//        val pref: SharedPreferences = requireContext().getSharedPreferences("Default", MODE_PRIVATE)
//
//        requireContext().getColor(R.color.accent)

        initAdapter()

//        binding?.tvTitle?.setOnClickListener {
//            adapter?.updateDataset(
//                CityRepository.list.subList(0, Random.nextInt(8))
//            )
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = SongAdapter(
            list = SongRepository.list,
            glide = Glide.with(this),
//            onItemClick = { song ->
//                binding?.root?.showSnackbar(song.name)
//            }
        )
        binding?.rvSongs?.adapter = adapter
//        binding?.rvCity?.adapter = adapter
//        binding?.rvCity?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    companion object {
        fun createBundle(result: String): Bundle {
            val bundle = Bundle()
            bundle.putString("key", result)
            return bundle
        }
    }
}