"use strict";

var IndexError = require("./index-error");

function FixedArray(size) {
    this._array = new Array(size);
    this._array.fill(null);
}

FixedArray.prototype.get = function(index) {
    this._checkBounds(index);
    return this._array[index];
};

FixedArray.prototype.set = function(index, value) {
    this._checkBounds(index);
    this._array[index] = value;
};

FixedArray.prototype.size = function() {
    return this._array.length;
};

FixedArray.prototype._checkBounds = function(index) {
    if (index < 0 || index >= this.size()) {
        throw new IndexError("Invalid index: " + index);
    }
};

module.exports = FixedArray;
