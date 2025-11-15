fun main() {
    /* Создать приложение, в котором пользователь вводит массив из различных слов.
       На выходе приложение должно показать слова сгруппированные по признаку "состоят из одинаковых букв".
       Например, на входе ["eat", "tea", "tan", "ate", "nat", "bat"].

       Получаем группы:
       "ate", "eat", "tea"
       "nat", "tan"
       "bat"           */

    // Ввод массива
    print("Введите несколько слов на английском: ")
    var words: List<String> = readln().split(" ")
    words = words.sorted()
    // Деление на группы и считывание слов
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