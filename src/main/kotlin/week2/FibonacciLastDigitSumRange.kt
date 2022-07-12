package src.main.kotlin.week2

import java.util.*
import kotlin.math.abs

class FibonacciLastDigitSumRange {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val m = scanner.nextLong()
            val n = scanner.nextLong()

            println(sumFibonacciDigitsRange(m,n))
        }

        fun sumFibonacciDigits(m: Long, n: Long): Long {
            var count = 0L

            for (i in m .. n) {
                count += getFibonacciModNew(i)
            }

            return count % 10
        }

        fun sumFibonacciDigitsRange(m: Long, n: Long): Long {
            if (n <= 1)
                return n
            val nVal = if (getFibonacciModNew(n) == 0L) 10L else getFibonacciModNew(n)
            val mVal = if (m <= 0) m else getFibonacciPrevValue(m + 1)
            val mSum = if (m != n) nVal - mVal
            else getFibonacciValue(m)

            if (mSum % 10 < 0)
                return 10L + (mSum % 10)
            return mSum % 10
        }

        private fun getFibonacciPrevValue(n: Long): Long {
            val pisano = getPisanoPeriod(60)
            val h = n % pisano
            if (h <= 1)
                return h

            var next: Long
            var previous = 0L
            var current = 1L

            for (i in 0 until h - 1) {
                next = (previous + current) % pisano
                previous = current
                current = next
            }


            return abs(current - 1) % 10
        }

        private fun getFibonacciValue(n: Long): Long {
            val pisano = getPisanoPeriod(60)
            val h = n % pisano
            if (h <= 1)
                return h

            var next: Long
            var previous = 0L
            var current = 1L

            for (i in 0 until h - 1) {
                next = (previous + current) % pisano
                previous = current
                current = next
            }


            return current % 10
        }


        private fun getFibonacciModNew(n: Long): Long {
            val pisano = getPisanoPeriod(60)
            val h = (n + 2) % pisano
            if (h <= 1)
                return h

            var next: Long
            var previous = 0L
            var current = 1L

            for (i in 0 until h - 1) {
                next = (previous + current) % pisano
                previous = current
                current = next
            }

            return abs(current - 1) % 10
        }

        private fun getPisanoPeriod(m: Long): Long {
            var a = 0L
            var b = 1L
            var c: Long
            var value = 0L

            for (i in 0 until m * m) {
                c = (a + b) % m
                a = b
                b = c
                if (a == 0L && b == 1L)
                    value = i + 1
            }

            return value
        }
    }
}