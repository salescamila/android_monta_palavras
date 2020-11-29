package com.example.monta_palavras.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.monta_palavras.R
import com.example.monta_palavras.databinding.ActivityMainBinding
import com.example.monta_palavras.viewmodel.GameViewModel
import com.example.monta_palavras.viewmodel.GameViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
        )
    }

    private val viewModel by lazy {
        ViewModelProvider(
                this,
                GameViewModelFactory()
        ).get(GameViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadBindingVariables()
//        val letras = findViewById<EditText>(R.id.edLetras)
//        val montar = findViewById<Button>(R.id.btMontar)
    }

    private fun loadBindingVariables() {
        binding.viewModel = viewModel
    }
}