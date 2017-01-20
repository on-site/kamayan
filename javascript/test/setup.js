function FillMeInError() {
    this.name = "FillMeInError";
    this.message = this.name;
    Error.captureStackTrace(this, FillMeInError);
}

global.__ = "FILL ME IN";
global.___ = FillMeInError;
global.assert = require("assert");
global.FillMeInError = FillMeInError;
global.FixedArray = require("../lib/fixed-array");
global.IndexError = require("../lib/index-error");
