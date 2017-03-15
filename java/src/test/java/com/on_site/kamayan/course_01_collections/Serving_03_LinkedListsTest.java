package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.Ref;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.LinkedList;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This serving is similar to the last, except instead of implementing an Array
 * class in terms of FixedArray, you will be implementing it in terms of a
 * series of links that form what is called a Linked List. You can find a stub
 * of the class in
 * src/main/java/com/on_site/kamayan/collections/LinkedList.java, while the
 * tests here will help ensure you have implemented the core features.
 *
 * You may only use the nested Node class for storing the contents of the
 * LinkedList. Do not be afraid to add new methods as you see fit, but keep any
 * new methods private.
 *
 * Further instructions can be found inside the LinkedList class.
 *
 * Once you have finished implementing the LinkedList, contemplate the
 * differences between the ArrayList and the LinkedList, and when you might use
 * one versus the other... the pros and cons of the two.
 *
 * Diagram of a linked list:
 *
 *   list.size() == 3
 *
 *   @head
 *     |
 *     v
 *   +---+              +---+      +---+
 *   | a | -- child --> | b | ---> | c | ---> null
 *   +---+              +---+      +---+
 */
public class Serving_03_LinkedListsTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void prependAddsToTheBeginning() {
        LinkedList list = new LinkedList();
        list.prepend(42);
        assertNotNull(Kamayan.getField(list, Object.class, "head"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        list.prepend(43);
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "value"));
        assertNotNull(Kamayan.getField(list, Object.class, "head", "child"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependIncreasesTheSize() {
        LinkedList list = new LinkedList();
        list.prepend(42);
        assertEquals(1, list.size());
        list.prepend(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependReturnsThisSoThatItIsChainable() {
        LinkedList list = new LinkedList();
        list.prepend(42).prepend(43);
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependCanBeCalledALot() {
        LinkedList list = new LinkedList();
        Kamayan.times(100, (i) -> list.prepend(42));
        assertEquals(100, list.size());

        Ref<Object> node = Ref.of(Kamayan.getField(list, Object.class, "head"));
        Kamayan.times(100, (i) -> {
            assertNotNull(node.get());
            assertEquals(42, Kamayan.getField(node.get(), Integer.class, "value"));
            node.set(Kamayan.getField(node.get(), Object.class, "child"));
        });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAddsToTheEnd() {
        LinkedList list = new LinkedList();
        list.add(42);
        assertNotNull(Kamayan.getField(list, Object.class, "head"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        list.add(43);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        assertNotNull(Kamayan.getField(list, Object.class, "head", "child"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addIncreasesTheSize() {
        LinkedList list = new LinkedList();
        list.add(42);
        assertEquals(1, list.size());
        list.add(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addReturnsThisSoThatItIsChainable() {
        LinkedList list = new LinkedList();
        list.add(42).add(43);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addCanBeCalledALot() {
        LinkedList list = new LinkedList();
        Kamayan.times(100, (i) -> list.add(42));
        assertEquals(100, list.size());

        Ref<Object> node = Ref.of(Kamayan.getField(list, Object.class, "head"));
        Kamayan.times(100, (i) -> {
            assertNotNull(node.get());
            assertEquals(42, Kamayan.getField(node.get(), Integer.class, "value"));
            node.set(Kamayan.getField(node.get(), Object.class, "child"));
        });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAndPrependAreChainableTogether() {
        LinkedList list = new LinkedList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(1, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(2, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "child", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "child", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void chainedAddAndPrependIncreasesTheSize() {
        LinkedList list = new LinkedList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getCannotGoOutsideTheBoundsOfTheList() {
        LinkedList list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(-1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(-42); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(0); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(1); });
        list.add(1);
        list.get(0); // No error now that the index is valid
        assertThrows(IndexOutOfBoundsException.class, () -> { list.get(1); });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void getCanRetrieveAnyElement() {
        LinkedList list = new LinkedList().add(1).add(2).add(42).add(43);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(42, list.get(2));
        assertEquals(43, list.get(3));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCannotUseNegativeNumber() {
        LinkedList list = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> { list.set(-1, 1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.set(-42, 1); });
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanUseExistingIndexes() {
        LinkedList list = new LinkedList().add(0).add(1).add(2).add(3);
        list.set(0, 1);
        list.set(1, 2);
        list.set(2, 3);
        list.set(3, 4);
        Kamayan.times(4, (i) -> assertEquals(i + 1, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setWithExistingIndexesDoesntUpdateTheSize() {
        LinkedList list = new LinkedList().add(0).add(1).add(2).add(3);
        list.set(0, 1);
        assertEquals(4, list.size());
        list.set(1, 2);
        assertEquals(4, list.size());
        list.set(2, 3);
        assertEquals(4, list.size());
        list.set(3, 4);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanAddElementsToTheEndOfTheList() {
        LinkedList list = new LinkedList();
        list.set(0, 1);
        list.set(1, 2);
        list.set(2, 3);
        list.set(3, 4);
        Kamayan.times(4, (i) -> assertEquals(i + 1, list.get(i)));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setUpdatesTheSizeWhenAddingToTheEndOfTheList() {
        LinkedList list = new LinkedList();
        list.set(0, 1);
        assertEquals(1, list.size());
        list.set(1, 2);
        assertEquals(2, list.size());
        list.set(2, 3);
        assertEquals(3, list.size());
        list.set(3, 4);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setCanUseDistantIndexes() {
        LinkedList list = new LinkedList();
        list.set(42, 1);
        list.set(142, 2);
        list.set(1042, 3);
        Kamayan.range(0, 41, (i) -> assertNull(list.get(i)));
        Kamayan.range(43, 141, (i) -> assertNull(list.get(i)));
        Kamayan.range(143, 1041, (i) -> assertNull(list.get(i)));
        assertEquals(1, list.get(42));
        assertEquals(2, list.get(142));
        assertEquals(3, list.get(1042));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setWithDistantIndexesUpdatesTheSize() {
        LinkedList list = new LinkedList();
        list.set(42, 1);
        assertEquals(43, list.size());
        list.set(142, 2);
        assertEquals(143, list.size());
        list.set(1042, 3);
        assertEquals(1043, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsNullIfThePreviousValueWasNull() {
        LinkedList list = new LinkedList().add(null);
        assertNull(list.set(0, 42));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsNullIfTheIndexIsBeyondTheCurrentSize() {
        LinkedList list = new LinkedList();
        assertNull(list.set(0, 42));
        assertNull(list.set(42, 43));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void setReturnsThePreviousValue() {
        LinkedList list = new LinkedList().add(1).add(2).add(3);
        assertEquals(1, list.set(0, 42));
        assertEquals(42, list.set(0, 43));
        assertEquals(2, list.set(1, 44));
        assertEquals(3, list.set(2, 45));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteCannotDeleteOutsideTheBoundsOfTheLinkedList() {
        LinkedList list = new LinkedList().add(1).add(2).add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.delete(-1); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.delete(-42); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.delete(3); });
        assertThrows(IndexOutOfBoundsException.class, () -> { list.delete(42); });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteRemovesTheElement() {
        LinkedList list = new LinkedList().add(1).add(2).add(3);
        list.delete(1);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteReturnsTheElementAtTheIndex() {
        LinkedList list = new LinkedList().add(1).add(2).add(3);
        assertEquals(1, list.delete(0));
        assertEquals(3, list.delete(1));
        assertEquals(2, list.delete(0));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteUpdatesTheSize() {
        LinkedList list = new LinkedList().add(1).add(2).add(3);
        list.delete(1);
        assertEquals(2, list.size());
        list.delete(0);
        assertEquals(1, list.size());
        list.delete(0);
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteCanBeCalledALot() {
        LinkedList list = new LinkedList();
        Kamayan.times(100, (i) -> list.add(42));
        Kamayan.times(100, (i) -> list.delete(0));
        assertEquals(0, list.size());
    }
}
