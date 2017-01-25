"use strict";

// For this serving, you will be implementing your own version of the Array
// class. You can find a stub of the class in lib/array-list.js, while the tests
// here will help ensure you have implemented the core features.
//
// You may only use the FixedArray class for storing the contents of the
// ArrayList. Do not be afraid to add new methods as you see fit, but keep any
// new methods private (since JavaScript doesn't have a real private mechanism,
// you can accomplish this with the convention of prefixing the method with an
// underscore, like _privateMethod).
//
// Starting with this serving, all tests are skipped. You must delete the .skip
// call on each test as you are ready to run it.
//
// Further instructions can be found inside the ArrayList class.
//
// Diagram of an array list as it grows:
//
//   @size = 3
//
//   +---+---+---+---+---+---+---+---+---+---+
//   | a | b | c |   |   |   |   |   |   |   |
//   +---+---+---+---+---+---+---+---+---+---+
//
//
//   @size = 9
//
//   +---+---+---+---+---+---+---+---+---+---+
//   | a | b | c | d | e | f | g | h | i |   |
//   +---+---+---+---+---+---+---+---+---+---+
//
//
//   @size = 12
//
//   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
//   | a | b | c | d | e | f | g | h | i | j | k | l |   |   |   |   |   |   |   |   |
//   +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
//
suite("ArrayList");

test.skip("add exists", function() {
    assert.methodExists(ArrayList, "add", 1);
});

test.skip("add increases the size", function() {
    var list = new ArrayList();
    list.add(42);
    assert.equal(list.size(), 1);
    list.add(43);
    assert.equal(list.size(), 2);
});

test.skip("add adds to the end", function() {
    var list = new ArrayList();
    list.add(42);
    list.add(43);
    assert.equal(list.get(0), 42);
    assert.equal(list.get(1), 43);
});

test.skip("add returns self so that it is chainable", function() {
    var list = new ArrayList();
    list.add(42).add(43);
    assert.equal(list.get(0), 42);
    assert.equal(list.get(1), 43);
});

test.skip("prepend exists", function() {
    assert.methodExists(ArrayList, "prepend", 1);
});

test.skip("prepend increases the size", function() {
    var list = new ArrayList();
    list.prepend(42);
    assert.equal(list.size(), 1);
    list.prepend(43);
    assert.equal(list.size(), 2);
});

test.skip("prepend adds to the beginning", function() {
    var list = new ArrayList();
    list.prepend(42);
    list.prepend(43);
    assert.equal(list.get(0), 43);
    assert.equal(list.get(1), 42);
});

test.skip("prepend returns self so that it is chainable", function() {
    var list = new ArrayList();
    list.prepend(42).prepend(43);
    assert.equal(list.get(0), 43);
    assert.equal(list.get(1), 42);
});

test.skip("add and prepend are chainable together", function() {
    var list = new ArrayList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list.get(0), 1);
    assert.equal(list.get(1), 2);
    assert.equal(list.get(2), 42);
    assert.equal(list.get(3), 43);
});

test.skip("chained add and prepend increases the size", function() {
    var list = new ArrayList();
    list.add(42).add(43).prepend(2).prepend(1);
    assert.equal(list.size(), 4);
});

test.skip("add can be called a lot", function() {
    var list = new ArrayList();
    Kamayan.times(100, () => { list.add(42); });
    assert.equal(list.size(), 100);
    Kamayan.times(100, (i) => { assert.equal(list.get(i), 42); });
});

test.skip("prepend can be called a lot", function() {
    var list = new ArrayList();
    Kamayan.times(100, () => { list.prepend(42); });
    assert.equal(list.size(), 100);
    Kamayan.times(100, (i) => { assert.equal(list.get(i), 42); });
});

test.skip("index get cannot go outside the bounds of the array", function() {
    var list = new ArrayList();
    assert.throws(() => { list.get(-1); }, IndexError);
    assert.throws(() => { list.get(-42); }, IndexError);
    assert.throws(() => { list.get(0); }, IndexError);
    assert.throws(() => { list.get(1); }, IndexError);
    list.add(1);
    list.get(0); // No error now that the index is valid
    assert.throws(() => { list.get(1); }, IndexError);
});

test.skip("index get can retrieve any element", function() {
    var list = new ArrayList().add(1).add(2).add(42).add(43);
    assert.equal(list.get(0), 1);
    assert.equal(list.get(1), 2);
    assert.equal(list.get(2), 42);
    assert.equal(list.get(3), 43);
});

test.skip("index set exists", function() {
    assert.methodExists(ArrayList, "set", 2);
});

test.skip("index set cannot use negative number", function() {
    var list = new ArrayList();
    assert.throws(() => { list.set(-1, 1); }, IndexError);
    assert.throws(() => { list.set(-42, 1); }, IndexError);
    assert.equal(list.size(), 0);
});

