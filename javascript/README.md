# JavaScript Kamayan

## Setup

Before you can start, you need to [install Node.js](https://nodejs.org/en/download/).
You might be able to use a package manager to install it easier (such as `brew`
for MacOS or `apt-get` for Ubuntu). Finally, run `npm install` from within this
same directory.

## Running the JavaScript Kamayan

Once the setup is complete, you just need to run `npm test`. This will run all
the tests, showing you which ones have failed.

After you have completed the first serving, all tests will be marked as
skipped. You will need to remove the `.skip` calls before you can see if a
particular test will pass or fail.

For example, a test:
```javascript
test.skip("some test", function() {
    // Test code is here
});
```

Would become:
```javascript
test("some test", function() {
    // Test code is here
});
```
