package src.main.kotlin

import java.util.*

class FibonacciModulusHuge {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val n = scanner.nextLong()
            val m = scanner.nextLong()
            val c = getFibonacciModNew(n, m)
            println(c)
        }

        fun getFibonacciModNaive(n: Long, m: Long): Long {
            if (n <= 1)
                return n

            var previous = 0
            var current = 1

            for (i in 0 until n - 1) {
                val tmpPrevious = previous
                previous = current
                current += tmpPrevious
            }

            return current % m
        }

        private fun getFibonacciModNew(n: Long, m: Long): Long {
            val pisano = getPisanoPeriod(m)
            val h = n % pisano
            if (h <= 1)
                return h

            var previous = 0L
            var current = 1L

            for (i in 0 until h - 1) {
                val tmpPrevious = previous
                previous = current
                current = (current.toBigDecimal() + tmpPrevious.toBigDecimal()).longValueExact() % m
            }

            return current % m
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