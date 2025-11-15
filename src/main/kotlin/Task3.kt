fun main() {
    val alphabet = listOf(
        'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У', 'Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я'
    )
    val numbers = listOf(
        21,13,4,20,22,1,25,12,24,14,2,28,9,23,3,29,6,16,15,11,26,5,30,27,8,18,10,33,31,32,19,7,17
    )

    val numByLetter = alphabet.zip(numbers).toMap()
    val letterByNum = numbers.zip(alphabet).toMap()

    print("Введите режим (шифровать / дешифровать): ")
    val mode = readLine()?.trim()?.lowercase() ?: "шифровать"

    print("Введите текст: ")
    val text = readLine()?.trim()?.uppercase() ?: ""

    print("Введите ключевое слово: ")
    val key = readLine()?.trim()?.uppercase() ?: ""

    val result = encryptDecrypt(text, key, numByLetter, letterByNum, mode)

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
            result.append(ch) // если не русская буква
            continue
        }

        val shift = numByLetter[key[keyIndex % keyLen]] ?: 0
        val newNum = when (mode) {
            "шифровать" -> ((chNum + shift - 1) % 33) + 1
            "дешифровать" -> ((chNum - shift - 1 + 33 * 10) % 33) + 1 // +33*10 для избежания отрицательных
            else -> chNum
        }

        result.append(letterByNum[newNum])
        keyIndex++
    }

    return result.toString()
}
