package edu.princeton.cs.algs4.leetcode

/**
 * @author TuFei
 * @date 18-11-15.
 */
class Stack<Item> : Iterable<Item> {

    data class Node<Item>(var next: Node<Item>?, var item: Item?)

    private var first: Node<Item>? = null
    private var n = 0

    fun push(item: Item) {
        val oldFirst = first
        val new = Node(oldFirst, item)
        first = new
        n++
    }

    fun pop(): Item {
        if (isEmpty()) throw NoSuchElementException("Stack underflow")
        val old = first
        first = old?.next
        n--
        return old!!.item!!
    }

    fun peek(): Item {
        if (isEmpty()) throw java.util.NoSuchElementException("Stack underflow")
        return first!!.item!!
    }

    fun isEmpty() = n == 0

    fun size() = n

    override fun iterator() = ListIterator()

    inner class ListIterator : Iterator<Item> {
        var current = first

        override fun hasNext() = current != null

        override fun next(): Item {
            if (!hasNext()) throw NoSuchElementException()
            val item = current!!.item!!
            current = current!!.next
            return item
        }
    }
}