fun main() {
    var row: Int
    var col: Int
    var matrix: Array<IntArray>

    while (true) {
        print("Введите количество строк в матрице: ")
        try {
            val rowInput = readln().trim()
            row = rowInput.toInt()
            break
        }
        catch (e: NumberFormatException) {
            println("Пустой ввод или было введено не число.")
        }
    }

    while (true) {
        print("Введите количество столбцов в матрице: ")
        try {
            val colInput = readln().trim()
            col = colInput.toInt()
            break
        }
        catch (e: NumberFormatException) {
            println("Пустой ввод или было введено не число.")
        }
    }

    while (true) {
        try {
            matrix = Array(row) { IntArray(col) }
            for (i in 0 until row) {
                print("${i+1} строка: ")
                val rowInputMatrix = readln().split(" ").map { it.toInt() }

                if (rowInputMatrix.size >= col) {
                    for (j in 0 until col) {
                        matrix[i][j] = rowInputMatrix[j]
                    }
                }
                else {
                    println("Количество элементов в строке больше количества столбцов ($col). Программа завершена.")
                    return
                }
            }
            break
        }
        catch (e: NumberFormatException) {
            println("В вводимой строке были найдены символы, либо очень большое число. Попробуйте снова.")
        }
        catch (e: IndexOutOfBoundsException) {
            println("Количество элементов в строке меньше количества столбцов ($col). Попробуйте снова.")
        }

    }

    println("Двумерный массив:")
    for (i in 0 until row) {
        for (j in 0 until col) {
            print(matrix[i][j].toString() + "\t\t")
        }
        println()
    }

    println("В массиве использовано ${diffDigits(matrix)} различных цифр")
}

fun diffDigits(matrix: Array<IntArray>): Int {
    val diffDigits = mutableSetOf<Char>()
    for (row in matrix) {
        for (element in row) {
            element.toString().filter { it.isDigit() }.forEach { diffDigits.add(it) }
        }
    }

    return diffDigits.size
}