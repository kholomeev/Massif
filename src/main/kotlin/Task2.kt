fun main() {
    println("Введите элементы в матрицу: ")
    println("Ввод осуществляется построчный.\n")
    val matrix: Array<IntArray> = Array(5) {IntArray(5)}
    for (i in 0 until 5) {
        print("${i+1} строка: ")
        val rowInput = readln().trim().split(" ").map { it.toInt() }

        if (rowInput.size == 5) {
            for (j in 0 until 5) {
                matrix[i][j] = rowInput[j]
            }
        }
        else {
            println("Ошибка: количество элементов в строке не совпадает с количеством столбцов (5). Попробуйте снова.")
            return
        }
    }

    var symmetricCounter: Int = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (matrix[i][j] == matrix[j][i]) {
                if (i == j) continue
                symmetricCounter++
            }
        }
    }

    println("Двумерный массив:")
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            print(matrix[i][j].toString() + "\t")
        }
        println()
    }

    if (symmetricCounter == 20) {
        println("Массив симметричен относительно главной диагонали")
    }
}