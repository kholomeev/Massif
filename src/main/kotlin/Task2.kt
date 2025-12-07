fun task2() {
    var matrix: Array<IntArray>
    while (true) {
        try {
            println("Введите элементы в матрицу: ")
            println("Ввод осуществляется построчный.\n")
            matrix = Array(5) { IntArray(5) }
            for (i in 0 until 5) {
                print("${i+1} строка: ")
                val rowInput = readln().trim().split(" ").map { it.toInt() }

                for (j in 0 until rowInput.size) {
                    matrix[i][j] = rowInput[j]
                }
            }
            break
        }
        catch (e: NumberFormatException) {
            println("В вводимой строке были найдены символы, либо очень большое число. Попробуйте снова.")
        }
        catch (e: IndexOutOfBoundsException) {
            println("Количество элементов в строке меньше/больше количества столбцов (5). Попробуйте снова.")
        }
    }

    println("Двумерный массив:")
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            print(matrix[i][j].toString() + "\t")
        }
        println()
    }

    println(isMatrixSymmetric(matrix))
}

fun isMatrixSymmetric(matrix: Array<IntArray>): String {
    var symmetricCounter: Int = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (matrix[i][j] == matrix[j][i]) {
                if (i == j) continue
                symmetricCounter++
            }
        }
    }

    return if (symmetricCounter == 20) {
        "Массив симметричен относительно главной диагонали"
    }
    else {
        "Массив не симметричен относительно главной диагонали";
    }
}