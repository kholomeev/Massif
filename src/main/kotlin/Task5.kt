fun main() {
    print("Введите несколько слов на английском: ")
    var words: List<String> = readln().split(" ")
    words = words.sorted()

    val groups = groupByUniqueLetters(words)
    groups.forEach { (key, value) ->
        println("$value")
    }
}

fun groupByUniqueLetters(words: List<String>): Map<Set<Char>, List<String>> {
    return words.groupBy { word ->
        word.lowercase().filter { !it.isWhitespace() }.toSet()
    }
}