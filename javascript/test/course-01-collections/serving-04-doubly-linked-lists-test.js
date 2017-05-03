"use strict";

// This serving will build on what you made in the last serving. A doubly linked
// list is the same as a linked list, except each node points to both the
// previous and the next node in the list. This collection is ideal for when you
// only want to interact with the first or last item of a collection.
//
// Feel free to copy any code you wrote for the LinkedList into the
// DoublyLinkedList, though you might need to add to the behavior. You will find
// the stub class in DoublyLinkedList.java along with further instructions.
//
// Diagram of a doubly linked list:
//
//             @size = 3
//
//             @head                         @tail
//               |                             |
//               v                             v
//             +---+ -- child --> +---+ ---> +---+ ---> null
//             | a |              | b |      | c |
//   null <--- +---+ <-- prev --- +---+ <--- +---+
//
suite("DoublyLinkedList");

test.skip("prepend exists", function() {
    assert.methodExists(DoublyLinkedList, "prepend", 1);
});

test.skip("prepend adds to the beginning", function() {
    var list = new DoublyLinkedList();
    list.prepend(42);
    assert.equal(list._head.value, 42);
    list.prepend(43);
    assert.equal(list._head.value, 43);
    assert.equal(list._head.child.value, 42);
    assert.isNull(list._head.child.child);
});

test.skip("prepend updates previous links", function() {
    var list = new DoublyLinkedList();
    assert.isNull(list._tail);
    list.prepend(42);
    assert.equal(list._tail.value, 42);
    list.prepend(43);
    assert.equal(list._tail.value, 42);
    assert.equal(list._tail.previous.value, 43);
    assert.isNull(list._tail.previous.previous);
});

test.skip("prepend increases the size", function() {
    var list = new DoublyLinkedList();
    list.prepend(42);
    assert.equal(list.size(), 1);
    list.prepend(43);
    assert.equal(list.size(), 2);
});

test.skip("prepend returns this so that it is chainable", function() {
    var list = new DoublyLinkedList();
    list.prepend(42).prepend(43);
    assert.equal(list._head.value, 43);
    assert.equal(list._head.child.value, 42);
    assert.isNull(list._head.child.child);
});

test.skip("prepend can be called a lot", function() {
    var list = new DoublyLinkedList();
    Kamayan.times(100, () => list.prepend(42));
    assert.equal(list.size(), 100);

    var node = list._head;
    Kamayan.times(100, () => {
        assert.equal(node.value, 42);
        node = node.child;
    });
});

test.skip("add exists", function() {
    assert.methodExists(DoublyLinkedList, "add", 1);
});

test.skip("add adds to the end", function() {
    var list = new DoublyLinkedList();
    list.add(42);
    assert.equal(list._head.value, 42);
    list.add(43);
    assert.equal(list._head.value, 42);
    assert.equal(list._head.child.value, 43);
    assert.isNull(list._head.child.child);
});

test.skip("add updates previous links", function() {
    var list = new DoublyLinkedList();
    assert.isNull(list._tail);
    list.add(42);
    assert.equal(list._tail.value, 42);
    list.add(43);
    assert.equal(list._tail.value, 43);
    assert.equal(list._tail.previous.value, 42);
    assert.isNull(list._tail.previous.previous);
});

test.skip("add increases the size", function() {
    var list = new DoublyLinkedList();
    list.add(42);
    assert.equal(list.size(), 1);
    list.add(43);
    assert.equal(list.size(), 2);
});

test.skip("add returns this so that it is chainable", function() {
    var list = new DoublyLinkedList();
    list.add(42).add(43);
    assert.equal(list._head.value, 42);
    assert.equal(list._head.child.value, 43);
    assert.isNull(list._head.child.child);
});

test.skip("add can be called a lot", function() {
    var list = new DoublyLinkedList();
    Kamayan.times(100, () => list.add(42));
    assert.equal(list.size(), 100);

    var node = list._head;
    Kamayan.times(100, () => {
        assert.equal(node.value, 42);
        node = node.child;
    });
});

test.skip("add and prepend are chainable together", function() {
    var list = new DoublyLinkedList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list._head.value, 1);
    assert.equal(list._head.child.value, 2);
    assert.equal(list._head.child.child.value, 42);
    assert.equal(list._head.child.child.child.value, 43);
    assert.isNull(list._head.child.child.child.child);
});

test.skip("chained add and prepend increases the size", function() {
    var list = new DoublyLinkedList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list.size(), 4);
});

test.skip("first exists", function() {
    assert.methodExists(DoublyLinkedList, "first", 0);
});

test.skip("first cannot be called on empty list", function() {
    var list = new DoublyLinkedList();
    assert.throws(IndexError, () => list.first());
});

test.skip("first returns the first element", function() {
    var list = new DoublyLinkedList().add(1);
    assert.equal(list.first(), 1);
    list.prepend(2);
    assert.equal(list.first(), 2);
    list.prepend(42);
    assert.equal(list.first(), 42);
    list.prepend(43);
    assert.equal(list.first(), 43);
});

test.skip("last exists", function() {
    assert.methodExists(DoublyLinkedList, "last", 0);
});

test.skip("last cannot be called on empty list", function() {
    var list = new DoublyLinkedList();
    assert.throws(IndexError, () => list.last());
});

test.skip("last returns the last element", function() {
    var list = new DoublyLinkedList().add(1);
    assert.equal(list.last(), 1);
    list.add(2);
    assert.equal(list.last(), 2);
    list.add(42);
    assert.equal(list.last(), 42);
    list.add(43);
    assert.equal(list.last(), 43);
});

