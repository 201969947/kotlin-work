Copy `Stats.kt`, from your solution to Task 7.7.1, into the same directory
as this README file.

fun median(values: List<Double>): Double {

if (values.isEmpty()) {
throw IllegalArgumentException("Median is undefined for an empty list")
}

    val sorted = values.sorted()
    val size = sorted.size
    val midIndex = size / 2

    return if (size % 2 == 1) {
       
        sorted[midIndex]
    } else {
       
        (sorted[midIndex - 1] + sorted[midIndex]) / 2.0
    }
}


