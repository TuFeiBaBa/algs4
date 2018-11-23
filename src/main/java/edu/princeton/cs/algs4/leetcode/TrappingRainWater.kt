package edu.princeton.cs.algs4.leetcode

import edu.princeton.cs.algs4.Stack

/**
 * @author TuFei
 * @date 18-11-16.
 */
class TrappingRainWater {

    fun trap(heights: IntArray): Int {
        val stack = Stack<Int>()
        var sum = 0
        for (height in heights) {
            if (stack.isEmpty && height == 0) {
                continue
            }
            if (stack.size() < 2) {
                stack.push(height)
                continue
            }
            var temp = 0
            var distance = 0
            val iterator = stack.iterator()
            while (iterator.hasNext()) {
                val next = iterator.next()
                if (height <= next) {
                    sum += (height - temp) * distance
                    break
                }
                if (temp < next) {
                    sum += (next - temp) * distance
                    temp = next
                }
                distance++
            }
            stack.push(height)
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val trappingRainWater = TrappingRainWater()
    println(trappingRainWater.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}