test.skip("deleteFirst exists", function() {
    assert.methodExists(DoublyLinkedList, "deleteFirst", 0);
});

test.skip("deleteFirst cannot delete from an empty list", function() {
    var list = new DoublyLinkedList();
    assert.throws(IndexError, () => list.deleteFirst());
});

test.skip("deleteFirst removes the first element", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteFirst();
    assert.equal(list.first(), 2);
    list.deleteFirst();
    assert.equal(list.first(), 3);
});

test.skip("deleteFirst returns the deleted element", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    assert.equal(list.deleteFirst(), 1);
    assert.equal(list.deleteFirst(), 2);
    assert.equal(list.deleteFirst(), 3);
});

test.skip("deleteFirst updates the size", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteFirst();
    assert.equal(list.size(), 2);
    list.deleteFirst();
    assert.equal(list.size(), 1);
    list.deleteFirst();
    assert.equal(list.size(), 0);
});

test.skip("deleteFirst can be called a lot", function() {
    var list = new DoublyLinkedList();
    Kamayan.times(100, () => list.add(42));
    Kamayan.times(100, () => list.deleteFirst());
    assert.equal(list.size(), 0);
});

test.skip("deleteFirst updates child links", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteFirst();
    assert.equal(list._head.value, 2);
    assert.equal(list._head.child.value, 3);
    assert.isNull(list._head.child.child);

    list.deleteFirst();
    assert.equal(list._head.value, 3);
    assert.isNull(list._head.child);

    list.deleteFirst();
    assert.isNull(list._head);
});

test.skip("deleteFirst updates previous links", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteFirst();
    assert.equal(list._tail.value, 3);
    assert.equal(list._tail.previous.value, 2);
    assert.isNull(list._tail.previous.previous);

    list.deleteFirst();
    assert.equal(list._tail.value, 3);
    assert.isNull(list._tail.previous);

    list.deleteFirst();
    assert.isNull(list._tail);
});

test.skip("deleteLast exists", function() {
    assert.methodExists(DoublyLinkedList, "deleteLast", 0);
});

test.skip("deleteLast cannot delete from an empty list", function() {
    var list = new DoublyLinkedList();
    assert.throws(IndexError, () => list.deleteLast());
});

test.skip("deleteLast removes the last element", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteLast();
    assert.equal(list.last(), 2);
    list.deleteLast();
    assert.equal(list.last(), 1);
});

test.skip("deleteLast returns the deleted element", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    assert.equal(list.deleteLast(), 3);
    assert.equal(list.deleteLast(), 2);
    assert.equal(list.deleteLast(), 1);
});

test.skip("deleteLast updates the size", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteLast();
    assert.equal(list.size(), 2);
    list.deleteLast();
    assert.equal(list.size(), 1);
    list.deleteLast();
    assert.equal(list.size(), 0);
});

test.skip("deleteLast can be called a lot", function() {
    var list = new DoublyLinkedList();
    Kamayan.times(100, () => list.add(42));
    Kamayan.times(100, () => list.deleteLast());
    assert.equal(list.size(), 0);
});

test.skip("deleteLast updates child links", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteLast();
    assert.equal(list._head.value, 1);
    assert.equal(list._head.child.value, 2);
    assert.isNull(list._head.child.child);

    list.deleteLast();
    assert.equal(list._head.value, 1);
    assert.isNull(list._head.child);

    list.deleteLast();
    assert.isNull(list._head);
});

test.skip("deleteLast updates previous links", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(3);
    list.deleteLast();
    assert.equal(list._tail.value, 2);
    assert.equal(list._tail.previous.value, 1);
    assert.isNull(list._tail.previous.previous);

    list.deleteLast();
    assert.equal(list._tail.value, 1);
    assert.isNull(list._tail.previous);

    list.deleteLast();
    assert.isNull(list._tail);
});

test.skip("each exists", function() {
    assert.methodExists(DoublyLinkedList, "each", 0);
});

test.skip("each yields to nothing when the list is empty", function() {
    new DoublyLinkedList().each((element) => fail("Expected no yield!"));
});

test.skip("each yields to the elements in order", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(42).add(43);
    var actualElements = [];
    list.each((element) => actualElements.push(element));
    assert.equal(actualElements, [1, 2, 42, 43]);
});

test.skip("each returns this so it can be chained", function() {
    var list = new DoublyLinkedList();
    assert.equal(list.each((element) => { }), list);

    list.add(1).add(2).add(42).add(43);
    assert.equal(list.each((element) => { }), list);
});

test.skip("eachReversed exists", function() {
    assert.methodExists(DoublyLinkedList, "eachReversed", 0);
});

test.skip("eachReversed yields to nothing when the list is empty", function() {
    new DoublyLinkedList().eachReversed((element) => fail("Expected no yield!"));
});

test.skip("eachReversed yields to the elements in reverse order", function() {
    var list = new DoublyLinkedList().add(1).add(2).add(42).add(43);
    var actualElements = [];
    list.eachReversed((element) => actualElements.push(element));
    assert.equal(actualElements, [43, 42, 2, 1]);
});

test.skip("eachReversed returns this so it can be chained", function() {
    var list = new DoublyLinkedList();
    assert.equal(list.eachReversed((element) => { }), list);

    list.add(1).add(2).add(42).add(43);
    assert.equal(list.eachReversed((element) => { }), list);
});
