package com.example.summerpract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpract.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.button?.setOnClickListener {
            binding?.button?.text = getString(R.string.fffffffff)
        }
        binding?.btnToSmile?.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragmentPic_to_coloredFragment,
                HomeFragment.createBundle(this.toString().split("{").first())
            )
        }

        binding?.etLogin?.addTextChangedListener {
            if (!binding?.etLogin?.text.toString().isNullOrEmpty()) {
                binding?.tiLogin?.error = null
            } else {
                binding?.tiLogin?.error = getString(R.string.err)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
