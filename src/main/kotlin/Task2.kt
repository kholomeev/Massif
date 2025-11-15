fun main() {
    // Имеется массив целых чисел из 5-и строк и 5-и столбцов. Выяснить, симметричен ли он относительно главной диагонали.
    // То есть - элемент 1,2 равен элементу 2,1.
    // Элемент 1,3 равен элементу 3,1 и т.д.
    // Например, массив внизу является симметричным относительно главной диагонали
    /*  (5)  9   6   7   2      // [0, 0-4]
         9  (8)  4   5   3      // [1, 0-4]
         6   4  (3)  8   7      // [2, 0-4]
         7   5   8  (4)  8      // [3, 0-4]
         2   3   7   8  (1)     // [4, 0-4]          */

    // Ввод массива
    val matrix: Array<IntArray> = Array(5) {IntArray(5)}
    for (i in 0 until 5) {
        val rowInput = readln().split(" ").map { it.toInt() }

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
    // Определение симметричности
    var symmetricCounter: Int = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (matrix[i][j] == matrix[j][i]) {
                if (i == j) continue
                symmetricCounter++
            }
        }
    }
    // Выводы
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