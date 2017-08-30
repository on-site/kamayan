package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class Hash {
    private DoublyLinkedList[] hash;
    private int size;

    private static class Entry {
        private final Object key;
        private final Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    public Hash() {
        this.hash = new DoublyLinkedList[10];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Hash put(Object key, Object value) {
        throw Kamayan.todo(
        );
    }

    public Object get(Object key) {
        throw Kamayan.todo(
        );
    }

    public boolean contains(Object key) {
        throw Kamayan.todo(
        );
    }
}
