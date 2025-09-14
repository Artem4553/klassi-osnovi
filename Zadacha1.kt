import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите координаты вершин треугольника:")
    val a = readPoint(scanner, "A") ?: return
    val b = readPoint(scanner, "B") ?: return
    val c = readPoint(scanner, "C") ?: return

    println("Введите координаты точки:")
    val p = readPoint(scanner, "P") ?: return

    val triangle = Triangle(a, b, c)

    val result = if (triangle.isPointInside(p)) {
        "Точка находится внутри треугольника."
    } else {
        "Точка находится вне треугольника."
    }

    println(result)
}

data class Point(val x: Double, val y: Double)

class Triangle(val a: Point, val b: Point, val c: Point) {

    fun area(): Double {
        return 0.5 * Math.abs((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y))
    }

    fun isPointInside(p: Point): Boolean {
        val areaABC = area()

        val areaPAB = Triangle(p, a, b).area()
        val areaPBC = Triangle(p, b, c).area()
        val areaPAC = Triangle(p, a, c).area()

        return Math.abs(areaABC - (areaPAB + areaPBC + areaPAC)) < 1e-6
    }
}

fun readPoint(scanner: Scanner, pointName: String): Point? {
    try {
        print("Введите координату X для точки $pointName: ")
        val x = scanner.nextLine().toDouble()
        print("Введите координату Y для точки $pointName: ")
        val y = scanner.nextLine().toDouble()
        return Point(x, y)
    } catch (e: NumberFormatException) {
        println("Ошибка: Введите числовые координаты для точки $pointName.")
        return null
    }
}