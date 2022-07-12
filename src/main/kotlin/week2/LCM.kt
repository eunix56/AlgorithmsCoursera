package src.main.kotlin.week2

import java.util.*

class LCM {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val scanner = Scanner(System.`in`)
            val a = scanner.nextInt()
            val b = scanner.nextInt()

            println(lcmFaster(a, b))
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

        fun lcmFaster(a: Int, b: Int): Long {
            val q: Long
            val r: Long

            if (a > b) {
                q = a.toLong()
                r = b.toLong()
            }
            else {
                q = b.toLong()
                r = a.toLong()
            }


            return if (q % r == 0L)
                q
            else {
                (q * r)/ getRemainder(q, r)
            }
        }


        fun getRemainder(a: Long, b: Long): Long {
            val rem = a % b

            return if (a % rem == 0L && b % rem == 0L)
                rem
            else getRemainder (b, rem)
        }
    }
}