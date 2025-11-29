fun main() {
    // Создать приложение, в котором пользователь дает на вход два числовых массива, числа в массиве могут повторяться.
    // На выходе приложение выдает пересечение этих массивов.
    // Например, на входе [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2, 2].
    // На выходе должны получить [1, 2, 2, 3].
    // То есть учитывается количество повторений чисел в массиве. Число 2 в одном массиве повторялось два раза, в другом - три.
    // Значит в итоговом массиве число два должно быть два раза

    // Ввод массивов
    println("Введите два числовых массива:")
    var arr1: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()
    var arr2: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()
    // Образование пересечения массивов
    arr1.sort() // 0 1 2 2 3
    arr2.sort() // 1 2 2 2 3 5 7
    // Формирование третьего массива
    var arr1Map: MutableMap<Int, Int> = mutableMapOf()
    for (num in arr1) {
        val count = arr1Map.getOrDefault(num, 0)
        arr1Map[num] = count + 1
    }
    var arr2Map: MutableMap<Int, Int> = mutableMapOf()
    for (num in arr2) {
        val count = arr2Map.getOrDefault(num, 0)
        arr2Map[num] = count + 1
    }
    //
    var arr3 = arr1Map.keys intersect arr2Map.keys
    print(arr3)
    var arr4 = arr1Map.entries intersect arr2Map.entries
    print(arr4)
    // Вывод массива

}