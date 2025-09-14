class Tochk(val x: Double, val y: Double) {

    fun distanceTo(other: Tochk): Double {
        val dx = x - other.x
        val dy = y - other.y
        return Math.sqrt(dx * dx + dy * dy)
    }
}


fun main() {
    val Tochk1 = Tochk(1.0, 2.0)
    val Tochk2 = Tochk(4.0, 6.0)

    val distance = Tochk1.distanceTo(Tochk2)

    println("Расстояние между точками: $distance")
}
