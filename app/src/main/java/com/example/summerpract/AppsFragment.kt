package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.summerpract.databinding.FragmentAppsBinding

class AppsFragment : Fragment(R.layout.fragment_apps) {
    private var binding: FragmentAppsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAppsBinding.bind(view)

        binding!!.btnToSmileApps.setOnClickListener {
            findNavController().navigate(
                R.id.action_appsFragment_to_coloredFragment,
                HomeFragment.createBundle(this.toString().split("{").first())
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}