fun groupByUniqueLetters(words: List<String>): Map<Set<Char>, List<String>> {
    return words.groupBy { word ->
        word.lowercase().filter { !it.isWhitespace() }.toSet()
    }
}

fun main() {
    val words = listOf("eat", "tea", "ate", "read", "dear", "dare", "hello")
    val groups = groupByUniqueLetters(words)
    groups.forEach { (key, value) ->
        println("$key -> $value")
    }
}