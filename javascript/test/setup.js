"use strict";

function FillMeInError() {
    this.name = "FillMeInError";
    this.message = this.name;
    Error.captureStackTrace(this, FillMeInError);
}

var assert = require("assert");

assert.isNull = function(object) {
    assert.strictEqual(null, object);
};

assert.methodExists = function(type, method, arity) {
    assert.equal("function", typeof(type.prototype[method]), "Expected " + type.name + "." + method + " to be a function");
    assert.equal(arity, type.prototype[method].length, "Expected " + type.name + "." + method + ".length == " + arity);
};

// assert.throws is allowing too many things to pass, so we are going to change
// it to just what we need it to do.
assert.throws = function(fn, expected) {
    var thrown = false;

    try {
        fn.call();
    } catch (e) {
        thrown = true;

        if (e.constructor != expected) {
            assert.fail(e.constructor.name, expected.name, "Expected exception of type " + expected.name + ", but got " + e.constructor.name + " instead");
        }
    }

    if (!thrown) {
        assert.fail("<nothing was raised>", expected.name, "Expected exception of type " + expected.name + ", but nothing was thrown");
    }
};

global.__ = "FILL ME IN";
global.___ = FillMeInError;
global.ArrayList = require("../lib/array-list");
global.assert = assert;
global.DoublyLinkedList = require("../lib/doubly-linked-list");
global.FillMeInError = FillMeInError;
global.FixedArray = require("../lib/fixed-array");
global.IndexError = require("../lib/index-error");
global.Kamayan = require("../lib/kamayan");
global.LinkedList = require("../lib/linked-list");
