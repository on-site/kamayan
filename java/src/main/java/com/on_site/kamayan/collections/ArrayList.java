package com.on_site.kamayan.collections;

import com.on_site.kamayan.Kamayan;

public class ArrayList {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        checkBounds(index);
        return array[index];
    }

    public ArrayList add(Object value) {
        throw Kamayan.todo(
            "The add(Object) method should append the argument to the end of",
            "this ArrayList and increase the size by 1. The return value must",
            "be this."
        );
    }

    public ArrayList prepend(Object value) {
        throw Kamayan.todo(
            "The prepend(Object) method should prepend the argument to the",
            "beginning of this ArrayList and increase the size by 1. The",
            "return value must be this."
        );
    }

    public Object delete(int index) {
        throw Kamayan.todo(
            "The delete(int) method should delete the value at the provided",
            "index and return it. The size should be 1 less than it was before",
            "this method was called. The index must be within the bounds of",
            "the ArrayList, or an IndexError should be thrown."
        );
    }

    public Object set(int index, Object value) {
        throw Kamayan.todo(
            "The set(int, Object) method should set the value at the index",
            "defined in the first argument such that list.get(index) will",
            "return the second argument.",
            "",
            "If the index is negative, an IndexOutOfBoundsException should be",
            "thrown.",
            "",
            "If the index is bigger than the current size of the internal",
            "array, the internal array should be replaced with a bigger array",
            "to fit the new index. All indexes between the former last element",
            "and the new index should be initialized with null. An additional",
            "buffer should be included in the new array (in case the array is",
            "grown more), though this is not required.",
            "",
            "The size after this method is called depends on the index",
            "provided. An existing index would not affect the size, but an",
            "index greater than the last index will add the difference to the",
            "size.",
            "",
            "This method should return the value that was previously in the",
            "given index, or null if that does not apply."
        );
    }

    private void checkBounds(int index) {
        checkLowerBound(index);
        checkUpperBound(index);
    }

    private void checkLowerBound(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkUpperBound(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
}
