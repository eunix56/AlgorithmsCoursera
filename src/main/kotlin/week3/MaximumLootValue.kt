package src.main.kotlin.week3

import java.util.*

object MaximumLootValue {

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        val n = scanner.nextInt()
        val capacity = scanner.nextInt()
        val values = IntArray(n)
        val weights = IntArray(n)
        for (i in 0 until n) {
            values[i] = scanner.nextInt()
            weights[i] = scanner.nextInt()
        }
        println(getOptimalValue(capacity, values, weights))
    }

    fun getOptimalValue(capacity: Int, values: IntArray, weights: IntArray): Double {
        //write your code here
        //u1+u2+u3+...+um < W, u1+u2+u3+...+um < wm
        //amount = min(W, wm)
        //value = values * amount/wm
        //capacity = capacity - amount
        //Scan through the array and get the greatest values. Compare their weights
        // to the capacity. If there is still space, move to the next value. If the
        //next value is greater than the weight, divide it by the remaining capacity
        //and compare with the next value. Is it greater or lower, compared with the
        //weight and capacity

        var value = 0.0

        if (capacity == 0) return 0.0

        return getMaximumLoot(capacity, values, weights, 0.0)
    }

    fun getMaximumLoot(capacity: Int, values: IntArray, weights: IntArray, value: Double): Double {
        val maxValue = values.maxOrNull()
        val maxIndex = maxValue?.let { values.indexOf(it) }
        var amount = 0
        var weight = capacity
        var result: Double = 0.0

        if (maxValue == null || maxIndex == -1) return 0.0

        while (weight > 0) {
            amount = weights[maxIndex!!].coerceAtMost(weight)
            result = maxValue * amount/weights[maxIndex].toDouble()

//            values.dropWhile { e -> e == maxIndex }
//            weights.dropWhile { e -> e == maxIndex }

            weight -= amount

            return getMaximumLoot(weight, values, weights, value + result)
        }

        return value + result
    }
}