package src.main.kotlin

import java.util.*

class LCM {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val a = scanner.nextInt()
            val b = scanner.nextInt()

            println(lcmNew(a, b))
        }

        fun lcmNaive(a: Int, b: Int): Long {
            for (l in 1..a.toLong() * b)
                if (l % a == 0L && l % b == 0L)
                    return l

            return a.toLong() * b
        }

        //The worst case scenario - mul a and b
        //Best case scenario - Get similar c in a and b,
        //then multiply a and b and divide by c to get lcm - 714552 374513
        private fun lcmNew(a: Int, b: Int): Long {
            return 0L
        }
    }
}