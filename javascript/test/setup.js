"use strict";

function FillMeInError() {
    this.name = "FillMeInError";
    this.message = this.name;
    Error.captureStackTrace(this, FillMeInError);
}

var assert = require("assert");

assert.isNull = function(object) {
    assert.equal(null, object);
};

assert.methodExists = function(type, method, arity) {
    assert.equal("function", typeof(type.prototype[method]), "Expected " + type.name + "." + method + " to be a function");
    assert.equal(arity, type.prototype[method].length, "Expected " + type.name + "." + method + ".length == " + arity);
};

global.__ = "FILL ME IN";
global.___ = FillMeInError;
global.ArrayList = require("../lib/array-list");
global.assert = assert;
global.Kamayan = require("../lib/kamayan");
global.FillMeInError = FillMeInError;
global.FixedArray = require("../lib/fixed-array");
global.IndexError = require("../lib/index-error");
