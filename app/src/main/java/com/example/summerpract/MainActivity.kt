package com.example.summerpract

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.summerpract.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)

        binding.button.setOnClickListener {
            binding.button.text = "fffffffff"
        }

        binding.etLogin.addTextChangedListener {
//            Log.e("etLogin", "Message: ${it?.toString()}")
            if (!binding.etLogin.text.toString().isNullOrEmpty()) {
                binding.tiLogin.error = null
            } else {
                binding.tiLogin.error = "ERROR"
            }
        }


    }
}