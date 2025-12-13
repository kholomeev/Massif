fun task1() {
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
            println(e.message)
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
            println(e.message)
        }
    }

    while (true) {
        try {
            matrix = Array(row) { IntArray(col) }
            for (i in 0 until row) {
                print("${i+1} строка: ")
                val rowInputMatrix = readln().trim().split(" ").map { it.toInt() }

                for (j in 0 until rowInputMatrix.size) {
                    if (rowInputMatrix[j] !in 100..999) {
                        throw Exception("Обнаружено не трёхзначное число.")
                    }

                    matrix[i][j] = rowInputMatrix[j]
                }
            }
            break
        }
        catch (e: NumberFormatException) {
            println("В вводимой строке были найдены символы, либо очень большое число. Попробуйте снова.")
            println(e.message)
        }
        catch (e: IndexOutOfBoundsException) {
            println("Количество элементов в строке меньше/больше количества столбцов ($col). Попробуйте снова.")
            println(e.message)
        }
        catch (e: Exception) {
            println(e.message)
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