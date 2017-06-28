package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.Stack;
import com.on_site.kamayan.collections.StackOverflowException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Diagram of a stack:
 *
 *  New elements are added here
 *    |
 *    +-->
 *         +---+
 *         | z | <--- Elements are removed from here
 *         +---+
 *         | y |
 *         +---+
 *         | x |
 *         +---+
 *
 *
 * Diagram of a stack as you run operations on it:
 *
 *   Empty    push(a)  push(b)  push(c)
 *   Stack
 *                              +---+
 *                              | c |
 *                     +---+    +---+
 *                     | b |    | b |
 *            +---+    +---+    +---+
 *            | a |    | a |    | a |
 *   +===+    +---+    +---+    +---+
 *
 *
 *   peek()   pop()    peek()   pop()    pop()
 *   => c     => c     => b     => b     => a
 *
 *   +---+
 *   | c |
 *   +---+    +---+    +---+
 *   | b |    | b |    | b |
 *   +---+    +---+    +---+    +---+
 *   | a |    | a |    | a |    | a |
 *   +---+    +---+    +---+    +---+    +===+
 */
public class Serving_05_StacksTest extends TestCase {
    @Test
    public void testInternalCollectionImplementsEach() throws Exception {
        // The each method will be used for other tests, so if you decided not
        // to use the DoublyLinkedList, you will need to implement `each` for
        // your chosen collection.
        Object internalList = Kamayan.getField(new Stack(), Object.class, "list");
        assertMethodExists(internalList, "each", Consumer.class);
    }

    private ArrayList<Object> getActualElements(Stack stack) {
        ArrayList<Object> result = new ArrayList<>();
        Consumer<Object> eachFn = (element) -> result.add(element);
        Object internalList = Kamayan.getField(stack, Object.class, "list");
        Kamayan.send(internalList, Object.class, "each", eachFn);
        return result;
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushAddsElements() throws Exception {
        Stack stack = new Stack();
        stack.push(42);
        assertEquals(1, stack.size());

        stack.push(43);
        stack.push(1);
        stack.push(2);
        assertEquals(4, stack.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushAddsToTheTopOfTheStack() throws Exception {
        Stack stack = new Stack();
        stack.push(42);
        ArrayList<Object> actualElements = getActualElements(stack);
        assertEquals(Arrays.asList(42), actualElements);

        stack.push(43);
        stack.push(1);
        stack.push(2);
        actualElements = getActualElements(stack);
        assertEquals(Arrays.asList(42, 43, 1, 2), actualElements);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushReturnsSelfSoItCanBeChained() throws Exception {
        Stack stack = new Stack();
        assertEquals(stack, stack.push(42));
        assertEquals(stack, stack.push(43));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushWithNoMaxSizeShouldntOverflow() throws Exception {
        Stack stack = new Stack();
        Kamayan.times(1000, (i) -> stack.push(42));
        assertEquals(1000, stack.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushBeyondMaxSizeThrowsStackOverflowException() throws Exception {
        Stack stack = new Stack(5);
        stack.push(42).push(43).push(1).push(2).push(3);
        assertThrows(StackOverflowException.class, () -> stack.push(4));
        assertThrows(StackOverflowException.class, () -> stack.push(5));

        Stack otherStack = new Stack(6);
        otherStack.push(42).push(43).push(1).push(2).push(3).push(4);
        assertThrows(StackOverflowException.class, () -> otherStack.push(44));
        assertThrows(StackOverflowException.class, () -> otherStack.push(45));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPushBeyondMaxSizeDoesntAddToSizeOrElements() throws Exception {
        Stack stack = new Stack(5);
        stack.push(42).push(43).push(1).push(2).push(3);
        assertThrows(StackOverflowException.class, () -> stack.push(4));
        assertThrows(StackOverflowException.class, () -> stack.push(5));
        assertEquals(5, stack.size());
        ArrayList<Object> actualElements = getActualElements(stack);
        assertEquals(Arrays.asList(42, 43, 1, 2, 3), actualElements);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPopRaisesAnErrorIfTheStackIsEmpty() throws Exception {
        Stack stack = new Stack();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPopReturnsTheLastElementOfTheStack() throws Exception {
        Stack stack = new Stack().push(42);
        assertEquals(42, stack.pop());
        stack.push(43);
        assertEquals(43, stack.pop());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPopAltersTheSizeOfTheStack() throws Exception {
        Stack stack = new Stack().push(42).push(43);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPopRaisesAnErrorIfTheStackIsEmptyAfterBeingEmptied() throws Exception {
        Stack stack = new Stack().push(42);
        stack.pop();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.pop());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPopReturnsTheLastElementAdded() throws Exception {
        Stack stack = new Stack().push(42).push(43).push(1).push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(43, stack.pop());
        assertEquals(42, stack.pop());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testEmptyReturnsTrueForNewStacks() throws Exception {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
        stack.push(42);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testEmptyReturnsTrueForStacksThatHaveBeenEmptied() throws Exception {
        Stack stack = new Stack().push(42);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testEmptyReturnsFalseForNonEmptyStacks() throws Exception {
        Stack stack = new Stack().push(42);
        assertFalse(stack.isEmpty());
        stack.push(43);
        assertFalse(stack.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testEmptyReturnsFalseForStacksThatHaveBeenEmptiedAndGrownAgain() throws Exception {
        Stack stack = new Stack().push(42).push(43);
        stack.pop();
        stack.pop();
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPeekRaisesAnErrorIfTheStackIsEmpty() throws Exception {
        Stack stack = new Stack();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
        stack.push(42);
        stack.pop();
        assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPeekReturnsTheTopValueOfTheStack() throws Exception {
        Stack stack = new Stack().push(42);
        assertEquals(42, stack.peek());
        stack.push(43);
        assertEquals(43, stack.peek());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void testPeekCanBeCalledMultipleTimesWithoutAffectingTheSize() throws Exception {
        Stack stack = new Stack().push(42);
        assertEquals(42, stack.peek());
        assertEquals(42, stack.peek());
        assertEquals(42, stack.peek());
        assertEquals(1, stack.size());
        stack.push(43);
        assertEquals(43, stack.peek());
        assertEquals(43, stack.peek());
        assertEquals(43, stack.peek());
        assertEquals(2, stack.size());
    }
}
