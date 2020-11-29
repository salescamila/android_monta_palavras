package com.example.monta_palavras.viewmodel

import androidx.lifecycle.ViewModel
import com.example.monta_palavras.model.repository.GameRepository
import java.text.Normalizer
import java.util.regex.Pattern

class GameViewModel () : ViewModel() {

    private val repository = GameRepository()
    val wordBank = repository.wordBank
    val pointsPerLetter = repository.pointsPerLetter

    /*
    * Lógica do jogo Montar Palavras
    *
    *  - Encontrar palavras correspondentes no banco de palavras
    *  -- percorre as palavras do banco de palavras
    *  --- converte para caixa alta as letras de entrada
    *  --- remove acentuações e converte para caixa alta a palavra do banco
    *  ---- verifica, letra a letra, se o texto de entrada contem a letra da palavra do banco
    *  ---- caso positivo, armazena a letra encontrada numa variável temp
    *  --- verifica se o tamanho da palavra do banco possui o mesmo tamanho da variável temp
    *  --- caso positivo, adiciona palavra encontrada no set de palavrasFormadas
    *  - Calcular a pontuação de cada palavra encontrada
    *  -- percorre cada letra da palavra e recupera o seu valor correspondente
    *  -- cria um Map com palavra e a soma do valor de cada letra
    *  - Filtrar as palavras deixando apenas as de maior pontuação
    *  - Validar critérios de desempate caso ocorra
    *  -- retorna apenas uma palavra, sendo a de menor caractéres, e sua pontuação correpondente
    *  - Verificar letras não utilizadas
    *  -- percorre, letra a letra, a palavra encontrada do banco e
    *     vai removendo a letra correspondente do texto informado incialmente
    *  - Caso pontuação maior que zero, retorna palavra encontrada, pontuação e letras que sobrarem
    *  - Caso contrário, retorna que nenhuma palavra foi encontrada com as letras informadas
    *
    * */
    fun montarPalavra(letras_input: String): String{
        // Verificar palavras formadas conforme banco de palavras
        var palavrasFormadas = buscarPalavras(letras_input)

        // Calcular pontuação para cada palavra formada
        val palavrasPontuadas = palavrasFormadas.map{
            Pair(it, getWordPoints(it))
        }.toMap()

        // Filtrar palavras de maior pontuação
        var maiorValor = 0
        palavrasPontuadas.map{
            if (it.value > maiorValor)
                maiorValor = it.value
        }
        var palavrasParaDesempate = palavrasPontuadas.filter { it.value == maiorValor }

        // Validar critérios de desempate caso ocorra
        var pontos = 0
        var menorPalavra = letras_input+letras_input
        palavrasParaDesempate.map {
            if (it.key.length < menorPalavra.length) {
                menorPalavra = it.key
                pontos = it.value
            }
        }

        // Verificar letras não utilizadas
        var letrasSobrando = letras_input.toUpperCase()
        for (letra in menorPalavra)
            if (letrasSobrando.contains(letra))
                letrasSobrando = letrasSobrando.substring(0, letrasSobrando.indexOf(letra)) + letrasSobrando.substring(letrasSobrando.indexOf(letra)+1)

        if (pontos > 0)
            return "Palavra de ${pontos} pontos\n${menorPalavra}\n\nSobraram:\n${letrasSobrando}"
        else
            return "Nenhuma palavra encontrada com as letras\n\n ${letras_input.toUpperCase()}"
    }

    // Retorna um set com as formações de palavras possíveis
    fun buscarPalavras(input_letras: kotlin.String): MutableSet<kotlin.String> {
        var palavrasFormadas = mutableSetOf("")

        for (word in wordBank) {
            var input = input_letras.toUpperCase()
            var cleanWord = tratarPalavra(word)
            var temp = ""

            for (letra in cleanWord) {
                if (input.contains(letra)) {
                    temp +=  letra
                    input = input.substring(0, input.indexOf(letra)) + input.substring(input.indexOf(letra)+1)
                }
            }

            if (cleanWord.length == temp.length)
                palavrasFormadas.add(cleanWord)
        }

        palavrasFormadas.remove("")

        return palavrasFormadas
    }

    // Calcula pontuação da palavra
    fun getWordPoints(palavra: String): Int {
        var total: Int = 0

        for (letra in palavra) {
            total += pointsPerLetter.getOrDefault(letra, 0)
        }

        return total
    }

    // Remove caractéres especiais e coloca todas as letras em caixa alta
    fun tratarPalavra(str: String): String {
        val nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD)
        val pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase()
    }
}