test.skip("index set can use existing indexes", function() {
    var list = new ArrayList().add(0).add(1).add(2).add(3);
    list.set(0, 1);
    list.set(1, 2);
    list.set(2, 3);
    list.set(3, 4);
    Kamayan.times(4, (i) => { assert.equal(list.get(i), i + 1); });
});

test.skip("index set can add elements to the end of the list", function() {
    var list = new ArrayList();
    list.set(0, 1);
    list.set(1, 2);
    list.set(2, 3);
    list.set(3, 4);
    Kamayan.times(4, (i) => { assert.equal(list.get(i), i + 1); });
});

test.skip("index set can use distant indexes", function() {
    var list = new ArrayList();
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

test.skip("index set with the next available index updates the size", function() {
    var list = new ArrayList();
    list.set(0, 1);
    assert.equal(list.size(), 1);
    list.set(1, 2);
    assert.equal(list.size(), 2);
    list.set(2, 3);
    assert.equal(list.size(), 3);
    list.set(3, 4);
    assert.equal(list.size(), 4);
});

test.skip("index set with existing indexes doesnt update the size", function() {
    var list = new ArrayList().add(0).add(1).add(2).add(3);
    list.set(0, 1);
    assert.equal(list.size(), 4);
    list.set(1, 2);
    assert.equal(list.size(), 4);
    list.set(2, 3);
    assert.equal(list.size(), 4);
    list.set(3, 4);
    assert.equal(list.size(), 4);
});

test.skip("index set with distant indexes updates the size", function() {
    var list = new ArrayList();
    list.set(42, 1);
    assert.equal(list.size(), 43);
    list.set(142, 2);
    assert.equal(list.size(), 143);
    list.set(1042, 3);
    assert.equal(list.size(), 1043);
});

test.skip("set returns null if the previous value was null", function() {
    var list = new ArrayList().add(null);
    assert.isNull(list.set(0, 42));
});

test.skip("set returns null if the index is beyond the current size", function() {
    var list = new ArrayList();
    assert.isNull(list.set(0, 42));
    assert.isNull(list.set(42, 43));
});

test.skip("set returns the previous value", function() {
    var list = new ArrayList().add(1).add(2).add(3);
    assert.equal(list.set(0, 42), 1);
    assert.equal(list.set(0, 43), 42);
    assert.equal(list.set(1, 44), 2);
    assert.equal(list.set(2, 45), 3);
});

test.skip("delete exists", function() {
    assert.methodExists(ArrayList, "delete", 1);
});

test.skip("delete cannot delete outside the bounds of the array list", function() {
    var list = new ArrayList().add(1).add(2).add(3);
    assert.throws(() => { list.delete(-1); }, IndexError);
    assert.throws(() => { list.delete(-42); }, IndexError);
    assert.throws(() => { list.delete(3); }, IndexError);
    assert.throws(() => { list.delete(42); }, IndexError);
});

test.skip("delete removes the element", function() {
    var list = new ArrayList().add(1).add(2).add(3);
    list.delete(1);
    assert.equal(list.get(0), 1);
    assert.equal(list.get(1), 3);
});

test.skip("delete updates the size", function() {
    var list = new ArrayList().add(1).add(2).add(3);
    list.delete(1);
    assert.equal(list.size(), 2);
    list.delete(0);
    assert.equal(list.size(), 1);
    list.delete(0);
    assert.equal(list.size(), 0);
});

test.skip("delete returns the element at the index", function() {
    var list = new ArrayList().add(1).add(2).add(3);
    assert.equal(list.delete(0), 1);
    assert.equal(list.delete(1), 3);
    assert.equal(list.delete(0), 2);
});

test.skip("delete can be called a lot", function() {
    var list = new ArrayList();
    Kamayan.times(100, () => { list.add(42); });
    Kamayan.times(100, () => { list.delete(0); });
    assert.equal(list.size(), 0);
});

test.skip("delete can delete from a full array", function() {
    var list = new ArrayList();
    var internalArray = list._array;
    list._size = internalArray.size();
    Kamayan.times(internalArray.size(), (i) => { internalArray.set(i, 42); });
    assert.equal(list.delete(5), 42);
    assert.equal(list.size(), 9);
});

test.skip("delete doesnt leave deleted elements in the array", function() {
    var list = new ArrayList();
    var internalArray = list._array;
    list._size = internalArray.size();
    Kamayan.times(internalArray.size(), (i) => { internalArray.set(i, 42); });
    assert.equal(list.delete(5), 42);
    assert.equal(list.size(), 9);
    assert.isNull(list._array.get(9));
});
