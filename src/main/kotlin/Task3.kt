fun task3() {
    val numByLetter: Map<Char, Int> = mapOf('А' to 21, 'Б' to 13, 'В' to 4, 'Г' to 20, 'Д' to 22, 'Е' to 1, 'Ё' to 25,
        'Ж' to 12, 'З' to 24, 'И' to 14, 'Й' to 2, 'К' to 28, 'Л' to 9, 'М' to 23, 'Н' to 3, 'О' to 29, 'П' to 6,
        'Р' to 16, 'С' to 15, 'Т' to 11, 'У' to 26, 'Ф' to 5, 'Х' to 30, 'Ц' to 27, 'Ч' to 8, 'Ш' to 18, 'Щ' to 10,
        'Ь' to 33, 'Ы' to 31, 'Ъ' to 32, 'Э' to 19, 'Ю' to 7, 'Я' to 17)
    val letterByNum: Map<Int, Char> = numByLetter.entries.associateBy({it.value}) {it.key}

    var mode: String
    var textL: String
    var keyL: String

    while (true) {
        print("Введите режим (1 - шифровать / 2 - дешифровать): ")
        mode = readln().trim()
        if (mode != "1" && mode != "2") {
            println("В введённой строке не указан режим работы программы.")
            continue
        }
        break
    }

    while (true) {
        print("Введите текст: ")
        val text = readln().trim().uppercase()

        textL = text.filter { it.isLetter() }
        if (textL.isEmpty()) {
            println("В введённой строке нет букв, либо она пустая.")
            continue
        }
        break
    }

    while (true) {
        print("Введите ключевое слово: ")
        val key = readln().trim().uppercase()

        keyL = key.filter { it.isLetter() }
        if (keyL.isEmpty()) {
            println("В введённой строке нет букв, либо она пустая.")
            continue
        }
        break
    }

    val result = encryptDecrypt(textL, keyL, numByLetter, letterByNum, mode)
    println("Результат: $result")
}

fun encryptDecrypt(
    text: String,
    key: String,
    numByLetter: Map<Char, Int>,
    letterByNum: Map<Int, Char>,
    mode: String
): String {
    val result = StringBuilder()
    var keyIndex = 0
    val keyLen = key.length

    for (ch in text) {
        val chNum = numByLetter[ch]
        if (chNum == null) {
            result.append(ch)
            continue
        }

        val shift = numByLetter[key[keyIndex % keyLen]] ?: 0
        val newNum = when (mode) {
            "1" -> ((chNum + shift - 1) % 33) + 1
            "2" -> ((chNum - shift - 1 + 33 * 10) % 33) + 1
            else -> chNum
        }

        result.append(letterByNum[newNum])
        keyIndex++
    }

    return result.toString()
}
