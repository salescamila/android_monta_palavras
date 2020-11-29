package com.example.monta_palavras.model.repository

class GameRepository {

    var wordBank = setOf<String>(
        "Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", "radiografia",
        "matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", "Tédio",
        "faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", "Botânica",
        "Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
        "Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
        "Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
        "Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
        "Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor",
        //"nada", "meu", "lado"
    )

    var pointsPerLetter = mapOf<Char, Int>('A' to 1,
        'B' to 3,
        'C' to 3,
        'D' to 2,
        'E' to 1,
        'F' to 4,
        'G' to 2,
        'H' to 4,
        'I' to 1,
        'J' to 8,
        'K' to 0,
        'L' to 1,
        'M' to 3,
        'N' to 1,
        'O' to 1,
        'P' to 3,
        'Q' to 10,
        'R' to 1,
        'S' to 1,
        'T' to 1,
        'U' to 1,
        'V' to 4,
        'W' to 2,
        'X' to 8,
        'Y' to 0,
        'Z' to 10
    )

}