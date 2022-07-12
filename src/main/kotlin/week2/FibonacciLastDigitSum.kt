package src.main.kotlin.week2

import java.util.*
import kotlin.math.abs

class FibonacciLastDigitSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val n = scanner.nextLong()

            println(getFibonacciModNew(n))
        }

        //Brute force solution
        fun sumFibonacciDigits(n: Long): Long {
            if (n <= 1)
                return n

            var count = 0L

            for (i in 0 .. n) {
                count += getFibonacciLastDigitNew(i)
            }

            return count % 10
        }

        fun getFibonacciLastDigitNew(n: Long): Long {
            if (n <= 1)
                return n

            var previous = 0L
            var current = 1L

            for (i in 0 until n - 1) {
                val tmpPrevious = previous
                previous = current
                current = (current.toBigDecimal() + tmpPrevious.toBigDecimal()).longValueExact() % 10
            }

            return current
        }

        fun getFibonacciLastDigitFast(n: Long): Long {
            if (n <= 1)
                return n

            val arr = LongArray(3)
            var next: Long
            arr[0] = 0L
            arr[1] = 1L


            for (i in 2 until n + 3) {
                arr[2] = arr[0] + arr[1]
                arr[0] = arr[1]
                arr[1] = arr[2] % 10
            }

            if (arr[1] == 0L)
                return 1
            return arr[1]
        }

        //Faster solution
        fun getFibonacciSumFast(n: Long): Long {
            if (n <= 1)
                return n

            val arr = LongArray((n + 3).toInt())
            arr[0] = 0
            arr[1] = 1

            for (i in 2 .. n + 2) {
                arr[i.toInt()] = (arr[(i-1).toInt()].toBigDecimal()
                        + arr[(i-2).toInt()].toBigDecimal()).longValueExact() % 10
            }

            if (arr[(n + 2).toInt()] == 0L) return 1
            return (arr[(n + 2).toInt()] - 1) % 10

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