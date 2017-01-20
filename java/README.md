# Java Kamayan

## Setup

Before you can start, you need to [install maven](http://maven.apache.org/install.html).
You might be able to use a package manager to install it easier (such as `brew`
for MacOS or `apt-get` for Ubuntu).

## Running the Java Kamayan

Once you have maven installed, you just need to run `mvn test`. This will run
all the tests, showing you which ones have failed.

After you have completed the first serving, all tests will be marked as
ignored. You will need to remove or comment out the `@Ignore` lines before you
can see if a particular test will pass or fail.
