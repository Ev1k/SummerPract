package com.example.summerpract

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.summerpract.databinding.FragmentColoredBinding
import com.google.android.material.snackbar.Snackbar


class ColoredFragment : Fragment(R.layout.fragment_colored) {

    private var binding: FragmentColoredBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColoredBinding.bind(view)

        val result = arguments?.getString("key")
        Snackbar.make(view, result.toString(), Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}