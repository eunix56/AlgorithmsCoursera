package src.main.kotlin.week2

import java.util.*

class FibonacciLastDigit {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val n = scanner.nextLong()
            val c = getFibonacciLastDigitNaive(n)
            println(c)
        }

        fun getFibonacciLastDigitNaive(n: Long): Long {
            if (n <= 1)
                return n

            var next: Long
            var previous = 0L
            var current = 1L

            for (i in 0 until n - 1) {
                next = previous + current
                previous = current
                current = next
            }

            return current
        }

        fun getFibonacciLastDigitNew(n: Int): Int {
            if (n <= 1)
                return n

            var previous = 0
            var current = 1

            for (i in 0 until n - 1) {
                val tmpPrevious = previous
                previous = current
                current = (current.toBigDecimal() + tmpPrevious.toBigDecimal()).intValueExact() % 10
            }

            return current
        }


        fun getFibonacciLastDigitFast(n: Int): Int {
            if (n <= 1)
                return n

            val arr = IntArray(n + 1)
            arr[0] = 0
            arr[1] = 1

            for (i in 2 .. n) {
                arr[i] = (arr[i-1].toBigDecimal() + arr[i-2].toBigDecimal()).intValueExact() % 10
            }

            return arr[n]

        }

        //getFibonacci
        fun getFibonacciFast(n: Int): Long {
            if (n <= 1)
                return n.toLong()

            val arr = LongArray(n + 1)
            arr[0] = 0
            arr[1] = 1

            for (i in 2 .. n) {
                arr[i] = (arr[i-1].toBigDecimal() + arr[i-2].toBigDecimal()).longValueExact()
            }

            return arr[n]

        }
    }
}