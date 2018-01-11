package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

import java.util.function.Consumer;

public class TreeSet<T extends Comparable<?>> {
    private int size = 0;
    private Node root;

    private class Node {
        final T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

    public TreeSet<T> add(T object) {
        throw Kamayan.todo(
        );
    }

    public TreeSet<T> remove(T object) {
        throw Kamayan.todo(
        );
    }

    public boolean contains(T object) {
        throw Kamayan.todo(
        );
    }

    public TreeSet<T> each(Consumer<T> block) {
        throw Kamayan.todo(
        );
    }
}
