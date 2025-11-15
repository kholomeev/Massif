/*
Создать программу, выполняющую следующий функционал:
- запрашивается количество строк и столбцов для двумерного массива
- вводится необходимое количество трехзначных чисел (числа могут повторяться)
- подсчитывается количество различных цифр в полученном массиве
- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
Например, для массива
100   951   101   950
519   999   155   501
510   911   144   554
выведется результат: В массиве использовано 5 различных цифр
 */
fun main() {
    print("Введите желаемую вами размерность двумерного массива: ")
    val arrSize = readln().trim()   // Записываем размерность матрицы
    if (arrSize.isEmpty()) {
        println("Размерность не указана.")
        return
    }

    // Разделяем входные данные на две переменные
    val arrSizeCl = arrSize.split(" ")
    if (arrSizeCl.size != 2) {
        println("Не все параметры размерности были указаны, или их больше, чем два.")
        return
    }
    val row = arrSizeCl[0].toInt()
    val col = arrSizeCl[1].toInt()

    // Генерация двумерного массива
    println("Введите $row строк(у/и) с $col элементами: ")
    val matrix = Array(row) { IntArray(col) }
    for (i in 0 until row) {
        val rowInput = readln().split(" ").map { it.toInt() }
        // Проверяем, совпадает ли количество введенных элементов с количеством столбцов
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

    // Количество различных цифр в матрице
    val diffDigits = mutableSetOf<Char>()
    for (row in matrix) {
        for (element in row) {
            element.toString()
                .filter { it.isDigit() }
                .forEach { diffDigits.add(it) }
        }
    }

    // Вывод на консоль
    println("Двумерный массив:")
    for (i in 0 until row) {
        for (j in 0 until col) {
            print(matrix[i][j].toString() + "\t\t")
        }
        println()
    }

    println("В массиве использовано $diffDigits различных цифр")
}