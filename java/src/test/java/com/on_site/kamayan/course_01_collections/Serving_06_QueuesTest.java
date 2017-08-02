package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Diagram of a queue:
 *
 *     New elements are added here
 *                |
 *                v
 *  +---+---+---+
 *  | x | y | z |
 *  +---+---+---+
 *    ^
 *    |
 *  Elements are removed from here
 *
 *
 * Diagram of a queue as you run operations on it:
 *
 *                 +
 *   Empty queue:  |
 *                 +
 *
 *                 +---+
 *   enqueue(a):   | a |
 *                 +---+
 *
 *                 +---+---+
 *   enqueue(b):   | a | b |
 *                 +---+---+
 *
 *                 +---+---+---+
 *   enqueue(c):   | a | b | c |
 *                 +---+---+---+
 *
 *   peek()
 *   => a
 *
 *                 +---+---+
 *   dequeue():    | b | c |
 *   => a          +---+---+
 *
 *   peek()
 *   => b
 *
 *                 +---+
 *   dequeue():    | c |
 *   => b          +---+
 *
 *   peek()
 *   => c
 *
 *                 +
 *   dequeue():    |
 *   => c          +
 */
public class Serving_06_QueuesTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void internalCollectionImplementsEach() throws Exception {
        // The each method will be used for other tests, so if you decided not to use
        // the DoublyLinkedList, you will need to implement `each` for your chosen
        // collection.
        Object internalList = Kamayan.getField(new Queue(), Object.class, "list");
        assertMethodExists(internalList, "each", Consumer.class);
    }

    private ArrayList<Object> getActualElements(Queue queue) {
        ArrayList<Object> result = new ArrayList<>();
        Consumer<Object> eachFn = (element) -> result.add(element);
        Object internalList = Kamayan.getField(queue, Object.class, "list");
        Kamayan.send(internalList, Object.class, "each", eachFn);
        return result;
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void enqueueAddsElements() throws Exception {
        Queue queue = new Queue();
        queue.enqueue(42);
        assertEquals(1, queue.size());

        queue.enqueue(43);
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(4, queue.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void enqueueAddsToTheEndOfTheQueue() throws Exception {
        Queue queue = new Queue();
        queue.enqueue(42);
        ArrayList<Object> actualElements = getActualElements(queue);
        assertEquals(Arrays.asList(42), actualElements);

        queue.enqueue(43);
        queue.enqueue(1);
        queue.enqueue(2);
        actualElements = getActualElements(queue);
        assertEquals(Arrays.asList(42, 43, 1, 2), actualElements);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void enqueueReturnsSelfSoItCanBeChained() throws Exception {
        Queue queue = new Queue();
        assertEquals(queue, queue.enqueue(42));
        assertEquals(queue, queue.enqueue(43));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void enqueueCanBeCalledALot() throws Exception {
        Queue queue = new Queue();
        Kamayan.times(1000, (i) -> queue.enqueue(42));
        assertEquals(1000, queue.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void dequeueRaisesAnErrorIfTheQueueIsEmpty() throws Exception {
        Queue queue = new Queue();
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void dequeueReturnsTheFirstElementOfTheQueue() throws Exception {
        Queue queue = new Queue().enqueue(42);
        assertEquals(42, queue.dequeue());
        queue.enqueue(43);
        assertEquals(43, queue.dequeue());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void dequeueAltersTheSizeOfTheQueue() throws Exception {
        Queue queue = new Queue().enqueue(42).enqueue(43);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void dequeueRaisesAnErrorIfTheQueueIsEmptyAfterBeingEmptied() throws Exception {
        Queue queue = new Queue().enqueue(42);
        queue.dequeue();
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void dequeueReturnsTheFirstElementAdded() throws Exception {
        Queue queue = new Queue().enqueue(42).enqueue(43).enqueue(1).enqueue(2);
        assertEquals(42, queue.dequeue());
        assertEquals(43, queue.dequeue());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void emptyReturnsTrueForNewQueues() throws Exception {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());
        queue.enqueue(42);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void emptyReturnsTrueForQueuesThatHaveBeenEmptied() throws Exception {
        Queue queue = new Queue().enqueue(42);
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void emptyReturnsFalseForNonEmptyQueues() throws Exception {
        Queue queue = new Queue().enqueue(42);
        assertFalse(queue.isEmpty());
        queue.enqueue(43);
        assertFalse(queue.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void emptyReturnsFalseForQueuesThatHaveBeenEmptiedAndGrownAgain() throws Exception {
        Queue queue = new Queue().enqueue(42).enqueue(43);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void peekRaisesAnErrorIfTheQueueIsEmpty() throws Exception {
        Queue queue = new Queue();
        assertThrows(IndexOutOfBoundsException.class, () -> queue.peek());
        queue.enqueue(42);
        queue.dequeue();
        assertThrows(IndexOutOfBoundsException.class, () -> queue.peek());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void peekReturnsTheFirstValueOfTheQueue() throws Exception {
        Queue queue = new Queue().enqueue(42);
        assertEquals(42, queue.peek());
        queue.enqueue(43);
        assertEquals(42, queue.peek());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void peekCanByCalledMultipleTimesWithoutAffectingTheSize() throws Exception {
        Queue queue = new Queue().enqueue(42);
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(1, queue.size());
        queue.enqueue(43);
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek());
        assertEquals(2, queue.size());
    }
}
