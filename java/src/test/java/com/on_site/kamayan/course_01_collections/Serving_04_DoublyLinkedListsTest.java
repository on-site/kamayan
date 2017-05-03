package com.on_site.kamayan.course_01_collections;

import com.on_site.kamayan.Kamayan;
import com.on_site.kamayan.Ref;
import com.on_site.kamayan.TestCase;
import com.on_site.kamayan.collections.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This serving will build on what you made in the last serving. A doubly linked
 * list is the same as a linked list, except each node points to both the
 * previous and the next node in the list. This collection is ideal for when you
 * only want to interact with the first or last item of a collection.
 *
 * Feel free to copy any code you wrote for the LinkedList into the
 * DoublyLinkedList, though you might need to add to the behavior. You will find
 * the stub class in DoublyLinkedList.java along with further instructions.
 *
 * Diagram of a doubly linked list:
 *
 *             @size = 3
 *
 *             @head                         @tail
 *               |                             |
 *               v                             v
 *             +---+ -- child --> +---+ ---> +---+ ---> null
 *             | a |              | b |      | c |
 *   null <--- +---+ <-- prev --- +---+ <--- +---+
 */
public class Serving_04_DoublyLinkedListsTest extends TestCase {
    @Ignore("Remove this line to run this test")
    @Test
    public void prependAddsToTheBeginning() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(42);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        list.prepend(43);
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependUpdatesPreviousLinks() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertNull(Kamayan.getField(list, Object.class, "tail"));
        list.prepend(42);
        assertEquals(42, Kamayan.getField(list, Object.class, "tail", "value"));
        list.prepend(43);
        assertEquals(42, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "tail", "previous", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous", "previous"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependIncreasesTheSize() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(42);
        assertEquals(1, list.size());
        list.prepend(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependReturnsThisSoThatItIsChainable() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(42).prepend(43);
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void prependCanBeCalledALot() {
        DoublyLinkedList list = new DoublyLinkedList();
        Kamayan.times(100, (i) -> list.prepend(42));
        assertEquals(100, list.size());

        Ref<Object> node = Ref.of(Kamayan.getField(list, Object.class, "head"));
        Kamayan.times(100, (i) -> {
            assertEquals(42, Kamayan.getField(node.get(), Integer.class, "value"));
            node.set(Kamayan.getField(node.get(), Object.class, "child"));
        });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAddsToTheEnd() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(42);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        list.add(43);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addUpdatesPreviousLinks() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertNull(Kamayan.getField(list, Object.class, "tail"));
        list.add(42);
        assertEquals(42, Kamayan.getField(list, Integer.class, "tail", "value"));
        list.add(43);
        assertEquals(43, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "tail", "previous", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous", "previous"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addIncreasesTheSize() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(42);
        assertEquals(1, list.size());
        list.add(43);
        assertEquals(2, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addReturnsThisSoThatItIsChainable() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(42).add(43);
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addCanBeCalledALot() {
        DoublyLinkedList list = new DoublyLinkedList();
        Kamayan.times(100, (i) -> list.add(42));
        assertEquals(100, list.size());

        Ref<Object> node = Ref.of(Kamayan.getField(list, Object.class, "head"));
        Kamayan.times(100, (i) -> {
            assertEquals(42, Kamayan.getField(node.get(), Integer.class, "value"));
            node.set(Kamayan.getField(node.get(), Object.class, "child"));
        });
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void addAndPrependAreChainableTogether() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(1, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(2, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertEquals(42, Kamayan.getField(list, Integer.class, "head", "child", "child", "value"));
        assertEquals(43, Kamayan.getField(list, Integer.class, "head", "child", "child", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child", "child", "child"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void chainedAddAndPrependIncreasesTheSize() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(42).add(43).prepend(2).prepend(1);
        assertEquals(4, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void firstCannotBeCalledOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.first());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void firstReturnsTheFirstElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1);
        assertEquals(1, list.first());
        list.prepend(2);
        assertEquals(2, list.first());
        list.prepend(42);
        assertEquals(42, list.first());
        list.prepend(43);
        assertEquals(43, list.first());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void lastCannotBeCalledOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.last());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void lastReturnsTheLastElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1);
        assertEquals(1, list.last());
        list.add(2);
        assertEquals(2, list.last());
        list.add(42);
        assertEquals(42, list.last());
        list.add(43);
        assertEquals(43, list.last());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstCannotDeleteFromAnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteFirst());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstRemovesTheFirstElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteFirst();
        assertEquals(2, list.first());
        list.deleteFirst();
        assertEquals(3, list.first());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstReturnsTheDeletedElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        assertEquals(1, list.deleteFirst());
        assertEquals(2, list.deleteFirst());
        assertEquals(3, list.deleteFirst());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstUpdatesTheSize() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteFirst();
        assertEquals(2, list.size());
        list.deleteFirst();
        assertEquals(1, list.size());
        list.deleteFirst();
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstCanBeCalledALot() {
        DoublyLinkedList list = new DoublyLinkedList();
        Kamayan.times(100, (i) -> list.add(42));
        Kamayan.times(100, (i) -> list.deleteFirst());
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstUpdatesChildLinks() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteFirst();
        assertEquals(2, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(3, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));

        list.deleteFirst();
        assertEquals(3, Kamayan.getField(list, Integer.class, "head", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child"));

        list.deleteFirst();
        assertNull(Kamayan.getField(list, Object.class, "head"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteFirstUpdatesPreviousLinks() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteFirst();
        assertEquals(3, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertEquals(2, Kamayan.getField(list, Integer.class, "tail", "previous", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous", "previous"));

        list.deleteFirst();
        assertEquals(3, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous"));

        list.deleteFirst();
        assertNull(Kamayan.getField(list, Object.class, "tail"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastCannotDeleteFromAnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteLast());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastRemovesTheLastElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteLast();
        assertEquals(2, list.last());
        list.deleteLast();
        assertEquals(1, list.last());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastReturnsTheDeletedElement() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        assertEquals(3, list.deleteLast());
        assertEquals(2, list.deleteLast());
        assertEquals(1, list.deleteLast());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastUpdatesTheSize() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteLast();
        assertEquals(2, list.size());
        list.deleteLast();
        assertEquals(1, list.size());
        list.deleteLast();
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastCanBeCalledALot() {
        DoublyLinkedList list = new DoublyLinkedList();
        Kamayan.times(100, (i) -> list.add(42));
        Kamayan.times(100, (i) -> list.deleteLast());
        assertEquals(0, list.size());
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastUpdatesChildLinks() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteLast();
        assertEquals(1, Kamayan.getField(list, Integer.class, "head", "value"));
        assertEquals(2, Kamayan.getField(list, Integer.class, "head", "child", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child", "child"));

        list.deleteLast();
        assertEquals(1, Kamayan.getField(list, Integer.class, "head", "value"));
        assertNull(Kamayan.getField(list, Object.class, "head", "child"));

        list.deleteLast();
        assertNull(Kamayan.getField(list, Object.class, "head"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void deleteLastUpdatesPreviousLinks() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(3);
        list.deleteLast();
        assertEquals(2, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertEquals(1, Kamayan.getField(list, Integer.class, "tail", "previous", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous", "previous"));

        list.deleteLast();
        assertEquals(1, Kamayan.getField(list, Integer.class, "tail", "value"));
        assertNull(Kamayan.getField(list, Object.class, "tail", "previous"));

        list.deleteLast();
        assertNull(Kamayan.getField(list, Object.class, "tail"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachYieldsToNothingWhenTheListIsEmpty() {
        new DoublyLinkedList().each((element) -> fail("Expected no yield!"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachYieldsToTheElementsInOrder() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(42).add(43);
        ArrayList<Object> actualElements = new ArrayList<>();
        list.each((element) -> actualElements.add(element));
        assertEquals(Arrays.asList(1, 2, 42, 43), actualElements);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachReturnsThisSoItCanBeChained() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(list, list.each((element) -> { }));

        list.add(1).add(2).add(42).add(43);
        assertEquals(list, list.each((element) -> { }));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachReversedYieldsToNothingWhenTheListIsEmpty() {
        new DoublyLinkedList().eachReversed((element) -> fail("Expected no yield!"));
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachReversedYieldsToTheElementsInReverseOrder() {
        DoublyLinkedList list = new DoublyLinkedList().add(1).add(2).add(42).add(43);
        ArrayList<Object> actualElements = new ArrayList<>();
        list.eachReversed((element) -> actualElements.add(element));
        assertEquals(Arrays.asList(43, 42, 2, 1), actualElements);
    }

    @Ignore("Remove this line to run this test")
    @Test
    public void eachReversedReturnsThisSoItCanBeChained() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(list, list.eachReversed((element) -> { }));

        list.add(1).add(2).add(42).add(43);
        assertEquals(list, list.eachReversed((element) -> { }));
    }
}
