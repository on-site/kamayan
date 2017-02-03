"use strict";

// This serving is similar to the last, except instead of implementing an Array
// class in terms of FixedArray, you will be implementing it in terms of a
// series of links that form what is called a Linked List. You can find a stub
// of the class in lib/linked-list.js, while the tests here will help ensure you
// have implemented the core features.
//
// You may only use the nested Node class for storing the contents of the
// LinkedList. Do not be afraid to add new methods as you see fit, but keep any
// new methods private.
//
// Further instructions can be found inside the LinkedList class.
//
// Once you have finished implementing the LinkedList, contemplate the
// differences between the ArrayList and the LinkedList, and when you might use
// one versus the other... the pros and cons of the two.
//
// Diagram of a linked list:
//
//   @size = 3
//
//   @head
//     |
//     v
//   +---+              +---+      +---+
//   | a | -- child --> | b | ---> | c | ---> nil
//   +---+              +---+      +---+
//
suite("LinkedList");

test.skip("prepend exists", function() {
    assert.methodExists(LinkedList, "prepend", 1);
});

test.skip("prepend adds to the beginning", function() {
    var list = new LinkedList();
    list.prepend(42);
    assert.equal(list._head.value, 42);
    list.prepend(43);
    assert.equal(list._head.value, 43);
    assert.equal(list._head.child.value, 42);
    assert.isNull(list._head.child.child);
});

test.skip("prepend increases the size", function() {
    var list = new LinkedList();
    list.prepend(42);
    assert.equal(list.size(), 1);
    list.prepend(43);
    assert.equal(list.size(), 2);
});

test.skip("prepend returns this so that it is chainable", function() {
    var list = new LinkedList();
    list.prepend(42).prepend(43);
    assert.equal(list._head.value, 43);
    assert.equal(list._head.child.value, 42);
    assert.isNull(list._head.child.child);
});

test.skip("prepend can be called a lot", function() {
    var list = new LinkedList();
    Kamayan.times(100, () => { list.prepend(42); });
    assert.equal(list.size(), 100);

    var node = list._head;
    Kamayan.times(100, () => {
        assert.equal(node.value, 42);
        node = node.child;
    });
});

test.skip("add exists", function() {
    assert.methodExists(LinkedList, "add", 1);
});

test.skip("add adds to the end", function() {
    var list = new LinkedList();
    list.add(42);
    assert.equal(list._head.value, 42);
    list.add(43);
    assert.equal(list._head.value, 42);
    assert.equal(list._head.child.value, 43);
    assert.isNull(list._head.child.child);
});

test.skip("add increases the size", function() {
    var list = new LinkedList();
    list.add(42);
    assert.equal(list.size(), 1);
    list.add(43);
    assert.equal(list.size(), 2);
});

test.skip("add returns this so that it is chainable", function() {
    var list = new LinkedList();
    list.add(42).add(43);
    assert.equal(list._head.value, 42);
    assert.equal(list._head.child.value, 43);
    assert.isNull(list._head.child.child);
});

test.skip("add can be called a lot", function() {
    var list = new LinkedList();
    Kamayan.times(100, () => { list.add(42); });
    assert.equal(list.size(), 100);

    var node = list._head;
    Kamayan.times(100, () => {
        assert.equal(node.value, 42);
        node = node.child;
    });
});

test.skip("add and prepend are chainable together", function() {
    var list = new LinkedList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list._head.value, 1);
    assert.equal(list._head.child.value, 2);
    assert.equal(list._head.child.child.value, 42);
    assert.equal(list._head.child.child.child.value, 43);
    assert.isNull(list._head.child.child.child.child);
});

test.skip("chained add and prepend increases the size", function() {
    var list = new LinkedList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list.size(), 4);
});

test.skip("get exists", function() {
    assert.methodExists(LinkedList, "get", 1);
});

test.skip("get cannot go outside the bounds of the list", function() {
    var list = new LinkedList();
    assert.throws(() => { list.get(-1); }, IndexError);
    assert.throws(() => { list.get(-42); }, IndexError);
    assert.throws(() => { list.get(0); }, IndexError);
    assert.throws(() => { list.get(1); }, IndexError);
    list.add(1);
    list.get(0); // No error now that the index is valid
    assert.throws(() => { list.get(1); }, IndexError);
});

test.skip("get can retrieve any element", function() {
    var list = new LinkedList().add(1).add(2).add(42).add(43);
    assert.equal(list.get(0), 1);
    assert.equal(list.get(1), 2);
    assert.equal(list.get(2), 42);
    assert.equal(list.get(3), 43);
});

test.skip("set exists", function() {
    assert.methodExists(LinkedList, "set", 2);
});

