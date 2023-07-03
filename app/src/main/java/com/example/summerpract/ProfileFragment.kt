package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpract.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var binding: FragmentProfileBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding?.btnToSmileProfile?.setOnClickListener {
            findNavController().navigate(
                R.id.action_profileFragment_to_coloredFragment,
                HomeFragment.createBundle(this.toString().split("{").first())
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}