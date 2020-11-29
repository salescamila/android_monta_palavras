package com.example.monta_palavras.viewmodel

import androidx.lifecycle.ViewModel
import com.example.monta_palavras.model.repository.GameRepository

class GameViewModel () : ViewModel() {

    private val repository = GameRepository()

    fun montarPalavra(letras: String){
        // Montar combinações possíveis de palavras
    }

    private fun buscarPalavra(palavra: String) {
        // Buscar na base se palavra existe
    }

    private fun calcularValorPalavra(palavra: String) {
        // Calcular a pontuação da palavra passada
    }
}