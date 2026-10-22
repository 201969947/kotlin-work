#!/usr/bin/env kotlin

fun median(values: List<Double>): Double {
if (values.isEmpty()) {
throw IllegalArgumentException("Median is undefined for an empty list")
}
val sorted = values.sorted()
val size = sorted.size
val mid = size / 2
return if (size % 2 == 1) {
sorted[mid]
} else {
(sorted[mid - 1] + sorted[mid]) / 2.0
}
}
