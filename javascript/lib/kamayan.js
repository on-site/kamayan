"use strict";

var Kamayan = {
    times: function(n, fn) {
        return this.range(0, n - 1, fn);
    },

    range: function(start, end, fn) {
        for (var i = start; i <= end; i++) {
            fn(i);
        }
    }
};

module.exports = Kamayan;
