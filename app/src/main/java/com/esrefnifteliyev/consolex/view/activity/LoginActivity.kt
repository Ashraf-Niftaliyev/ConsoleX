package com.esrefnifteliyev.consolex.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esrefnifteliyev.consolex.R
import com.esrefnifteliyev.consolex.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}