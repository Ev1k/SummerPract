package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpract.databinding.FragmentMessageBinding

class MessageFragment : Fragment(R.layout.fragment_message) {
    private var binding: FragmentMessageBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMessageBinding.bind(view)

        binding?.btnToSmileMessage?.setOnClickListener {
            findNavController().navigate(
                R.id.action_messageFragment_to_coloredFragment,
                HomeFragment.createBundle(this.toString().split("{").first())
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}