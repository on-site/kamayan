"use strict";

function IndexError(message) {
    this.name = "IndexError";
    this.message = message || "";
    Error.captureStackTrace(this, FillMeInError);
}

module.exports = IndexError;
