package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpract.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding!!.btnToSmileHome.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_coloredFragment,
                HomeFragment.createBundle(this.toString().split("{").first())
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        fun createBundle(result: String): Bundle {
            val bundle = Bundle()
            bundle.putString("key", result)
            return bundle
        }
    }
}
