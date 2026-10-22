Copy `Triangles.kt`, from your Portfolio Week 2 solution, into the same
directory as this README file.
import kotlin.math.sqrt

typealias Triangle = Triple<Double, Double, Double>

fun isValidTriangle(triangle: Triangle): Boolean {
val (a, b, c) = triangle
return a < b + c && b < a + c && c < a + b
}

fun triangleArea(triangle: Triangle): Double {
if (!isValidTriangle(triangle)) {
throw IllegalArgumentException(
"Invalid triangle: sides $triangle do not satisfy the triangle inequality"
)
}
val (a, b, c) = triangle
val s = (a + b + c) / 2.0
return sqrt(s * (s - a) * (s - b) * (s - c))
}
