fun main() {
    var arr1: IntArray
    var arr2: IntArray

    println("Пересечение значений двух массивов и перенос их в третий")

    while (true) {
        try {
            print("Введите 1 числовой массив: ")
            arr1 = readln().split(" ").map { it.toInt() }.toIntArray()
            arr1.sort()
            break
        }
        catch (e: NumberFormatException) {
            println(e.message)
        }
    }

    while (true) {
        try {
            print("Введите 2 числовой массив: ")
            arr2 = readln().split(" ").map { it.toInt() }.toIntArray()
            arr2.sort()
            break
        }
        catch (e: NumberFormatException) {
            println(e.message)
        }
    }

    val arr3: IntArray = arr1.filter { it in arr2 }.toIntArray()
    println("Результат: ${arr3.joinToString()}")
}