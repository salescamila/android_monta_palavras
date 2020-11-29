package com.example.monta_palavras.util

import java.text.Normalizer
import java.util.regex.Pattern
import kotlin.String as KotlinString

class Helper {
    private var wordBank = setOf<KotlinString>(
            "Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", "radiografia",
            "matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", "Tédio",
            "faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", "Botânica",
            "Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
            "Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
            "Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
            "Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
            "Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor"
    )

    private var pointsPerLetter = mapOf<KotlinString, Int>("A" to 1,
            "B" to 3,
            "C" to 3,
            "D" to 2,
            "E" to 1,
            "F" to 4,
            "G" to 2,
            "H" to 4,
            "I" to 1,
            "J" to 8,
            "K" to 0,
            "L" to 0,
            "M" to 3,
            "N" to 0,
            "O" to 1,
            "P" to 3,
            "Q" to 10,
            "R" to 0,
            "S" to 0,
            "T" to 0,
            "U" to 1,
            "V" to 4,
            "W" to 2,
            "X" to 8,
            "Y" to 0,
            "Z" to 10
    )

    fun getWordPoints(word: KotlinString): Int {
        val total: Int = 0

        // calculate word points

        for (letter in word) {
            println(letter + " = " + pointsPerLetter[letter])
            // total += (pointsPerLetter[letter]?.toInt())
        }

        return total
    }

    fun removerAcentos(str: KotlinString?): KotlinString {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replace("[^\\p{ASCII}]", "")
    }

    fun deAccent(str: KotlinString?): KotlinString? {
        val nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD)
        val pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        return pattern.matcher(nfdNormalizedString).replaceAll("")
    }
}