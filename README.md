# Monta Palavras

### Descrição da aplicação...
Busca, em um banco de palavras pré-definido, a palavra de maior pontuação e com menor caractéres possíveis que pode ser formada a partir de um conjunto de letras digitadas. Exibe a palavra formada, sua pontuação e as letras que não foram utilizadas.

### Como foi estruturado...
- Desenvolvido em Kotlin
- Arquitetura MVVM 
- Android Jetpack
   - Data Binding
   - Lifecycle

### Lógica implementada no jogo...
- Encontrar palavras correspondentes no banco de palavras
  - percorre as palavras do banco de palavras
    - converte para caixa alta as letras de entrada
    - remove acentuações e converte para caixa alta a palavra do banco
      - verifica, letra a letra, se o texto de entrada contem a letra da palavra do banco
      - caso positivo, armazena a letra encontrada numa variável temp
    - verifica se o tamanho da palavra do banco possui o mesmo tamanho da variável temp
    - caso positivo, adiciona palavra encontrada no set de palavrasFormadas
- Calcular a pontuação de cada palavra encontrada
  - percorre cada letra da palavra e recupera o seu valor correspondente
  - cria um Map com palavra e a soma do valor de cada letra
- Filtrar as palavras deixando apenas as de maior pontuação
- Validar critérios de desempate caso ocorra
  - retorna apenas uma palavra, sendo a de menor caractéres, e sua pontuação correpondente
- Verificar letras não utilizadas
  - percorre, letra a letra, a palavra encontrada do banco e vai removendo a letra correspondente do texto informado incialmente
- Caso pontuação maior que zero, retorna palavra encontrada, pontuação e letras que sobrarem
- Caso contrário, retorna que nenhuma palavra foi encontrada com as letras informadas

### Banco de palavras
"Abacaxi", "Manada", "mandar", "porta", "mesa", "Dado", "Mangas", "Já", "coisas", "radiografia",
"matemática", "Drogas", "prédios", "implementação", "computador", "balão", "Xícara", "Tédio",
"faixa", "Livro", "deixar", "superior", "Profissão", "Reunião", "Prédios", "Montanha", "Botânica",
"Banheiro", "Caixas", "Xingamento", "Infestação", "Cupim", "Premiada", "empanada", "Ratos",
"Ruído", "Antecedente", "Empresa", "Emissário", "Folga", "Fratura", "Goiaba", "Gratuito",
"Hídrico", "Homem", "Jantar", "Jogos", "Montagem", "Manual", "Nuvem", "Neve", "Operação",
"Ontem", "Pato", "Pé", "viagem", "Queijo", "Quarto", "Quintal", "Solto", "rota", "Selva",
"Tatuagem", "Tigre", "Uva", "Último", "Vitupério", "Voltagem", "Zangado", "Zombaria", "Dor"

### Valor das letras 
- 1 ponto: E, A, I, O, N, R, T, L, S, U
- 2 pontos: W, D, G
- 3 pontos: B, C, M, P
- 4 pontos: F, H, V
- 8 pontos: J, X
- 10 pontos: Q, Z
