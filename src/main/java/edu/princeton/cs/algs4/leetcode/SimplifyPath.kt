package edu.princeton.cs.algs4.leetcode

/**
 * @author TuFei
 * @date 18-11-22.
 */
class SimplifyPath {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        var temp = ""
        for (c in path) {
            if (temp.isEmpty()) {
                temp += c
                continue
            }
            if (c == '/') {
                when (temp) {
                    "/." -> temp = c.toString()
                    "/" -> {
                        if (!stack.isEmpty()) {
                            stack.pop()
                        }
                        temp = c.toString()
                    }
                    "/" -> {

                    }
                    else -> {
                        stack.push(temp)
                        temp = c.toString()
                    }
                }
            } else {
                temp += c
            }
        }
        if (temp == "/" && !stack.isEmpty()) {
            stack.pop()
        }
        if (temp != "/" && temp != "/." && temp != "/") {
            stack.push(temp)
        }
        return if (stack.isEmpty()) {
            "/"
        } else {
            var result: String = ""
            while (!stack.isEmpty()) {
                result = stack.pop() + result
            }
            return result
        }
    }
}

fun main(args: Array<String>) {
    val path = SimplifyPath()
    println(path.simplifyPath("/../"))
    println(path.simplifyPath("/a/./b/../../c/"))
    println(path.simplifyPath("/home//foo/"))
    println(path.simplifyPath("/.../"))
    println(path.simplifyPath("/."))
    println(path.simplifyPath("/"))
    println(path.simplifyPath("/..."))
    println(path.simplifyPath("/.../.."))//"/"
    println(path.simplifyPath("/.../."))
}