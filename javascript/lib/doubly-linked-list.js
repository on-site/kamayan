"use strict";

var IndexError = require("./index-error");

function DoublyLinkedList() {
    this._head = null;
    this._size = 0;
}

// Use this nested class for storing the values of the DoublyLinkedList. Each
// DoublyLinkedList.Node contains the value at its index, and a link to the
// DoublyLinkedList.Node at the next index (called the "child" here) and at the
// previous index (called "previous"). If the child is null, that denotes the
// last element of the DoublyLinkedList, while a null previous denotes the
// first.
DoublyLinkedList.Node = function(value, previous, child) {
    if (previous === undefined) {
        previous = null;
    }

    if (child === undefined) {
        child = null;
    }

    this.value = value;
    this.previous = previous;
    this.child = child;
};

DoublyLinkedList.prototype.size = function() {
    return this._size;
};

// Define a method "prepend" which takes a single argument. This method should
// prepend the argument to the beginning of this DoublyLinkedList and increase the
// size by 1. The return value must be this.

// Define a method "add" which takes a single argument. This method should
// append the argument to the end of this DoublyLinkedList and increase the size by
// 1. The return value must be this.

// Define a "first" method which takes no arguments. This method should return
// the value of that item. An IndexError should be thrown if the list is empty.

// Define a "last" method which takes no arguments. This method should return
// the value of that item. An IndexError should be thrown if the list is empty.

// Define a "deleteFirst" method which takes no arguments. This method should
// delete the first item in the list and return the value of that item. The size
// must be reduced by 1. An IndexError should be thrown if the list is empty.

// Define a "deleteLast" method which takes no arguments. This method should
// delete the last item in the list and return the value of that item. The size
// must be reduced by 1. An IndexError should be thrown if the list is empty.

// Define an "each" method which takes a single function argument. The function
// is called with each element in the list, in order. The return value must be
// this.

// Define an "eachReversed" method which takes a single function argument. The
// function is called with each element in the list, in reverse order. The
// return value must be this.

DoublyLinkedList.prototype._checkBounds = function(index) {
    this._checkLowerBound(index);
    this._checkUpperBound(index);
};

DoublyLinkedList.prototype._checkLowerBound = function(index) {
    if (index < 0) {
        throw new IndexError("Invalid index: " + index);
    }
};

DoublyLinkedList.prototype._checkUpperBound = function(index) {
    if (index >= this.size()) {
        throw new IndexError("Invalid index: " + index);
    }
};

module.exports = DoublyLinkedList;
