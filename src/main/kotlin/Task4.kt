fun main() {
    println("Пересечение значений двух массивов и перенос их в третий")
    println("Введите два числовых массива:")

    val arr1: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()
    arr1.sort()
    val arr2: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()
    arr2.sort()

    val arr3: IntArray = arr1.filter { it in arr2 }.toIntArray()
    println("Результат: ${arr3.joinToString()}")
}