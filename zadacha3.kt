import java.util.Scanner

class Poi(val x: Double, val y: Double) {

    fun distanceTo(other: Poi): Double {
        val dx = x - other.x
        val dy = y - other.y
        return Math.sqrt(dx * dx + dy * dy)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Введите количество точек (больше 2): ")
    val n = scanner.nextInt()

    if (n <= 2) {
        println("Количество точек должно быть больше 2.")
        return
    }

    val points = mutableListOf<Poi>()
    for (i in 1..n) {
        print("Введите координаты точки $i (x y): ")
        val x = scanner.nextDouble()
        val y = scanner.nextDouble()
        points.add(Poi(x, y))
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = 0.0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val distance = points[i].distanceTo(points[j])
            minDistance = Math.min(minDistance, distance)
            maxDistance = Math.max(maxDistance, distance)
        }
    }

    // Вывод результатов
    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}