test.skip("set cannot use negative number", function() {
    var list = new LinkedList();
    assert.throws(() => { list.set(-1, 1); }, IndexError);
    assert.throws(() => { list.set(-42, 1); }, IndexError);
    assert.equal(list.size(), 0);
});

test.skip("set can use existing indexes", function() {
    var list = new LinkedList().add(0).add(1).add(2).add(3);
    list.set(0, 1);
    list.set(1, 2);
    list.set(2, 3);
    list.set(3, 4);
    Kamayan.times(4, (i) => { assert.equal(list.get(i), i + 1); });
});

test.skip("set with existing indexes doesnt update the size", function() {
    var list = new LinkedList().add(0).add(1).add(2).add(3);
    list.set(0, 1);
    assert.equal(list.size(), 4);
    list.set(1, 2);
    assert.equal(list.size(), 4);
    list.set(2, 3);
    assert.equal(list.size(), 4);
    list.set(3, 4);
    assert.equal(list.size(), 4);
});

test.skip("set can add elements to the end of the list", function() {
    var list = new LinkedList();
    list.set(0, 1);
    list.set(1, 2);
    list.set(2, 3);
    list.set(3, 4);
    Kamayan.times(4, (i) => { assert.equal(list.get(i), i + 1); });
});

test.skip("set updates the size when adding to the end of the list", function() {
    var list = new LinkedList();
    list.set(0, 1);
    assert.equal(list.size(), 1);
    list.set(1, 2);
    assert.equal(list.size(), 2);
    list.set(2, 3);
    assert.equal(list.size(), 3);
    list.set(3, 4);
    assert.equal(list.size(), 4);
});

test.skip("set can use distant indexes", function() {
    var list = new LinkedList();
    list.set(42, 1);
    list.set(142, 2);
    list.set(1042, 3);
    Kamayan.range(0, 41, (i) => { assert.isNull(list.get(i)); });
    Kamayan.range(43, 141, (i) => { assert.isNull(list.get(i)); });
    Kamayan.range(143, 1041, (i) => { assert.isNull(list.get(i)); });
    assert.equal(list.get(42), 1);
    assert.equal(list.get(142), 2);
    assert.equal(list.get(1042), 3);
});

test.skip("set with distant indexes updates the size", function() {
    var list = new LinkedList();
    list.set(42, 1);
    assert.equal(list.size(), 43);
    list.set(142, 2);
    assert.equal(list.size(), 143);
    list.set(1042, 3);
    assert.equal(list.size(), 1043);
});

test.skip("set returns null if the previous value was null", function() {
    var list = new LinkedList().add(null);
    assert.isNull(list.set(0, 42));
});

test.skip("set returns null if the index is beyond the current size", function() {
    var list = new LinkedList();
    assert.isNull(list.set(0, 42));
    assert.isNull(list.set(42, 43));
});

test.skip("set returns the previous value", function() {
    var list = new LinkedList().add(1).add(2).add(3);
    assert.equal(list.set(0, 42), 1);
    assert.equal(list.set(0, 43), 42);
    assert.equal(list.set(1, 44), 2);
    assert.equal(list.set(2, 45), 3);
});

test.skip("delete exists", function() {
    assert.methodExists(LinkedList, "delete", 1);
});

test.skip("delete cannot delete outside the bounds of the linked list", function() {
    var list = new LinkedList().add(1).add(2).add(3);
    assert.throws(() => { list.delete(-1); }, IndexError);
    assert.throws(() => { list.delete(-42); }, IndexError);
    assert.throws(() => { list.delete(3); }, IndexError);
    assert.throws(() => { list.delete(42); }, IndexError);
});

test.skip("delete removes the element", function() {
    var list = new LinkedList().add(1).add(2).add(3);
    list.delete(1);
    assert.equal(list.get(0), 1);
    assert.equal(list.get(1), 3);
});

test.skip("delete returns the element at the index", function() {
    var list = new LinkedList().add(1).add(2).add(3);
    assert.equal(list.delete(0), 1);
    assert.equal(list.delete(1), 3);
    assert.equal(list.delete(0), 2);
});

test.skip("delete updates the size", function() {
    var list = new LinkedList().add(1).add(2).add(3);
    list.delete(1);
    assert.equal(list.size(), 2);
    list.delete(0);
    assert.equal(list.size(), 1);
    list.delete(0);
    assert.equal(list.size(), 0);
});

test.skip("delete can be called a lot", function() {
    var list = new LinkedList();
    Kamayan.times(100, () => { list.add(42); });
    Kamayan.times(100, () => { list.delete(0); });
    assert.equal(list.size(), 0);
});
