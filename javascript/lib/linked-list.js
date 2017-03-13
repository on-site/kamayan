"use strict";

var IndexError = require("./index-error");

function LinkedList() {
    this._head = null;
    this._size = 0;
}

// Use this nested class for storing the values of the LinkedList. Each
// LinkedList.Node contains the value at its index, and a link to the
// LinkedList.Node at the next index (called the "child" here). If the child is
// null, that denotes the last element of the LinkedList.
LinkedList.Node = function(value, child) {
    if (child === undefined) {
        child = null;
    }

    this.value = value;
    this.child = child;
};

LinkedList.prototype.size = function() {
    return this._size;
};

// Define a method "prepend" which takes a single argument. This method should
// prepend the argument to the beginning of this LinkedList and increase the
// size by 1. The return value must be this.

// Define a method "add" which takes a single argument. This method should
// append the argument to the end of this LinkedList and increase the size by
// 1. The return value must be this.

// Define a "delete" method which takes a single index argument. This method
// should delete the value at the provided index and return it. The size should
// be 1 less than it was before this method was called. The index must be within
// the bounds of the LinkedList, or an IndexError should be thrown.

// Define a method "get" which takes a single index argument. This method should
// retrieve the value at the given index. The index must be within the bounds of
// the LinkedList, or an IndexError should be thrown.

// Define a method "set" which takes 2 arguments. This method should set the
// value at the index defined in the first argument such that list.get(index)
// will return the second argument.
//
// If the index is negative, an IndexError should be thrown.
//
// If the index is bigger than the current size of the linked list, the links
// should be adjusted to fit the new index. All indexes between the former last
// element and the new index should be initialized with null.
//
// The size after this method is called depends on the index provided. An
// existing index would not affect the size, but an index greater than the last
// index will add the difference to the size.
//
// This method should return the value that was previously in the given index,
// or null if that does not apply.

LinkedList.prototype._checkBounds = function(index) {
    this._checkLowerBound(index);
    this._checkUpperBound(index);
};

LinkedList.prototype._checkLowerBound = function(index) {
    if (index < 0) {
        throw new IndexError("Invalid index: " + index);
    }
};

LinkedList.prototype._checkUpperBound = function(index) {
    if (index >= this.size()) {
        throw new IndexError("Invalid index: " + index);
    }
};

module.exports = LinkedList;
