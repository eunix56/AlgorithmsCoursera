package src.main.kotlin.week2

import java.util.*
import kotlin.math.abs

class FibonacciSquareSumLastDigit {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val n = scanner.nextLong()

            println(getSquareSumLastDigit(n))
        }

        private fun getSquareSumLastDigit(n: Long): Long {
            val squareSum = getFibonacciValue(n) * getFibonacciValue(n + 1)
            return squareSum % 10
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


        private fun getFibonacciModNew(n: Long): Long {
            val pisano = getPisanoPeriod(60)
            val h: Long = (n+2) % pisano

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
    }
}