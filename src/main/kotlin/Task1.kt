fun main() {
    val row: Int
    val col: Int
    val matrix: Array<IntArray>

    while (true) {
        print("Введите количество строк в матрице: ")
        val rowInput = readln().trim()
        if (rowInput.isEmpty()) {
            println("Количество строк не указано.")
            continue
        }
        row = rowInput.toInt()
        break
    }

    while (true) {
        print("Введите количество столбцов в матрице: ")
        val colInput = readln().trim()
        if (colInput.isEmpty()) {
            println("Количество столбцов не указано.")
            continue
        }
        col = colInput.toInt()
        break
    }

    while (true) {
        println("Введите $row строк(и) с $col элементами: ")
        matrix = Array(row) { IntArray(col) }
        for (i in 0 until row) {
            val rowInputMatrix = readln().split(" ").map { it.toInt() }

            if (rowInputMatrix.size == col) {
                for (j in 0 until col) {
                    matrix[i][j] = rowInputMatrix[j]
                }
            }
            else {
                println("Ошибка: количество элементов в строке не совпадает с количеством столбцов ($col). Попробуйте снова.")
                continue
            }
        }
        break
    }

    val diffDigits = mutableSetOf<Char>()
    for (row in matrix) {
        for (element in row) {
            element.toString().filter { it.isDigit() }.forEach { diffDigits.add(it) }
        }
    }

    println("Двумерный массив:")
    for (i in 0 until row) {
        for (j in 0 until col) {
            print(matrix[i][j].toString() + "\t\t")
        }
        println()
    }

    println("В массиве использовано ${diffDigits.size} различных цифр")
}