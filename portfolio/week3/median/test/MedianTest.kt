// COMP2850 Portfolio: Week 3 // Tests for median()
import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.doubles.plusOrMinus

const val tolerance = 0.000001

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf<Double>())
        }
    }


    "Median of 1-element list is correct" {
        median(listOf(8.0)) shouldBe (8.0 plusOrMinus tolerance)
    }


    "Median of 2-element list is correct" {
        median(listOf(3.0, 7.0)) shouldBe (5.0 plusOrMinus tolerance)
    }


    "Median of 3-element list is correct" {
        median(listOf(1.0, 4.0, 9.0)) shouldBe (4.0 plusOrMinus tolerance)
    }


    "Median of 4-element list is correct" {
        median(listOf(1.0, 2.0, 6.0, 9.0)) shouldBe (4.0 plusOrMinus tolerance)
    }
})
