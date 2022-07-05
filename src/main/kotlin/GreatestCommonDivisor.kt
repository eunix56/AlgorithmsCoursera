package src.main.kotlin

import java.util.*

class GreatestCommonDivisor {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val a = scanner.nextInt()
            val b = scanner.nextInt()

            println(gcdFast(a, b))
        }

        private fun gcdNaive(a: Int, b: Int): Int {
            var currentGcd = 1
            var d = 2
            while (d <= a && d <= b) {
                if (a % d == 0 && b % d == 0) {
                    if (d > currentGcd) {
                        currentGcd = d
                    }
                }
                ++d
            }

            return currentGcd
        }

        private fun gcdFast(a: Int, b: Int): Int {
            var div: Int

            if (a % b != 0) {
                div = a % b
            } else return b

            return gcdFast(b, div)
        }
    }
}