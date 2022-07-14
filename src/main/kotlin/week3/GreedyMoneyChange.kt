package src.main.kotlin.week3

import java.util.*

object GreedyMoneyChange {

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val m = scanner.nextInt()
        println(getChange(m))

    }

    fun getChange(m: Int): Int {
        var amount = m
        val max = 10
        val secondMax = 5
        val thirdMax = 1
        var count = 0
        val value: IntArray = intArrayOf(8, 6, 9)
        value.maxOrNull()

        while (amount > 0) {
            if (amount >= max) {
                count++
                amount -= max
            } else if (amount >= secondMax) {
                count++
                amount -= secondMax
            } else if (amount >= thirdMax) {
                count++
                amount -= thirdMax
            }
        }
        return count
    }
}