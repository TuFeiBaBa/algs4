package edu.princeton.cs.algs4.leetcode.exercise

import edu.princeton.cs.algs4.leetcode.Stack

/**
 * 1.记录遇到的第一个非0数x，将其入栈。将min = x
 * 2.检查栈是否为空。不为空，查看栈顶的值。
 *       1.如果遇到比它小或者相等的y，压入栈。min = y。重走2。
 *       2.如果遇到比它大的y
 *           1.如果栈的大小为1，弹出栈顶的值。sum+=（y-min）distance重走2。distance = 0。
 *           2.如果栈的大小大于等于2，将栈顶的值弹出，distance++。查看栈顶的新值z，
 *               1.大于y，sum +=(y-min)*distance，min=y，。重走2.2
 *               2.小于或者等于y，sum+=(z-min)*distance,min=z,。弹出栈顶的值。重走2.2
 * 3.到了数组末尾。sum即所求值。
 * @author TuFei
 * @date 18-11-16.
 */
class TrappingRainWater {

    fun trap(height: Array<Int>): Int {
        var sum = 0
        var distance = 0
        var min = 0
        val stack = Stack<Int>()
        for (i in height) {
            if (stack.isEmpty() && i == 0) continue
            if (stack.isEmpty()) {
                stack.push(i)
                min = i
            } else {
                val top = stack.peek()
                if (top >= i) {
                    stack.push(i)
                    min = i
                } else {
                    while (stack.ListIterator().hasNext()) {
                        if (stack.size() == 1) {
                            val top = stack.peek()
                            if (top >= i) {
                                sum += (i - min) * distance
                            } else {
                                stack.pop()
                                stack.push(i)
                                sum += (top - min) * distance
                            }
                            distance = 0
                            min = 0
                            break
                        } else {
                            stack.pop()
                            distance++
                            val top = stack.peek()
                            if (top >= i) {
                                sum += (i - min) * distance
                                min = i
                            } else {
                                sum += (top - min) * distance
                                min = top
                                stack.pop()
                                if(stack.isEmpty()){
                                    stack.push(i)
                                    distance = 0
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum
    }
}

fun main(args: Array<String>) {
    val trappingRainWater = TrappingRainWater()
    println(trappingRainWater.trap(arrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))

}