package edu.princeton.cs.algs4.leetcode

/**
 * @author TuFei
 * @date 18-11-15.
 */
class ValidBrackets {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '{' || it == '[' || it == '(') {
                stack.push(it)
            } else {
                if (stack.isEmpty()) return false
                val c = stack.pop()
                if ((it == '}' && c != '{')
                        || (it == ']' && c != '[')
                        || (it == ')' && c != '(')) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    val validBrackets = ValidBrackets()
    println(validBrackets.isValid("{{{}}}"))
    println(validBrackets.isValid("{{{}}}}}"))
    println(validBrackets.isValid("{{{{{{{{{}}}}}"))
    println(validBrackets.isValid("[]{}(){[[]()]}"))
    println(validBrackets.isValid("[]{}(){[[(])]}"))
}