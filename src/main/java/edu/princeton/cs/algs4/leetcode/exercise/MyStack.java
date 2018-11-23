package edu.princeton.cs.algs4.leetcode.exercise;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author TuFei
 * @date 18-11-23.
 */
public class MyStack<Item> implements Iterable<Item> {

    private class Node<Item> {
        private Node<Item> next;
        private Item item;
    }

    private Node<Item> first;
    private int i;

    public void push(Item item) {
        Node<Item> old = this.first;
        Node<Item> node = new Node<>();
        node.next = old;
        node.item = item;
        first = node;
        i++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        i--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    public int size() {
        return i;
    }

    public boolean isEmpty() {
        return i == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
