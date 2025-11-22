fun main() {
    print("Введите желаемую вами размерность двумерного массива: ")
    val arrSize = readln().trim()
    if (arrSize.isEmpty()) {
        println("Размерность не указана.")
        return
    }

    val arrSizeCl = arrSize.split(" ")
    if (arrSizeCl.size != 2) {
        println("Не все параметры размерности были указаны, или их больше, чем два.")
        return
    }
    val row = arrSizeCl[0].toInt()
    val col = arrSizeCl[1].toInt()

    println("Введите $row строк(и) с $col элементами: ")
    val matrix = Array(row) { IntArray(col) }
    for (i in 0 until row) {
        val rowInput = readln().split(" ").map { it.toInt() }

        if (rowInput.size == col) {
            for (j in 0 until col) {
                matrix[i][j] = rowInput[j]
            }
        }
        else {
            println("Ошибка: количество элементов в строке не совпадает с количеством столбцов ($col). Попробуйте снова.")
            return
        }
    }

    val diffDigits = mutableSetOf<Char>()
    for (row in matrix) {
        for (element in row) {
            element.toString()
                .filter { it.isDigit() }
                .forEach { diffDigits.add(it) }
        }
    }

    println("Двумерный массив:")
    for (i in 0 until row) {
        for (j in 0 until col) {
            print(matrix[i][j].toString() + "\t\t")
        }
        println()
    }

    println("В массиве использовано $diffDigits различных цифр")
}