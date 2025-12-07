fun task5() {
    var words: List<String>
    var wordsOnly: List<String>

    while (true) {
        println("Сортировка слов по похожим буквам. Символы, не являющиеся буквами, будут удалены.")
        print("Введите несколько слов: ")

        words = readln().split(" ")

        wordsOnly = words.map { it.filter { ch -> ch.isLetter() }}
        wordsOnly.sorted()

        break
    }

    val groups = groupByUniqueLetters(wordsOnly)
    groups.forEach { (key, value) ->
        println("$value")
    }
}

fun groupByUniqueLetters(words: List<String>): Map<Set<Char>, List<String>> {
    return words.groupBy { word ->
        word.lowercase().filter { !it.isWhitespace() }.toSet()
    }
}